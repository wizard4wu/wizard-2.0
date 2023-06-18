package com.dev.wizard.redis.domain;

import lombok.Data;

import java.time.Instant;

@Data
public class Order {

    private String productId;

    private String orderId;

    private String orderName;

    private Instant startTime;

    private Instant endTime;
}
