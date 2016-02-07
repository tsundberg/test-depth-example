package se.thinkcode.example;

import org.junit.Test;

import java.time.LocalDate;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class VatRulesTest {
    @Test
    public void vat_due_date_is_28_feb_if_invoicing_in_eu() {
        LocalDate expected = LocalDate.parse("2016-02-28");

        VatRules vatRules = new VatRules();

        LocalDate actual = vatRules.getVatDueDate("5569215576");

        assertThat(actual, is(expected));
    }

    @Test
    public void vat_due_date_is_28_aug_if_low_turn_over() {
        LocalDate expected = LocalDate.parse("2016-08-28");

        VatRules vatRules = new VatRules();

        LocalDate actual = vatRules.getVatDueDate("8020120682");

        assertThat(actual, is(expected));
    }
}
