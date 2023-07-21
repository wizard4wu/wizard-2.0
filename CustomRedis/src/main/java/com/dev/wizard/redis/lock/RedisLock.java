package com.dev.wizard.redis.lock;

import java.util.function.Supplier;

public interface RedisLock {

    String LOCK_PREFIX = "lock_";

    boolean lock(String key);

    boolean lock(String key, long expiredTime);

    boolean unLock(String key);

    <T> T executeWithRedisLock(String lockKey, long lockExpriedTime, long tryLockTime, Supplier<T> suppierForBiz);

}
