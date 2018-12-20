package infrastructure;

import domain.IProductRepo;
import domain.Money;
import domain.Product;

import java.util.Currency;

class ProductRepo implements IProductRepo {
    public Product get(){
        return new Product("Medical Examination", new Money(20, Currency.getInstance("BGN")));
    }
}
