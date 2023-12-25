package com.sdeninja.productservice.model;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class ProductResponse {
    private UUID id;
    private String productName;
    private long quantity;
    private long price;
}
