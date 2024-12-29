package tubespbo.src;

import tubespbo.src.component.Order;
import tubespbo.src.component.Services;
import tubespbo.src.userClass.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Driver implements DriverInterface {
    public static HashMap<String, Tukang> tukangItems;
    public static ArrayList<Services> servicesItems;
    public static ArrayList<Order> orders;
    public static HashMap<String, Person> users;
    public static HashMap<String, User> suspendedUsers;
    static Scanner sc = new Scanner(System.in);

    @Override
    public void initialize() {
        // Initial
        tukangItems = new HashMap<>();
        servicesItems = new ArrayList<>();
        orders = new ArrayList<>();
        users = new HashMap<>();
        suspendedUsers= new HashMap<>();

        // Initialize admin
        users.put("admin", new Admin("admin", "admin"));

        // Dummy data
        servicesItems.add(new Services("Tukang Ledeng", "Penyelesai masalah toilet", 300000));
        servicesItems.add(new Services("Mandor", "Pengawas Lapangan", 300000));

        tukangItems.put("1", new Tukang("Budi@gmail.com", "023123", 1, "Budi Setiawan",
                0.0, 5000.0, servicesItems.get(0), 0));

        users.put(tukangItems.get("1").getEmail(), tukangItems.get("1"));
        users.put("Triana@gmail.com", new Customer("Triana@gmail.com", "1234", 1, "Triana"));
    }

    @Override
    public int loginMenuInterface() {
        System.out.println("\n========== SELAMAT DATANG ==========");
        System.out.println("1. Login");
        System.out.println("2. Register");
        System.out.println("0. Keluar");
        System.out.print("Pilih menu: ");

        int choice = sc.nextInt();
        sc.nextLine();

        return choice;
    }

    @Override
    public void menu() {
        int choice = -1;

        while (choice != 0) {
            try {
                choice = loginMenuInterface();

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
                        break;
                }
            } catch (Exception e) {
                System.out.println("Pilihan tidak valid.");
                sc.nextLine();
            }
        }
    }

    @Override
    public void login() {
        Person loggedInUser;

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

    @Override
    public void register() {
        System.out.println("\n========== REGISTER ==========");
        System.out.println("Anda ingin daftar sebagai apa?");
        System.out.println("1. Customer");
        System.out.println("2. Tukang");
        System.out.print("Pilih jenis akun: ");
        String role = sc.nextLine();

        if (role.equals("1") || role.equals("2")) {
            System.out.println("Masukkan Email: ");
            String email = sc.nextLine();
            System.out.println("Masukkan Nama: ");
            String nama = sc.nextLine();
            System.out.println("Masukkan Password: ");
            String password = sc.nextLine();

            if (users.containsKey(email)) {
                System.out.println("Email sudah terdaftar. Gunakan email lain.");
            } else {
                if (role.equals("1")) {
                    users.put(email, new Customer(email, password, users.size() + 1, nama));
                    System.out.println("Registrasi berhasil!");
                } else {
                    int type = 0;
                    while (type == 0) {
                        try {
                            System.out.println("\nPilih jenis servis anda");
                            for (int i = 0; i < servicesItems.size(); i++) {
                                System.out.printf("%d. %s\n", i + 1, servicesItems.get(i).getName());
                            }
                            System.out.print("Pilih jenis servis: ");

                            type = sc.nextInt();
                            sc.nextLine();
                        } catch (Exception e) {
                            System.out.println("Pilih tidak valid.");
                            sc.nextLine();
                        }
                    }
                    Services serviceType = servicesItems.get(type-1);

                    Tukang tukang = new Tukang(email, password, users.size() + 1, nama, serviceType);
                    int sz = tukangItems.size() + 1;
                    String id = Integer.toString(sz);

                    tukangItems.put(id, tukang);
                    users.put(email, tukang);

                    System.out.println("Registrasi berhasil!");
                }
            }
        } else {
            System.out.println("Input Invalid");
        }
    }
}
