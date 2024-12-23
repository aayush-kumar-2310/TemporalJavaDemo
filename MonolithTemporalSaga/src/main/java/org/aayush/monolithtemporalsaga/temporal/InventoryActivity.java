package org.aayush.monolithtemporalsaga.temporal;

import io.temporal.activity.ActivityInterface;
import org.aayush.monolithtemporalsaga.model.OrderDetails;

@ActivityInterface
public interface InventoryActivity {

    boolean checkInventory(String productId);
    boolean reserveInventory(String productId);
    boolean releaseInventory(String productId);
}
