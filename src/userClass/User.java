package tubespbo.src.userClass;

import tubespbo.src.component.Order;

import java.util.Queue;
import java.util.Date;

public abstract class User extends Person {
    private String name;
    private String id;
    private String phoneNumber;
    private Date birthDate;
    private Queue<Order> orderHistory;

    public User(String email, String password, String id, String name) {
        super(email, password);
        this.id = id;
        this.name = name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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
