package org.aayush.monolithtemporalsaga.temporal.impl;

import org.aayush.monolithtemporalsaga.model.Shipping;
import org.aayush.monolithtemporalsaga.temporal.ShippingActivity;
import org.springframework.stereotype.Service;

@Service
public class ShippingActivityImpl implements ShippingActivity {


    @Override
    public boolean shipOrder(String orderId) {
        System.out.println("Order shipped with ID: " + orderId);
        return true;
    }

    @Override
    public boolean cancelShipping(String orderId) {
        System.out.println("Shipping cancelled for order ID: " + orderId);
        return true;
    }
}
