package org.aayush.monolithtemporalsaga.temporal.impl;

import org.aayush.monolithtemporalsaga.model.Product;
import org.aayush.monolithtemporalsaga.temporal.ProductInfoActivity;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class ProductInfoActivityImpl implements ProductInfoActivity {

    @Override
    public String getProductInfo(String productId) {
        return "Product info for product ID: " + productId;

    }
}
