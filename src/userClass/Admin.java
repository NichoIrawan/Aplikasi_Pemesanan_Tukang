package tubespbo.src.userClass;

import tubespbo.src.component.Certificate;

import java.util.ArrayList;

public class Admin extends Person {
    public Admin(String email, String password) {
        super(email, password);
    }

    public void suspendUser (User user, ArrayList<User> users, ArrayList<User> suspendedUsers) {
        users.remove(user);
        suspendedUsers.add(user);
    }

    public void activateUser (User user, ArrayList<User> users, ArrayList<User> suspendedUsers) {
        suspendedUsers.remove(user);
        users.add(user);
    }

    public void certificateVerification (Certificate certification) {
           certification.setVerified();
    }

    public void callMenuChat() {}

    public void callMenuAdmin() {}
}
