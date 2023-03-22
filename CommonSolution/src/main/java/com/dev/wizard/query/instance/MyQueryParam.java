package com.dev.wizard.query.instance;

import com.dev.wizard.query.QueryParam;
import lombok.Data;

import java.time.Instant;

@Data
public class MyQueryParam extends QueryParam<Instant> {

    private String productId;
    private Instant created_time;

    public String retrieveBizKey() {
        return "product_" + productId;
    }
}
