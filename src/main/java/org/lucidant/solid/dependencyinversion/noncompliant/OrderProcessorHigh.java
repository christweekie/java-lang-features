package org.lucidant.solid.dependencyinversion.noncompliant;

/**
 * This is bad because the high level Order processor depends on Email Service.
 * So how can you change the notification service ?
 */
public class OrderProcessorHigh {

    private final EmailService emailService;

    public OrderProcessorHigh() {
        this.emailService = new EmailService();
    }

    public void processOrder(String orderId) {
        // process the order
        System.out.println("Order processed: " + orderId);

        // send notification
        emailService.sendEmail("Order " + orderId + " has been processed.");
    }
}
