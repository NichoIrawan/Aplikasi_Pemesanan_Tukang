package tubespbo.src.userClass;

import tubespbo.src.Main;
import tubespbo.src.component.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Admin extends Person {
    public Admin(String email, String password) {
        super(email, password);
    }

    public void suspendUser (String userId, HashMap<String, Person> users, HashMap<String, User> suspendedUsers) {
//        if (users.containsKey(userId)) {
//            if
//            suspendedUsers.put(userId, users.get(userId));
//            users.remove(users.get(userId));
//        } else {
//            System.out.println("User " + user.getId() + " doesn't exist");
//        }
    }

    public void activateUser (User user, HashMap<String, Person> users, HashMap<String, User> suspendedUsers) {
        if (suspendedUsers.containsKey(((String)user.getEmail()))) {
            suspendedUsers.remove(user.getEmail());
            users.put(user.getEmail(), user);
        } else {
            System.out.println("User " + user.getId() + " doesn't exist");
        }
    }

    public void certificateVerification (Certificate certification) {
           certification.setVerified();
    }

    @Override
    public void callMenu() {
        int input;
        Scanner scanner = new Scanner(System.in);
        System.out.println("====== MENU =====");
        System.out.println("1. Suspend User");
        System.out.println("2. Activate User");
        System.out.println("3. Certificate Verification");
        System.out.println("0. Exit");
        input = scanner.nextInt();

        switch (input) {
            case 1:
                System.out.println("Masukkan id Customer: ");
                String id = scanner.next();

//                suspendUser(Main.users, Main.suspendedUsers);
        }
    }
}
