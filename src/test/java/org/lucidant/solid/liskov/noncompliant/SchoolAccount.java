package org.lucidant.solid.liskov.noncompliant;

public class SchoolAccount implements Account {
    @Override
    public void processTransfer(double amount) {
        // do implementing logic
    }

    // This violates
    @Override
    public void processInternationalTransfer(double amount, String countryCode) {
        throw new RuntimeException("Not implemented");
    }
}
