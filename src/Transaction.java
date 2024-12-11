package tubespbo.src;

import java.util.Date;

public class Transaction {
    private final String id;
    private final Customer customer;
    private final Tukang tukang;
    private final PaymentMethod paymentMethod;
    private final double totalPrice;
    private boolean status;
    private final Date paymentDeadline;

    public Transaction(String id, Customer customer, Tukang tukang, PaymentMethod paymentMethod, double totalPrice, Date paymentDeadline) {
        this.id = id;
        this.customer = customer;
        this.tukang = tukang;
        this.paymentMethod = paymentMethod;
        this.totalPrice = totalPrice;
        this.status = false;
        this.paymentDeadline = paymentDeadline;
    }

    public String getId() {
        return id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Tukang getTukang() {
        return tukang;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public Date getPaymentDeadline() {
        return paymentDeadline;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
