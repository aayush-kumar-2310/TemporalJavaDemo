package org.aayush.monolithtemporalsaga.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document("user-bank-details")
public class Payment {
    @Id
    private String userId;
    private Float balance;
    List<String> transactions;
}