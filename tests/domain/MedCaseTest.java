package domain;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Currency;
import java.util.List;

import static javax.xml.bind.DatatypeConverter.parseDate;
import static org.junit.jupiter.api.Assertions.*;

class MedCaseTest {
    @Test
    void MedCase() {
        Product bh = new Product("bromhexin", new Money(5.9, Currency.getInstance("BGN")));
        Product me = new Product("Medical Examination", new Money(20, Currency.getInstance("BGN")));
        List<Product> prods = new ArrayList<>();
        prods.add(bh);
        prods.add(me);

        Visit v = new Visit(prods);

        MedCase mc = new MedCase("bronchitis", "meds", LocalDate.parse("2019-01-07"), v);

        assertEquals(1, mc.getVisits().size());
    }

    @Test
    void addVisit() {
        Product bh = new Product("bromhexin", new Money(5.9, Currency.getInstance("BGN")));
        Product me = new Product("Medical Examination", new Money(20, Currency.getInstance("BGN")));
        List<Product> prods = new ArrayList<>();
        prods.add(bh);
        prods.add(me);

        Visit v = new Visit(prods);

        MedCase mc = new MedCase("bronchitis", "meds", LocalDate.parse("2019-01-07"), v);

        prods.remove(1);

        mc.addVisit(new Visit(prods));

        assertEquals(2, mc.getVisits().size());
    }
}