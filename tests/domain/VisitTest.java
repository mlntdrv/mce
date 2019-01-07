package domain;

import org.junit.jupiter.api.Test;
import org.testng.annotations.Ignore;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Currency;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class VisitTest {
    @Test
    void addProductOnly() throws Exception {
        Visit v = new Visit();
        Product prod = new Product("bromhexin", new Money(5.9, Currency.getInstance("BGN")));
        v.addProduct(prod);

        assertEquals(new Money(5.9, Currency.getInstance("BGN")), v.getInvoice().getTotalAmount());
    }

    @Test
    void constructorOnly(){
        Product bh = new Product("bromhexin", new Money(5.9, Currency.getInstance("BGN")));
        Product me = new Product("Medical Examination", new Money(20, Currency.getInstance("BGN")));

        Visit v = new Visit(Arrays.asList(new Product[]{me, bh}));

        assertEquals(new Money(25.9, Currency.getInstance("BGN")), v.getInvoice().getTotalAmount());
    }
}