package tubespbo.src.component;

import tubespbo.src.userClass.Customer;
import tubespbo.src.userClass.Tukang;

import java.util.Date;

enum StatusOrder {
    MenungguKonfirmasi,
    DalamProsesPembayaran,
    TelahDibayar,
    Selesai,
    Dibatalkan
}

enum PaymentMethod {
    CASH
}

public class Order {
    private final String id;
    private final Tukang tukang;
    private final Customer customer;
    private double totalPrice;
    private StatusOrder status;
    private final Date date;

    public Order(String id, Tukang tukang, Customer customer, double totalPrice, String status, Date date) {
        this.id = id;
        this.tukang = tukang;
        this.customer = customer;
        this.totalPrice = totalPrice;
        this.status = StatusOrder.valueOf(status);
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public Tukang getTukang() {
        return tukang;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Date getDate() {
        return date;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public StatusOrder getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = StatusOrder.valueOf(status);
    }

    public void callMenuOrder(){}

    public void callMenuPembayaran(){
        PaymentMethod paymentMethod = PaymentMethod.CASH; // By default

        // pilih metode pembayaran

        // membuat transaksi
        setStatus("DalamProsesPembayaran");
        Transaction transaction = new Transaction(id + "1", this.customer, this.tukang, paymentMethod, this.totalPrice, this.date);
    }

    public void printOrderInfo(){}

    public void giveRating(Tukang tukang, double rating){}
}