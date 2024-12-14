package tubespbo.src.userClass;

import tubespbo.src.component.*;

import java.util.Queue;

public class Customer extends User {
    private Address[] addresses;
    private Tukang[] tukangFavorit;
    private Queue<Order> orderHistory;

    public Customer(String email, String password, String id, String name) {
        super(email, password, id, name);
    }

    public void getAddresses() {
        for (Address address : addresses) {
            System.out.println(address);
        }
    }

    public void changeAddresses(int i, Address address) {
        this.addresses[i] = address;
    }

    public void removeAddress(int i, Address address) {
        this.addresses[i] = null;
    }

    public void getTukangFavorit() {
        for (Tukang tukang : tukangFavorit) {
            System.out.println(tukang);
        }
    }

    public void changeTukangFavorit(int i, Tukang tukang) {
        if (this.tukangFavorit[i].getId().equals(tukang.getId())) {
            return;
        }
        this.tukangFavorit[i] = tukang;
    }

    public void getOrderHistory() {
        for (Order order : orderHistory) {
            System.out.println(order);
        }
    }

    public void addOrderHistory(Order order) {
        this.orderHistory.add(order);
        if (this.orderHistory.size() > 10) {
            this.orderHistory.remove();
        }
    }
}
