package com.dev.wizard.redis.lock;

import jodd.util.StringUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;

import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

@Slf4j
public abstract class AbstraRedisLock implements RedisLock {
    private static final ThreadLocal<Long> TIMER = new ThreadLocal<>();
    private static final ThreadLocal<String> UUID_THREAD = new ThreadLocal<>();
    protected static final DefaultRedisScript<Long> UNLOCK_SCRIPT;
    static {
        UNLOCK_SCRIPT = new DefaultRedisScript<>();
        UNLOCK_SCRIPT.setLocation(new ClassPathResource("/script/unlock.lua"));
        UNLOCK_SCRIPT.setResultType(Long.class);
    }

    @Autowired
    protected StringRedisTemplate redisTemplate;
    @Value("${redis.lock.expiredTime}")
    protected int expiredTime;

    @Override
    public boolean lock(String key) {
        String id = getThreadUUID();
        Boolean result = redisTemplate.opsForValue().setIfAbsent(LOCK_PREFIX + key, id, expiredTime, TimeUnit.SECONDS);
        return Boolean.TRUE.equals(result);
    }

    public boolean lock(String key, long expiredTime) {
        String id = getThreadUUID();
        Boolean result = redisTemplate.opsForValue().setIfAbsent(LOCK_PREFIX + key, id, expiredTime, TimeUnit.SECONDS);

        return Boolean.TRUE.equals(result);
    }

    public <T> T executeWithRedisLock(String lockKey, long lockExpriedTime, long tryLockTime, Supplier<T> suppierForBiz){
        long currentTime = System.nanoTime() + tryLockTime * 1_000_000_000;
        int counter = 0;
        while (currentTime > System.nanoTime()){
            //lock successfully -> excute the biz code
            if(lock(lockKey, lockExpriedTime)){
                try{
                    return suppierForBiz.get();
                }catch (Exception e){
                    log.info("execute biz exception");
                }finally {
                    unLock(lockKey);
                }
            }else {
                if(counter < 4){
                    counter ++;
                    continue;
                }
                try {
                    Thread.sleep(100);
                    counter = 0;
                } catch (InterruptedException e) {
                }
            }
        }
        log.error("lock failed");
        throw new RuntimeException();
    }
    protected static String getThreadUUID(){
        String threadUUID = UUID_THREAD.get();
        if(StringUtil.isNotBlank(threadUUID)){
            return threadUUID;
        }
        threadUUID = UUID.randomUUID() + "." + Thread.currentThread().getId();
        UUID_THREAD.set(threadUUID);
        return threadUUID;
    }

    protected static void removeThreadUUID(){
        UUID_THREAD.remove();;
    }
    protected static void setTimeInThread(){
        TIMER.set(System.nanoTime());
    }
    protected static Long getTime(){
        return TIMER.get();
    }
    protected static void removeTimer(){
        TIMER.remove();;
    }
}
