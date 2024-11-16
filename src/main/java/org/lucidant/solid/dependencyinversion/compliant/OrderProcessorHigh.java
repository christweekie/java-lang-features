package org.lucidant.solid.dependencyinversion.compliant;

/**
 * This is bad because the high level Order processor depends on Email Service.
 * So how can you change the notification service ?
 */
public class OrderProcessorHigh {

    private NotificationService notificationService;

    public void processOrder(String orderId) {
        // process the order
        System.out.println("Order processed: " + orderId);

        // send notification
        notificationService.send("Order " + orderId + " has been processed.");
    }
}
