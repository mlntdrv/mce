package domain;

import java.time.LocalDate;
import java.util.UUID;

class Invoice {
    private UUID      invId;
    private LocalDate invDate;
    private Money     totalAmount;
    private Money     paidAmount;
    private boolean   isPaid;
    
    public Invoice(Money totalAmount) {
        this.totalAmount = totalAmount;
        this.paidAmount  = new Money(0, totalAmount.getCurrency());
        this.isPaid      = false;
        this.invId       = UUID.randomUUID();
    }

    public Money getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Money totalAmount) {
        this.totalAmount = totalAmount;
    }

    public void pay(Money amount) throws Exception {
        try { paidAmount.add(amount); }
        catch(Exception ex) { throw ex; }

        if(paidAmount.compareTo(totalAmount) >= 0) isPaid = true;
    }

    public boolean isPaid(){
        return isPaid;
    }
}