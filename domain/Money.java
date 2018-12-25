package domain;

import java.util.Currency;

public class Money implements Comparable<Money> {
    private double   amount;
    private Currency currency;

    private static final String EX_MSG = "The currencies are different.";
    
    public Money(double amount, Currency currency) {
        this.amount   = amount;
        this.currency = currency;
    }
    
    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public Money add(Money moneyToAdd) throws Exception {
        if(!currency.equals(moneyToAdd.currency)) throw new Exception(EX_MSG);
        
        amount += moneyToAdd.amount;
        
        return this;
    }
    
    public Money sub(Money moneyToSubtract) throws Exception {
        if(!currency.equals(moneyToSubtract.currency)) throw new Exception(EX_MSG);
        
        amount -= moneyToSubtract.amount;
        
        return this;
    }

    @Override
    public String toString() {
        return Double.toString(this.amount) + ' ' + this.currency.toString();
    }

    @Override
    public int compareTo(Money m) throws RuntimeException {
        if(!currency.equals(m.currency)) throw new RuntimeException(EX_MSG);

        return Double.compare(amount, m.amount);
    }

    @Override
    public boolean equals(Object m){
        Money mCast = (Money) m;

        if(currency.equals(mCast.currency) && amount == mCast.getAmount()) return true;

        return false;
    }
}
