package com.dev.wizard.redis.dto;

import lombok.Data;

import java.time.Instant;

@Data
public class OrderDTO {

    private String productId;

    private String orderId;

    private String orderName;

    private Instant startTime;

    private Instant endTime;
}
