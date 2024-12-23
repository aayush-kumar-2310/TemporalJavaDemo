package org.aayush.monolithtemporalsaga.temporal.impl;

import org.aayush.monolithtemporalsaga.temporal.InventoryActivity;
import org.springframework.stereotype.Service;

@Service
public class InventoryActivityImpl implements InventoryActivity {
    @Override
    public boolean checkInventory(String productId) {
        System.out.println("Checking inventory for product " + productId);
        return true;
    }

    @Override
    public boolean reserveInventory(String productId) {
        System.out.println("Inventory reserved for product ID: " + productId);
        return true;
    }

    @Override
    public boolean releaseInventory(String productId) {
        System.out.println("Inventory released for product ID: " + productId);
        return true;
    }
}
