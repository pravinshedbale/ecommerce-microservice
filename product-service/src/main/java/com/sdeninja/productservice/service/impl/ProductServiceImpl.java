package com.sdeninja.productservice.service.impl;

import com.sdeninja.productservice.entity.Product;
import com.sdeninja.productservice.exception.ProductServiceException;
import com.sdeninja.productservice.model.ProductRequest;
import com.sdeninja.productservice.model.ProductResponse;
import com.sdeninja.productservice.repository.ProductRepository;
import com.sdeninja.productservice.service.ProductService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Log4j2
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public UUID addProduct(ProductRequest productRequest) {
        log.info("Adding product");
        Product product = Product.builder()
                .productName(productRequest.getName())
                .quantity(productRequest.getQuantity())
                .price(productRequest.getPrice())
                .build();
        productRepository.save(product);
        log.info("Product created");
        return product.getId();
    }

    @Override
    public ProductResponse getProductById(UUID id) {
        log.info("Getting product : " + id);
        Product product = productRepository.findById(id).orElseThrow(() -> new ProductServiceException("Product not found with id : " + id, "PRODUCT_NOT_FOUND"));
        ProductResponse productResponse = ProductResponse.builder()
                .productName(product.getProductName())
                .id(product.getId())
                .price(product.getPrice())
                .quantity(product.getQuantity())
                .build();
        return productResponse;
    }
}
