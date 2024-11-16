package org.lucidant.solid.liskov.noncompliant;

public interface Account {

    void processTransfer(double amount);

    void processInternationalTransfer(double amount, String countryCode);
}
