package org.aayush.monolithtemporalsaga.temporal;

import io.temporal.activity.ActivityInterface;
import org.aayush.monolithtemporalsaga.model.OrderDetails;
import reactor.core.publisher.Mono;

@ActivityInterface
public interface OrderActivity {

    Mono<OrderDetails> createOrder(OrderDetails orderDetails);
}
