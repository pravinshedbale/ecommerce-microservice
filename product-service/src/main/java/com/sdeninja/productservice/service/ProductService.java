package com.sdeninja.productservice.service;

import com.sdeninja.productservice.model.ProductRequest;
import com.sdeninja.productservice.model.ProductResponse;

import java.util.UUID;

public interface ProductService {
    UUID addProduct(ProductRequest productRequest);

    ProductResponse getProductById(UUID id);
}
