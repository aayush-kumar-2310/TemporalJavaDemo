package org.aayush.monolithtemporalsaga.temporal;

import io.temporal.client.WorkflowClient;
import io.temporal.serviceclient.WorkflowServiceStubs;
import io.temporal.serviceclient.WorkflowServiceStubsOptions;
import io.temporal.worker.Worker;
import io.temporal.worker.WorkerFactory;
import org.aayush.monolithtemporalsaga.temporal.impl.OrderProcessingWorkflowImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TemporalConfig {

    @Bean
    public WorkflowClient workflowClient() {
        WorkflowServiceStubs serviceStubs = WorkflowServiceStubs.newInstance(
                WorkflowServiceStubsOptions.newBuilder().setTarget("localhost:7233").build()
        );
        return WorkflowClient.newInstance(serviceStubs);    }

    @Bean
    public WorkerFactory workerFactory(WorkflowClient workflowClient) {
        WorkerFactory factory = WorkerFactory.newInstance(workflowClient);
        Worker worker = factory.newWorker("order-task-queue");
        worker.registerWorkflowImplementationTypes(OrderProcessingWorkflowImpl.class);
        worker.registerActivitiesImplementations();
        factory.start();
        return factory;
    }

}
