package com.dev.wizard.domain.dto;

import lombok.Data;

@Data
public class OrderDTO {
    private String id;

    private Double price;

    private Integer number;
}
