package org.aayush.monolithtemporalsaga;

import org.aayush.monolithtemporalsaga.model.OrderDetails;
import org.aayush.monolithtemporalsaga.temporal.OrderOrchestrator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MonolithTemporalSagaApplication implements CommandLineRunner {

    @Autowired
    private OrderOrchestrator orderOrchestrator;

    public static void main(String[] args) {
        SpringApplication.run(MonolithTemporalSagaApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        OrderDetails order = new OrderDetails();
        order.setOrderId("ORD12345");
        order.setCustomerId("CUST56789");
        order.setCustomerPhone("987-654-3210");
        order.setOrderStatus("PENDING");
        order.setOrderDate("2024-12-20");
        order.setOrderTime("15:30");
        order.setOrderAmount(150.75f);
        orderOrchestrator.initiateSaga(order);
    }
}
