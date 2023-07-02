package com.dev.wizard.redis.domain;

import com.dev.wizard.redis.common.PageCacheData;
import lombok.Data;

import java.time.Instant;

@Data
public class Order implements PageCacheData<String> {

    private String productId;

    private String orderId;

    private String orderName;

    private Instant startTime;

    private Instant endTime;

    @Override
    public String retrievePayload() {
        return getOrderId();
    }

    @Override
    public double retrieveToken() {
        return getStartTime().toEpochMilli();
    }
}
