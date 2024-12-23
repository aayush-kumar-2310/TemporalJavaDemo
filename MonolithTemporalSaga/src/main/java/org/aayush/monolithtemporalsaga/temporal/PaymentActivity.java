package org.aayush.monolithtemporalsaga.temporal;

import io.temporal.activity.ActivityInterface;
import org.aayush.monolithtemporalsaga.model.OrderDetails;
import org.aayush.monolithtemporalsaga.model.Payment;
import org.aayush.monolithtemporalsaga.model.Shipping;

@ActivityInterface
public interface PaymentActivity {

    boolean processPayment(String orderId, Float amount);
    boolean refundPayment(String orderId, Float amount);
}
