package org.aayush.monolithtemporalsaga.temporal;

import io.temporal.workflow.WorkflowInterface;
import io.temporal.workflow.WorkflowMethod;
import org.aayush.monolithtemporalsaga.model.OrderDetails;

@WorkflowInterface
public interface OrderProcessingWorkflow {

    @WorkflowMethod
    void processOrder(OrderDetails orderDetails);
}
