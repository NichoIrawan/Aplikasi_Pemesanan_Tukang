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

    private void addAddress(Address address) {
        addresses[addresses.length - 1] = address;
    }

    public void changeAddresses(int i, Address address) {
        try {
            if (addresses.length <= 3) {
                addAddress(address);
            } else {
                this.addresses[i-1] = address;
            }
        } catch (Exception e) {
            System.out.println("[Error] Alamat tidak valid");
        }
    }

    public void removeAddress(int i, Address address) {
        this.addresses[i-1] = null;
    }

    public void getTukangFavorit() {
        for (Tukang tukang : tukangFavorit) {
            System.out.println(tukang);
        }
    }

    private void addTukangFavorit(Tukang tukang) {
        tukangFavorit[tukangFavorit.length - 1] = tukang;
    }

    public void changeTukangFavorit(int i, Tukang tukang) {
        try {
            if (tukangFavorit.length <= 5) {
                addTukangFavorit(tukang);
            } else {
                if (this.tukangFavorit[i].getId().equals(tukang.getId())) {
                    System.out.println("[Error] Tukang sudah masuk ke daftar favorit");
                    return;
                }
                this.tukangFavorit[i] = tukang;
            }
        } catch (Exception e) {
            System.out.println("[Error] Tukang tidak valid");
        }
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

    @Override
    public void callMenu() {

    }
}
