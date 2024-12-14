package tubespbo.src.component;

import tubespbo.src.userClass.*;

import java.util.ArrayList;
import java.util.Date;

public class Riwayat extends Order{
    private ArrayList<Order> riwayatList = new ArrayList<>();
    public Riwayat(String id, Tukang tukang, Customer customer, double totalPrice, String status, Date date) {
        super(id, tukang, customer, totalPrice, status, date);
    }

    public void addRiwayat(Order order) {
        riwayatList.add(order);
    }

    public Order showRiwayat() {
        for (Order order : riwayatList) {
            return order;
        }
        return null;
    }
}
