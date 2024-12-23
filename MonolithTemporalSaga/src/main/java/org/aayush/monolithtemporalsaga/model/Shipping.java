package org.aayush.monolithtemporalsaga.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("shipping-details")
public class Shipping {

    @Id
    private String orderId;
    private String customerId;
    private String customerName;
    private String customerAddress;
    private String customerPhone;
    private double shippingAmount;
}
