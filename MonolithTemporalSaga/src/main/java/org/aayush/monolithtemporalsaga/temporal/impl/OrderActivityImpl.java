package org.aayush.monolithtemporalsaga.temporal.impl;

import org.aayush.monolithtemporalsaga.model.OrderDetails;
import org.aayush.monolithtemporalsaga.temporal.OrderActivity;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class OrderActivityImpl implements OrderActivity {


    @Override
    public Mono<OrderDetails> createOrder(OrderDetails orderDetails) {
        System.out.println("Order created for : {}" + orderDetails);
        return Mono.just(orderDetails);
    }
}
