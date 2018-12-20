package domain;

import java.util.List;

class Visit {
    private List<Product> products;
    private Invoice invoice;

    public Visit(){}

    public Visit(List<Product> products){
        this.products = products;
    }

    protected void addProduct(Product product) throws Exception {
        products.add(product);

        try{ invoice.setTotalAmount(invoice.getTotalAmount().add(product.getPrice())); }
        catch(Exception ex){ throw ex; }
    }
}
