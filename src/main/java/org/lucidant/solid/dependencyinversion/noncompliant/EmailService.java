package org.lucidant.solid.dependencyinversion.noncompliant;

public class EmailService {
    public void sendEmail(String message) {
        System.out.println("Sending email with message: " + message);
    }
}
