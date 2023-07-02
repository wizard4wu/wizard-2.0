package com.dev.wizard.redis.common;

import com.dev.wizard.redis.domain.Order;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

@Component
public class PageCacheComponents {

    @Autowired
    private StringRedisTemplate redisTemplate;

    private static ObjectMapper objectMapper = new ObjectMapper();
    static {
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
    }

    public <T> boolean addData2Page(String key, PageCacheData<T> pageCacheData) {
        try {
            String payloadString = objectMapper.writeValueAsString(pageCacheData.retrievePayload());
            return Boolean.TRUE.equals(redisTemplate.opsForZSet().add(key, payloadString, pageCacheData.retrieveToken()));
        }catch (Exception e){

        }
        return false;
    }

    public <T> boolean removeDataFromPage(String key, PageCacheData<T> pageCacheData){
        if(null == pageCacheData.retrievePayload()){
            return false;
        }
        return redisTemplate.opsForZSet().remove(key, pageCacheData.retrieveToken()) > 0;
    }

    /**
     * 1.当使用分页查询时，nextPageToken要设置成最小值Double.NEGATIVE_INFINITY，直接使用offset和pageSize即可
     * 2.当使用view more查询时，offset要设置成0，直接使用nextPageToken和pageSize
     * 但对于startToken而言的话，要取上一条数据的最后一条数据的时间戳
     * @param key
     * @param nextPageToken
     * @param offset
     * @param pageSize
     * @return
     * @param <T>
     */
    public <T> Collection<T> getPayloadByToken(String key, double nextPageToken, int offset, int pageSize){
        Set<String> set = redisTemplate.opsForZSet().rangeByScore(key, nextPageToken, Double.POSITIVE_INFINITY, offset, pageSize);
        //反序显示
        //Set<String> set = redisTemplate.opsForZSet().reverseRangeByScore(key, Double.NEGATIVE_INFINITY, startToken, offset, pageSize);
        try {

            return set.stream().map(value ->{
                try {
                    return objectMapper.readValue(value, new TypeReference<T>() {});
                } catch (JsonProcessingException e) {
                    throw new RuntimeException(e);
                }
            }).collect(Collectors.toList());
        }catch (Exception e){
        }
       return Collections.emptyList();
    }



    public <V> Collection<V> getPageData(String key, double startToken, int offset, int pageSize){
        Collection<String> ids = this.getPayloadByToken(key, startToken, offset, pageSize);
        List<String> objList = redisTemplate.opsForValue().multiGet(ids).stream().filter(Objects::nonNull).collect(Collectors.toList());
        return objList.stream().map(order -> {
            try {
                return objectMapper.readValue(order, new TypeReference<V>() {});
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        }).collect(Collectors.toList());
    }

}
