package org.aayush.monolithtemporalsaga.temporal;

import io.temporal.activity.ActivityInterface;
import org.aayush.monolithtemporalsaga.model.Shipping;

@ActivityInterface
public interface ShippingActivity {

    boolean shipOrder(String orderId);
    boolean cancelShipping(String orderId);
}
