package tubespbo.src;

import tubespbo.src.component.Order;
import tubespbo.src.component.Services;
import tubespbo.src.userClass.*;

import java.security.Provider;
import java.util.*;

public class Main {
    //----- Initialize Data -----
    public static HashMap<String, Tukang> tukangItems = new HashMap<>();
    public static ArrayList<Services> servicesItems = new ArrayList<>();
    public static ArrayList<Order> orders = new ArrayList<>();
    public static HashMap<String, Person> users = new HashMap<>();
    public static HashMap<String, User> suspendedUsers= new HashMap<>();
    static Person loggedInUser = null;
    static Scanner sc = new Scanner(System.in);
    //---------------------------

    public static void main(String[] args) {
        //----- Add items to list & initialize -----
        Services plumber = new Services("Tukang Ledeng", "Penyelesai masalah toilet", 300000);
        Services foreman = new Services("Mandor", "Pengawas Lapangan", 300000);
        servicesItems.add(plumber);
        servicesItems.add(foreman);
        Customer customer1 = new Customer("Triana@gmail.com", "1234", 1, "Triana");
        users.put(customer1.getEmail(), customer1);
        users.put("admin", new Admin("admin", "admin"));
        tukangItems.put("1", new Tukang("Budi@gmail.com", "023123", 1, "Budi Setiawan", 0.0, 5000.0, plumber, 2));
        tukangItems.put("2", new Tukang("tololgaming123@gmail.com", "1293109", 2, "Aryosetown", 0.0, 10000.0, foreman, 3));
        int choice;
        //------------------------------------------

        try {
            do {
                System.out.println("\n========== SELAMAT DATANG ==========");
                System.out.println("1. Login");
                System.out.println("2. Register");
                System.out.println("0. Keluar");
                System.out.print("Pilih menu: ");

                choice = sc.nextInt();
                sc.nextLine();  // Clear buffer

                switch (choice) {
                    case 1:
                        login();
                        break;

                    case 2:
                        register();
                        break;

                    case 0:
                        System.out.println("Terima kasih telah menggunakan aplikasi.");
                        break;

                    default:
                        System.out.println("Pilihan tidak valid.");
                }
            } while (choice != 0);

        } catch (InputMismatchException e) {
            System.out.println("Masukkan format input yang sesuai");
            Main.main(args);
        }

        sc.close();
    }

    public static void login() {
        System.out.println("\n========== LOGIN ==========");
        System.out.println("Masukkan Email: ");
        String email = sc.next();
        System.out.println("Masukkan Password: ");
        String password = sc.next();

        if (users.containsKey(email) && users.get(email).getPassword().equals(password)) {
            loggedInUser = users.get(email);
            System.out.println("Login berhasil! Selamat datang");
            loggedInUser.callMenu();
        } else {
            System.out.println("Email atau password salah.");
        }
    }

    public static void register() {
        System.out.println("\n========== REGISTER ==========");
        System.out.println("Masukkan Email: ");
        String email = sc.nextLine();
        System.out.println("Masukkan Nama: ");
        String nama = sc.nextLine();
        System.out.println("Masukkan Password: ");
        String password = sc.nextLine();

        if (users.containsKey(email)) {
            System.out.println("Email sudah terdaftar. Gunakan email lain.");
        } else {
            users.put(email, new Customer(email, password, users.size() + 1, nama));
            System.out.println("Registrasi berhasil!");
        }
    }
}