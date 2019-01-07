package domain;

import java.util.ArrayList;
import java.util.Currency;
import java.util.List;

class Visit {
    private List<Product> products;
    private Invoice invoice;

    public Visit(){
        invoice  = new Invoice(new Money(0, Currency.getInstance("BGN")));
        products = new ArrayList<>();
    }

    public Visit(List<Product> products){
        Money prodPricesSum = products.stream()
                .map(p -> p.getPrice())
                .reduce(new Money(0, Currency.getInstance("BGN")), Money::add);

        this.invoice  = new Invoice(prodPricesSum);
        this.products = products;
    }

    public Invoice getInvoice(){
        return invoice;
    }

    protected void addProduct(Product product) throws Exception {
        products.add(product);

        try{ invoice.setTotalAmount(invoice.getTotalAmount().add(product.getPrice())); }
        catch(Exception ex){ throw ex; }
    }
}
