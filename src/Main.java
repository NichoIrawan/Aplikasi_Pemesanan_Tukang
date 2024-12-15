package tubespbo.src;

import tubespbo.src.component.Order;
import tubespbo.src.component.Services;
import tubespbo.src.userClass.Customer;
import tubespbo.src.userClass.Tukang;
import tubespbo.src.userClass.User;

import java.util.*;

public class Main {
    static HashMap<String , Tukang> tukangItems = new HashMap<>();
    static Services plumber = new Services("Tukang Ledeng", "Penyelesai masalah toilet", 300000);
    static Services foreman = new Services("Mandor", "Pengawas Lapangan", 300000);
    static ArrayList<Services> servicesItems = new ArrayList<>();
    static ArrayList<Order> orders = new ArrayList<>();
    static HashMap<String, Customer> users = new HashMap<>();
    static Customer loggedInUser = null;
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        servicesItems.add(plumber);
        servicesItems.add(foreman);
        Tukang tukang1 = new Tukang("Budi@gmail.com", "023123", "1", "Budi Setiawan", 0.0, 5000.0, plumber, 2);
        Tukang tukang2 = new Tukang("tololgaming123@gmail.com", "1293109", "2", "Aryosetown", 0.0, 10000.0, foreman, 3);
//        Customer customer1 = new Customer("Triana@gmail.com", "1234", "1", "Triana");
        tukangItems.put("1", tukang1);
        tukangItems.put("2", tukang2);

//        search();

//        Order order = new Order("1", tukang1, customer1, 500000.0, "Selesai", new Date(10, 12, 2024));
//        orders.add(order);
        int choice;
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
                        if (login()) {
                            showMainMenu();
                        }
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

        }

        sc.close();
    }
    public static void startMenu(){

    }
    public static boolean login() {
        System.out.println("\n========== LOGIN ==========");
        System.out.println("Masukkan Email: ");
        String email = sc.next();
        System.out.println("Masukkan Password: ");
        String password = sc.next();

        if (users.containsKey(email) && users.get(email).getPassword().equals(password)) {
            loggedInUser = users.get(email);
            System.out.println("Login berhasil! Selamat datang, " + loggedInUser.getEmail());
            return true;
        } else {
            System.out.println("Email atau password salah.");
            return false;
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
            users.put(email, new Customer(email, password, "1", nama));
            System.out.println("Registrasi berhasil!");
        }
    }
    public static void showMainMenu() {
        int choice;
        do {
            System.out.println("\nMenu:");
            System.out.println("1. Lihat Riwayat Order");
            System.out.println("2. Buat Komplain");
            System.out.println("3. Cari Tukang");
            System.out.println("4. Membuat Pesanan");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1: // Lihat Riwayat Order
                    System.out.println("\nRiwayat Order untuk " + loggedInUser.getName() + ":");
                    if (loggedInUser instanceof Customer) {
                        Customer customer = (Customer) loggedInUser;
                        boolean found = false;
                        for (Order o : orders) {
                            if (o.getCustomer().getId().equals(customer.getId())) {
                                o.printOrderInfo();
                                System.out.println("--------------------------------");
                                found = true;
                            }
                        }
                        if (!found) {
                            System.out.println("Tidak ada riwayat order.");
                        }
                    } else {
                        System.out.println("Hanya customer yang dapat melihat riwayat order.");
                    }
                    break;

                case 2: // Buat Komplain
                    System.out.println("\nMasukkan ID Order untuk komplain: ");
                    String orderId = sc.next();
                    boolean found = false;

                    for (Order o : orders) {
                        if (o.getId().equals(orderId)) {
                            System.out.println("Masukkan komplain Anda: ");
                            sc.nextLine(); // Clear buffer
//                            String complaint = sc.nextLine();
//                            o.addComplaint(complaint);
                            System.out.println("Komplain berhasil ditambahkan!");
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Order dengan ID tersebut tidak ditemukan.");
                    }
                    break;
                case 3:
                    search();
                    break;
                case 4: // Membuat Pesanan
                    System.out.println("\nDaftar Tukang yang Tersedia:");
                    for (String key : tukangItems.keySet()) {
                        Tukang tukang = tukangItems.get(key);
                        System.out.println("ID: " + key + ", Nama: " + tukang.getName() + ", Layanan: " + tukang.getServiceCategory().getName() + ", Harga: " + tukang.getServiceCategory().getPrice());
                    }

                    System.out.println("Masukkan ID Tukang yang ingin dipesan: ");
                    sc.nextLine(); // Clear buffer
                    String tukangId = sc.nextLine();

                    Tukang selectedTukang = tukangItems.get(tukangId);

                    if (selectedTukang != null) {
                        order(selectedTukang); // Memanggil method order
                    } else {
                        System.out.println("ID Tukang tidak ditemukan.");
                    }
                    break;
                case 0: // Keluar
                    System.out.println("Terima kasih telah menggunakan aplikasi.");
                    break;

                default:
                    System.out.println("Pilihan tidak valid.");
            }
        } while (choice != 0);

        sc.close();
    }
    public static void search(){
        System.out.println("==========SEARCH TUKANG==========");
        System.out.println("1. Cari Tukang berdasarkan nama");
        System.out.println("2. Cari Tukang berdasarkan service");
        System.out.println("9. Kembali");
        System.out.println("Pilih Opsi:");
        Scanner sc2 = new Scanner(System.in);
        int input = sc2.nextInt();
        while(input != 0){

            if (input == 1){
                searchTukangByName();
            } else if (input == 2){
                searchTukangByServices();
            } else if (input == 9){
                showMainMenu();
            } else {
                System.out.println("Input invalid");
            }
            System.out.println("==========SEARCH TUKANG==========");
            System.out.println("1. Cari Tukang berdasarkan nama");
            System.out.println("2. Cari Tukang berdasarkan service");
            System.out.println("9. Kembali");
            System.out.println("Pilih Opsi Pencarian:");
            input = sc.nextInt();
        }

    }
    public static void searchTukangByName() {
        String ind = null;
        System.out.println("Masukaan nama tukang:");
        Scanner sc2 = new Scanner(System.in);
        String item = sc2.nextLine();

        for (String i : tukangItems.keySet()) {
            if (tukangItems.get(i).getName().equals(item)) {

                ind = i;
            }
        }
        if (ind != null) {
            System.out.println(tukangItems.get(ind).getName());
            System.out.println(tukangItems.get(ind).getPhoneNumber());
            System.out.println(tukangItems.get(ind).getEmail());
            System.out.println(tukangItems.get(ind).getServiceCategory().getName());
            System.out.println(tukangItems.get(ind).getServiceCategory().getPrice());
            System.out.println();
            order(tukangItems.get(ind));
        } else {
            System.out.println("Tukang tidak ditemukan");
        }

    }
    public static void searchTukangByServices() {
        System.out.println("Masukaan jenis servis:");
        Scanner sc2 = new Scanner(System.in);
        String item = sc2.nextLine();
        for (Services s : servicesItems) {
            if (s.getName().equals(item)) {
                ArrayList<Tukang> listTukang = s.getListTukang();
                for (Tukang tukang : listTukang) {
                    System.out.println("Nama: " + tukang.getName() + " Phone Number: " + tukang.getPhoneNumber());

                }
                System.out.println("Pilih tukang sesuai Urutan: ");
                int item2 = sc2.nextInt();
                order(listTukang.get(item2 - 1));
            }
        }

    }
    public static void order(Tukang tukang){
        System.out.println("==========PESAN TUKANG==========");
        System.out.println("1. Pesan Tukang");
        System.out.println("9. Kembali");
        System.out.println("Pilih Opsi:");
        int input = sc.nextInt();
        Scanner sc2  = new Scanner(System.in);
        if (input == 1) {
            System.out.println("Anda memesan tukang: " + tukang.getServiceCategory().getName() + " Pak " + tukang.getName());
            System.out.println("Total harga: " + tukang.getServiceCategory().getPrice());
            orders.add(new Order("1", tukang, loggedInUser, tukang.getServiceCategory().getPrice(), "Selesai" , null));
            System.out.println("Terimakasih sudah menggunakan service kami");
            tukang.addBalance(tukang.getServiceCategory().getPrice());
            rate(tukang);
        } else if (input == 9) {
            showMainMenu();
        } else {
            System.out.println("Input invalid");
            showMainMenu();
        }

    }

    public static void rate(Tukang tukang) {
        System.out.println("Apakah Anda ingin memberi rating terhadapt tukang?");
        System.out.println("1. Ya");
        System.out.println("2. Tidak");
        System.out.println("Pilih Opsi: ");
        int input = sc.nextInt();
        Scanner sc2  = new Scanner(System.in);
        if (input == 1) {
            double inputRate = sc2.nextDouble();
            tukang.addRating(inputRate);
            showMainMenu();
        } else if (input == 2) {
            showMainMenu();
        } else {
            System.out.println("Input invalid");
            rate(tukang);
        }
    }
}

