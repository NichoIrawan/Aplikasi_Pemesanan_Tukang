package tubespbo.src.userClass;

import tubespbo.src.Main;
import tubespbo.src.component.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Customer extends User {
    //----- Data Declaration -----
    private Address[] addresses;
    private Tukang[] tukangFavorit;
    private ArrayList<Complaint> complaints;

    static Scanner sc = new Scanner(System.in);
    //----------------------------

    public Customer(String email, String password, String id, String name) {
        super(email, password, id, name);
    }

    //----- Address method -----
    public void getAddresses() {
        for (Address address : addresses) {
            System.out.println(address);
        }
    }

    private void addAddress(Address address) {
        addresses[addresses.length - 1] = address;
    }

    public void changeAddresses(int i, Address address) {
        try {
            if (addresses.length <= 3) {
                addAddress(address);
            } else {
                this.addresses[i-1] = address;
            }
        } catch (Exception e) {
            System.out.println("[Error] Alamat tidak valid");
        }
    }

    public void removeAddress(int i, Address address) {
        this.addresses[i-1] = null;
    }
    //--------------------------

    //----- Tukang favorit method -----
    public void getTukangFavorit() {
        for (Tukang tukang : tukangFavorit) {
            System.out.println(tukang);
        }
    }

    private void addTukangFavorit(Tukang tukang) {
        tukangFavorit[tukangFavorit.length - 1] = tukang;
    }

    public void changeTukangFavorit(int i, Tukang tukang) {
        try {
            if (tukangFavorit.length <= 5) {
                addTukangFavorit(tukang);
            } else {
                if (this.tukangFavorit[i].getId().equals(tukang.getId())) {
                    System.out.println("[Error] Tukang sudah masuk ke daftar favorit");
                    return;
                }
                this.tukangFavorit[i] = tukang;
            }
        } catch (Exception e) {
            System.out.println("[Error] Tukang tidak valid");
        }
    }
    //---------------------------------

    //----- Complain method -----
    public void complaint (Order order) {
        System.out.print("Masukkan komplain Anda: ");
        sc.nextLine(); // Clear buffer

        String complaint = sc.nextLine();
        System.out.println("Komplain berhasil ditambahkan!");

        Complaint com = new Complaint(complaint, order.getId());
        complaints.add(com);
    }

    public ArrayList<Complaint> getComplaints() {
        return complaints;
    }
    //---------------------------

    public void order(Tukang tukang){
        System.out.println("==========PESAN TUKANG==========");
        System.out.println("1. Pesan Tukang");
        System.out.println("9. Kembali");
        System.out.println("Pilih Opsi:");
        int input = sc.nextInt();

        switch (input) {
            case 1:
                System.out.println("Anda memesan tukang: " + tukang.getServiceCategory().getName() + " Pak " + tukang.getName());
                System.out.println("Total harga: " + tukang.getServiceCategory().getPrice());
                super.addOrderHistory(new Order("1", tukang, this, tukang.getServiceCategory().getPrice(), "Selesai" , null));
                callMenu();
                break;
            case 9:
                callMenu();
                break;
            default:
                System.out.println("[Error] Pilih Opsi tidak valid");
                callMenu();
                break;
        }
    }

    //----- Search method ------
    public void search(HashMap<String, Tukang> tukangList, ArrayList<Services> servicesList) {
        System.out.println("==========SEARCH TUKANG==========");
        System.out.println("1. Cari Tukang berdasarkan nama");
        System.out.println("2. Cari Tukang berdasarkan service");
        System.out.println("9. Kembali");
        System.out.println("Pilih Opsi:");
        Scanner sc2 = new Scanner(System.in);
        int input = sc2.nextInt();
        while(input != 0){
            switch(input){
                case 1:
                    searchTukangByName(tukangList);
                    break;

                case 2:
                    searchTukangByServices(servicesList);
                    break;

                case 9:
                    callMenu();
                    break;

                default:
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

    private void searchTukangByName(HashMap<String, Tukang> tukangItems) {
        String ind = null;
        System.out.println("Masukkan nama tukang:");
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

    private void searchTukangByServices(ArrayList<Services> servicesItems) {
        System.out.println("Masukkan jenis servis:");
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
    //--------------------------

    @Override
    public void callMenu() {
        int choice;

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Lihat Riwayat Order");
            System.out.println("2. Buat Komplain");
            System.out.println("3. Cari Tukang");
            System.out.println("4. Membuat Pesanan");
            System.out.println("9. Keluar");
            System.out.print("Pilih menu: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1: // Lihat Riwayat Order
                    System.out.println("\nRiwayat Order untuk " + super.getName() + ":");
                    this.OrderHistoryString();
                    break;

                case 2: // Buat Komplain
                    System.out.println("\nMasukkan ID Order untuk komplain: ");
                    String orderId = sc.next();
                    boolean found = false;

                    for (Order o : super.getOrderHistory()) {
                        if (o.getId().equals(orderId)) {
                            complaint(o);
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Order dengan ID tersebut tidak ditemukan.");
                    }
                    break;

                case 3:
                    search(Main.tukangItems, Main.servicesItems);
                    break;

                case 4: // Membuat Pesanan
                    System.out.println("\nDaftar Tukang yang Tersedia:");
                    for (String key : Main.tukangItems.keySet()) {
                        Tukang tukang = Main.tukangItems.get(key);
                        System.out.println("ID: " + key + ", Nama: " + tukang.getName() + ", Layanan: " + tukang.getServiceCategory().getName() + ", Harga: " + tukang.getServiceCategory().getPrice());
                    }

                    System.out.println("Masukkan ID Tukang yang ingin dipesan: ");
                    sc.nextLine(); // Clear buffer
                    String tukangId = sc.nextLine();

                    Tukang selectedTukang = Main.tukangItems.get(tukangId);

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
        } while (choice != 9);

        sc.close();
    }
}
