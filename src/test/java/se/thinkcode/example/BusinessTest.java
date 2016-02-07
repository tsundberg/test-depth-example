package se.thinkcode.example;

import org.junit.Test;

import java.time.LocalDate;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BusinessTest {

    @Test
    public void due_date_for_vat_when_you_invoice_within_eu() {
        LocalDate expected = LocalDate.parse("2016-02-28");

        VatRules vatRules = mock(VatRules.class);
        when(vatRules.getVatDueDate("5569215576")).thenReturn(LocalDate.parse("2016-02-28"));

        Business business = new Business("5569215576", vatRules);

        LocalDate actual = business.getVatDueDate();

        assertThat(actual, is(expected));
    }

    @Test
    public void due_date_for_vat_with_low_turn_over() {
        LocalDate expected = LocalDate.parse("2016-08-28");

        VatRules vatRules = mock(VatRules.class);
        when(vatRules.getVatDueDate("5569215576")).thenReturn(LocalDate.parse("2016-08-28"));

        Business business = new Business("5569215576", vatRules);

        LocalDate actual = business.getVatDueDate();

        assertThat(actual, is(expected));
    }
}
