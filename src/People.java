
import java.util.ArrayList;

public abstract class People {
    private String email;
    private String password;
    private ArrayList<ChatRoom> chatRooms;

    public People(String email, String password) {
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
}
