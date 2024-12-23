package org.aayush.monolithtemporalsaga.temporal;

import io.temporal.activity.ActivityInterface;
import org.aayush.monolithtemporalsaga.model.Product;
import reactor.core.publisher.Mono;

@ActivityInterface
public interface ProductInfoActivity {

    String getProductInfo(String productId);
}
