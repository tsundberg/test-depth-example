package se.thinkcode.example;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class VatRules {
    private Set<String> invoicedInEU = new HashSet<String>();
    private Set<String> lowTurnover = new HashSet<String>();

    public VatRules() {
        invoicedInEU.add("5569215576");
        lowTurnover.add("5569215576");
        lowTurnover.add("8020120682");
    }

    public LocalDate getVatDueDate(String organizationNumber) {
        if (invoicedInEU.contains(organizationNumber)) {
            return LocalDate.parse("2016-02-28");
        }
        if (lowTurnover.contains(organizationNumber)) {
            return LocalDate.parse("2016-08-28");
        }

        return LocalDate.parse("2016-08-28");
    }
}
