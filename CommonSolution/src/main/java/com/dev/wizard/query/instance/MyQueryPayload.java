package com.dev.wizard.query.instance;

import com.dev.wizard.query.PageResultPayload;
import lombok.Data;

import java.time.Instant;
@Data
public class MyQueryPayload implements PageResultPayload<Instant> {

    private String productId;

    private String orderId;

    private Instant createdTime;

    public Instant retrieveNextPageToken(){
        return createdTime;
    };
}
