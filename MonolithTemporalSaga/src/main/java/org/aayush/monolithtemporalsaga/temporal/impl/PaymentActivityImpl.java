package org.aayush.monolithtemporalsaga.temporal.impl;

import org.aayush.monolithtemporalsaga.model.OrderDetails;
import org.aayush.monolithtemporalsaga.model.Payment;
import org.aayush.monolithtemporalsaga.temporal.PaymentActivity;
import org.springframework.stereotype.Service;

@Service
public class PaymentActivityImpl implements PaymentActivity {

    @Override
    public boolean processPayment(String orderId, Float amount) {
        System.out.println("Payment processed for order ID: " + orderId + " with amount: " + amount);
        return false;
    }

    @Override
    public boolean refundPayment(String orderId, Float amount) {
        System.out.println("Payment refunded for order ID: " + orderId + " with amount: " + amount);
        return true;
    }
}

