package tubespbo.src;

import tubespbo.src.component.Order;
import tubespbo.src.component.Services;
import tubespbo.src.userClass.*;

import java.security.Provider;
import java.util.*;

public class Main {
    //----- Initialize Data -----
    /*public static HashMap<String, Tukang> tukangItems = new HashMap<>();
    public static ArrayList<Services> servicesItems = new ArrayList<>();
    public static ArrayList<Order> orders = new ArrayList<>();
    public static HashMap<String, Person> users = new HashMap<>();
    public static HashMap<String, User> suspendedUsers= new HashMap<>();
    public static Person loggedInUser = null;
    static Scanner sc = new Scanner(System.in);*/
    //---------------------------

    public static void main(String[] args) {
        //----- Add items to list & initialize -----
        /*Services plumber = new Services("Tukang Ledeng", "Penyelesai masalah toilet", 300000);
        Services foreman = new Services("Mandor", "Pengawas Lapangan", 300000);
        servicesItems.add(plumber);
        servicesItems.add(foreman);
        Customer customer1 = new Customer("Triana@gmail.com", "1234", 1, "Triana");
        users.put(customer1.getEmail(), customer1);
        users.put("admin", new Admin("admin", "admin"));
        tukangItems.put("1", new Tukang("Budi@gmail.com", "023123", 1, "Budi Setiawan", 0.0, 5000.0, plumber, 2));
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
                        register(servicesItems);
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

        sc.close();*/

        Driver driver = new Driver();

        driver.initialize();
        driver.menu();
    }

    /*public static void login() {
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

    public static void register(ArrayList<Services> servicesItems) {
        Services serviceType = null;
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
            if(role.equals("2")){
                System.out.println("Pilih jenis servis anda");
                System.out.println("1. Tukang Ledeng");
                System.out.println("2. Mandor");
                System.out.print("Pilih jenis servis: ");

                int type = sc.nextInt();
                serviceType = servicesItems.get(type-1);
            }

            if (users.containsKey(email)) {
                System.out.println("Email sudah terdaftar. Gunakan email lain.");
            } else {
                if(role.equals("1")){
                    users.put(email, new Customer(email, password, users.size() + 1, nama));
                    System.out.println("Registrasi berhasil!");
                } else {
                    Tukang tukang = new Tukang(email, password, users.size() + 1, nama, serviceType);
                    users.put(email, tukang);
                    System.out.println("Registrasi berhasil!");
                    int sz = tukangItems.size() + 1;
                    String id = Integer.toString(sz);
                    tukangItems.put(id, tukang);
                }
            }
        } else {
            System.out.println("Input Invalid");
        }

    }*/
}