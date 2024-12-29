package tubespbo.src.component;

import tubespbo.src.userClass.*;

import java.util.Date;
import java.util.Scanner;

public class Order {
    private final int id;
    private final Tukang tukang;
    private final Customer customer;
    private double totalPrice;
    private StatusOrder status;
    private final Date date;
    private Transaction transaction;
    private Scanner scanner;

    public Order(int id, Tukang tukang, Customer customer, double totalPrice, String status, Date date) {
        this.id = id;
        this.tukang = tukang;
        this.customer = customer;
        this.totalPrice = totalPrice;
        this.status = StatusOrder.valueOf(status);
        this.date = date;
        this.transaction = null;
    }

    public int getId() {
        return id;
    }

    public Tukang getTukang() {
        return tukang;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Transaction getTransaction() {
        return transaction;
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

    public void setStatus(StatusOrder status) {
        this.status = status;
    }

    public void callMenuPembayaran(){
        PaymentMethod paymentMethod = PaymentMethod.CASH; // By default

        // pilih metode pembayaran

        // membuat transaksi
        setStatus(StatusOrder.DalamProsesPembayaran);
        this.transaction = new Transaction(this.customer, this.tukang, paymentMethod, this.totalPrice, this.date);
        System.out.println(this.transaction);
    }

    public void printOrderInfo(){
        System.out.println("ID: " + this.id);
        System.out.println("Tukang: " + this.tukang.getName());
        System.out.println("TotalPrice: " + this.totalPrice);
        System.out.println("Status: " + this.status);
    }

    public void printOrderInfoTukang(){
        System.out.println("Customer: " + this.customer.getName());
        System.out.println("TotalPrice: " + this.totalPrice);
        System.out.println("Status: " + this.status);
    }
}
