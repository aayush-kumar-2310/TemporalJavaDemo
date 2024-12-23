package org.aayush.monolithtemporalsaga.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("product-inventory")
public class Inventory {

    @Id
    private String productId;
    private int quantity;
    private double price;
}
