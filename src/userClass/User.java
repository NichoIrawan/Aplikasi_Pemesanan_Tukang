package tubespbo.src.userClass;

import tubespbo.src.component.Order;
import tubespbo.src.component.StatusOrder;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Date;

public abstract class User extends Person {
    private String name;
    private int id;
    private String phoneNumber;
    private Date birthDate;
    private ArrayList<Order> orderHistory;

    public User(String email, String password, int id, String name) {
        super(email, password);
        this.id = id;
        this.name = name;
        this.orderHistory = new ArrayList<>();
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void OrderHistoryString() {
        for (Order order : orderHistory) {
            if (order.getStatus().equals(StatusOrder.Selesai)) {
                order.printOrderInfo();
                System.out.println();
            }
        }
    }

    public ArrayList<Order> getOrderHistory() {
        return orderHistory;
    }

    public void addOrderHistory(Order order) {
        this.orderHistory.add(order);
    }
}
