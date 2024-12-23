package org.aayush.monolithtemporalsaga.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("product-details")
public class Product {

    @Id
    private String productId;
    private String productName;
    private String productDescription;
    private double productPrice;
}
