package org.aayush.monolithtemporalsaga.temporal.impl;

import io.temporal.activity.ActivityOptions;
import org.aayush.monolithtemporalsaga.model.OrderDetails;
import org.aayush.monolithtemporalsaga.temporal.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderProcessingWorkflowImpl implements OrderProcessingWorkflow {

    @Autowired
    private OrderActivity orderActivity;

    @Autowired
    private InventoryActivity inventoryActivity;

    @Autowired
    private PaymentActivity paymentActivity;

    @Autowired
    private ShippingActivity shippingActivity;

    @Autowired
    private ProductInfoActivity productInfoActivity;

    private final ActivityOptions activityOptions = ActivityOptions.newBuilder()
            .setScheduleToCloseTimeout(java.time.Duration.ofMinutes(5))
            .build();

    @Override
    public void processOrder(OrderDetails orderDetails) {


        OrderDetails order = new OrderDetails();
        order.setOrderId("123");
        order.setOrderDate("2024-12-20");
        order.setOrderAmount(150.75f);
        order.setOrderStatus("COMPLETED");
        order.setOrderTime("15:30");
        order.setCustomerId("cust123");
        order.setCustomerPhone("123456789");

        orderActivity.createOrder(order);


        inventoryActivity.checkInventory("123");
        inventoryActivity.reserveInventory("123");
        paymentActivity.processPayment(order.getOrderId(), order.getOrderAmount());
        shippingActivity.shipOrder(order.getOrderId());

        System.out.println("Order processing complete for order ID: " + order.getOrderId());

    }
}
