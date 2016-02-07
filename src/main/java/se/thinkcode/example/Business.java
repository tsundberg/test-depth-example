package se.thinkcode.example;

import java.time.LocalDate;

public class Business {
    private String organizationNumber;
    private VatRules vatRules;

    public Business(String organizationNumber, VatRules vatRules) {
        this.organizationNumber = organizationNumber;
        this.vatRules = vatRules;
    }

    public LocalDate getVatDueDate() {
       return vatRules.getVatDueDate(organizationNumber);
    }
}
