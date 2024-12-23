package org.aayush.monolithtemporalsaga.temporal;

import org.aayush.monolithtemporalsaga.model.OrderDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderOrchestrator {

    @Autowired
    private PaymentActivity paymentService;

    @Autowired
    private InventoryActivity inventoryService;

    @Autowired
    private ShippingActivity shippingService;

    public void initiateSaga(OrderDetails order) {
        boolean paymentProcessed = false;
        boolean inventoryReserved = false;
        boolean orderShipped = false;

        try {
            paymentProcessed = paymentService.processPayment(order.getOrderId(), order.getOrderAmount());
            if (!paymentProcessed) {
                throw new RuntimeException("Payment failed");
            }

            inventoryReserved = inventoryService.reserveInventory(order.getOrderId());
            if (!inventoryReserved) {
                throw new RuntimeException("Inventory reservation failed");
            }

            orderShipped = shippingService.shipOrder(order.getOrderId());
            if (!orderShipped) {
                throw new RuntimeException("Shipping failed");
            }

            order.setOrderStatus("COMPLETED");
            System.out.println("Order " + order.getOrderId() + " completed successfully");

        } catch (Exception e) {
            System.out.println("Error during order processing: " + e.getMessage());
            cancelSaga(order, paymentProcessed, inventoryReserved, orderShipped);
        }
    }

    private void cancelSaga(OrderDetails order, boolean paymentProcessed, boolean inventoryReserved, boolean orderShipped) {
        if (orderShipped) {
            try {
                shippingService.cancelShipping(order.getOrderId());
            } catch (Exception e) {
                System.out.println("Failed to cancel shipping for order " + order.getOrderId());
            }
        }

        if (inventoryReserved) {
            try {
                inventoryService.releaseInventory(order.getOrderId());
            } catch (Exception e) {
                System.out.println("Failed to release inventory for order " + order.getOrderId());
            }
        }

        if (paymentProcessed) {
            try {
                paymentService.refundPayment(order.getOrderId(), order.getOrderAmount());
            } catch (Exception e) {
                System.out.println("Failed to refund payment for order " + order.getOrderId());
            }
        }

        order.setOrderStatus("FAILED");
        System.out.println("Order " + order.getOrderId() + " has been cancelled due to failure");
    }


}
