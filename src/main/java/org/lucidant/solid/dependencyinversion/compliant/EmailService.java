package org.lucidant.solid.dependencyinversion.compliant;

public class EmailService implements NotificationService {

    @Override
    public void send(String message) {
        System.out.println("Sending email with message: " + message);
    }
}
