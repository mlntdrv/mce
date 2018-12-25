package domain;

import org.junit.jupiter.api.Test;

import java.util.Currency;

import static org.junit.jupiter.api.Assertions.*;

class InvoiceTest {
    Invoice inv = new Invoice(new Money(100, Currency.getInstance("BGN")));

    @Test
    void testPayPartially() throws Exception {
        inv.pay(new Money(50, Currency.getInstance("BGN")));

        assertEquals(false, inv.isPaid());
    }

    @Test
    void testPayFully() throws Exception {
        inv.pay(new Money(100, Currency.getInstance("BGN")));

        assertEquals(true, inv.isPaid());
    }
}