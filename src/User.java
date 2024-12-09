package tubespbo.src;

import java.util.ArrayList;
import java.util.Date;

public class User extends Person {
    private String name;
    private String id;
    private String phoneNumber;
    private Date birthDate;
    private ArrayList<Order> orderHistory;
    private ArrayList<ChatRoom> chatRooms;

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

    public void complain (Person person, String complain) {}

    public void callMenuChat() {}

    public void callMenuUser() {}

    public void callMenuHistory() {}
}
