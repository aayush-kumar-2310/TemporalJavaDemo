package org.aayush.monolithtemporalsaga.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("order-details")
public class OrderDetails {

    @Id
    private String orderId;
    private String customerId;
    private String customerPhone;
    private String orderStatus;
    private String orderDate;
    private String orderTime;
    private float orderAmount;
}
