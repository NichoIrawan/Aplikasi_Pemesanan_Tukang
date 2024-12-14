package tubespbo.src.userClass;

import tubespbo.src.component.ChatRoom;

import java.util.ArrayList;

public abstract class Person {
    private String email;
    private String password;
    private ArrayList<ChatRoom> chatRooms;

    public Person(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public abstract void callMenuChat();

    public abstract void callMenu();
}
