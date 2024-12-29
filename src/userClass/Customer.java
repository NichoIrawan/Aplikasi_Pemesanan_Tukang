package tubespbo.src.userClass;

import tubespbo.src.Driver;
import tubespbo.src.component.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Customer extends User {
    //----- Data Declaration -----
    private ArrayList<Address> addresses;
    private ArrayList<Tukang> tukangFavorit;
    private ArrayList<Complaint> complaints;
    private ArrayList<Order> ongoingOrders;

    static Scanner sc = new Scanner(System.in);
    //----------------------------

    public Customer(String email, String password, int id, String name) {
        super(email, password, id, name);
        addresses = new ArrayList<>();
        tukangFavorit = new ArrayList<>();
        complaints = new ArrayList<>();
        ongoingOrders = new ArrayList<>();
    }

    //----- Address method -----
    public void getAddresses() {
        for (Address address : addresses) {
            System.out.println(address);
        }
    }

    private void addAddress(Address address) {
        addresses.add(address);
    }

    public void changeAddresses(int i, Address address) {
        try {
            if (addresses.size() <= 3) {
                addAddress(address);
            } else {
                this.addresses.set(i, address);
            }
        } catch (Exception e) {
            System.out.println("[Error] Alamat tidak valid");
        }
    }

    public void removeAddress(int i) {
        this.addresses.remove(i);
    }

    public void AddressMenu() {
        String jalan, kelurahan, kecamatan, kota, provinsi, kode;
        int i;

        System.out.println("==========ALAMAT==========");
        getAddresses();
        System.out.println("--------------------------");
        System.out.println("1. Tambah alamat");
        System.out.println("2. Ganti alamat");
        System.out.println("3. Hapus alamat");
        System.out.println("0. Keluar");
        System.out.print("Pilih opsi: ");
        int input = sc.nextInt();

        switch (input) {
            case 1:
                System.out.print("Jalan: ");
                jalan = sc.next();
                System.out.println("Kelurahan");
                kelurahan = sc.next();
                System.out.println("Kecamatan");
                kecamatan = sc.next();
                System.out.println("Kota: ");
                kota = sc.next();
                System.out.println("Provinsi: ");
                provinsi = sc.next();
                System.out.println("Kode pos: ");
                kode = sc.next();

                addAddress(new Address(jalan, kelurahan, kecamatan, kota, provinsi, kode));
                System.out.println("Alamat berhasil ditambahkan");
                break;

            case 2:
                try{
                    System.out.print("Index yang diganti: ");
                    i = sc.nextInt();

                    System.out.print("Jalan: ");
                    jalan = sc.next();
                    System.out.println("Kelurahan");
                    kelurahan = sc.next();
                    System.out.println("Kecamatan");
                    kecamatan = sc.next();
                    System.out.println("Kota: ");
                    kota = sc.next();
                    System.out.println("Provinsi: ");
                    provinsi = sc.next();
                    System.out.println("Kode pos: ");
                    kode = sc.next();

                    changeAddresses(i, new Address(jalan, kelurahan, kecamatan, kota, provinsi, kode));
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("Index salah.");;
                }

                break;

            case 3:
                try{
                    System.out.println("Index yang ingin dihapus: ");
                    i = sc.nextInt();
                    removeAddress(i);
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("Index salah.");
                    ;
                }
        }
    }
    //--------------------------

    //----- Tukang favorit method -----
    private void addTukangFavorit(Tukang tukang) {
        tukangFavorit.add(tukang);
    }

    public void changeTukangFavorit(int i, Tukang tukang) {
        try {
            if (tukangFavorit.size() < 3) {
                addTukangFavorit(tukang);
            } else {
                if (this.tukangFavorit.get(i).getId() == tukang.getId()) {
                    System.out.println("[Error] Tukang sudah masuk ke daftar favorit");
                    return;
                }
                this.tukangFavorit.set(i, tukang);
            }
        } catch (Exception e) {
            System.out.println("[Error] Tukang tidak valid");
        }
    }

    public void printTukangFavorit() {
        for (Tukang tukang : tukangFavorit) {
            if (tukang != null) {
                System.out.printf("%d %s - %s\n", tukang.getId(), tukang.getName(), tukang.getServiceCategory().getName());
            }
        }
    }

    public void tukangFavoritMenu() {
        System.out.println("==========TUKANG FAVORIT==========");
        printTukangFavorit();
        System.out.println("----------------------------------");
        System.out.println("1. Tambah Tukang Favorit");
        System.out.println("2. Ganti Tukang Favorit");
        System.out.println("0. Keluar");
        System.out.print("Pilih opsi: ");
        int input = sc.nextInt();

        switch (input) {
            case 1:
                if (tukangFavorit.size() <= 3) {
                    for (String key : Driver.tukangItems.keySet()) {
                        System.out.println(Driver.tukangItems.get(key));
                    }
                    System.out.print("Masukkan id Tukang: ");
                    String idTukang = sc.next();

                    if (Driver.tukangItems.containsKey(idTukang)) {
                        if (!(tukangFavorit.contains(Driver.tukangItems.get(idTukang)))) {
                            Tukang tukang = Driver.tukangItems.get(idTukang);
                            addTukangFavorit(tukang);
                        } else {
                            System.out.println("[Error] Tukang sudah ada");
                        }
                    } else {
                        System.out.println("[Error] ID Tukang tidak valid");
                    }
                }
                break;

            case 2:
                for (Tukang tukang : tukangFavorit) {
                    System.out.println(tukang);
                }
                System.out.println();
                System.out.print("Urutan yang ingin diganti: ");
                int i = sc.nextInt();
                System.out.print("Masukkan ID tukang yang ingin dimasukkan: ");
                String idTukang = sc.next();

                if (Driver.tukangItems.containsKey(idTukang)) {
                    changeTukangFavorit(i - 1, Driver.tukangItems.get(idTukang));
                }
                break;

            case 0:
                callMenu();
                break;

            default:
                System.out.println("[Error] Input tidak valid");
                callMenu();
                break;
        }
    }
    //---------------------------------

    //----- Complain method -----
    public void complaint (Order order) {
        System.out.print("Masukkan komplain Anda: ");
        sc.nextLine(); // Clear buffer

        String complaint = sc.nextLine();

        complaints.add(new Complaint(complaint, order.getId()));
        System.out.println("Komplain berhasil ditambahkan!");
    }

    public ArrayList<Complaint> getComplaints() {
        return complaints;
    }

    public void printComplaints() {
        for (Complaint complaint : complaints) {
            System.out.println(complaint);
        }
    }
    //---------------------------

    public void order(Tukang tukang){
        System.out.println("==========PESAN TUKANG==========");
        System.out.println("1. Pesan Tukang");
        System.out.println("0. Kembali");
        System.out.println("Pilih Opsi:");
        int input = sc.nextInt();

        switch (input) {
            case 1:
                Order order = new Order(super.getOrderHistory().size() + 1, tukang, this, tukang.getServiceCategory().getPrice(), "MenungguKonfirmasi" , null);
                System.out.println("Anda memesan tukang: " + tukang.getServiceCategory().getName() + " Pak " + tukang.getName());
                System.out.println("Total harga: " + tukang.getServiceCategory().getPrice());
                ongoingOrders.add(order);
                tukang.addTukangOrder(order);
                callMenu();
                break;
            case 0:
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
        int input = -1;
        while(input != 0){
            System.out.println("==========SEARCH TUKANG==========");
            System.out.println("1. Cari Tukang berdasarkan nama");
            System.out.println("2. Cari Tukang berdasarkan service");
            System.out.println("0. Kembali");
            System.out.println("Pilih Opsi Pencarian:");
            input = sc.nextInt();
            switch(input){
                case 1:
                    searchTukangByName(tukangList);
                    break;

                case 2:
                    searchTukangByServices(servicesList);
                    break;

                case 0:
                    break;

                default:
                    System.out.println("Input invalid");
            }
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

    // Bayar Tukang
    public void finishOrder(Order order) {
        order.callMenuPembayaran();
        System.out.print("Bayar (Y/N): ");
        String input = sc.nextLine();

        if (input.equalsIgnoreCase("y")) {
            order.getTransaction().setStatus(true);
            order.setStatus(StatusOrder.Selesai);
            order.getTukang().addBalance(order.getTransaction().getTotalPrice());
            super.addOrderHistory(order);
        }
    }

    @Override
    public void callMenu() {
        int choice = -1;

        do {
            try {
                System.out.println("\n===== Menu =====");
                for (Order order : super.getOrderHistory()) {
                    if (!(order.getStatus().equals(StatusOrder.Selesai))) {
                        order.printOrderInfo();
                    }
                }
                System.out.println("------------------");
                System.out.println("1. Lihat Riwayat Order");
                System.out.println("2. Buat Komplain");
                System.out.println("3. Riwayat Komplain");
                System.out.println("4. Cari Tukang");
                System.out.println("5. Membuat Pesanan");
                System.out.println("6. Simpan alamat");
                System.out.println("7. Tukang favorit");
                System.out.println("8. Bayar order");
                System.out.println("0. Keluar");
                System.out.print("Pilih menu: ");
                choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {
                    case 1: // Lihat Riwayat Order
                        System.out.println("\nRiwayat Order untuk " + super.getName() + ":");
                        super.OrderHistoryString();
                        break;

                    case 2: // Buat Komplain
                        super.OrderHistoryString();
                        System.out.println("\nMasukkan ID Order untuk komplain: ");
                        int orderId = sc.nextInt();
                        boolean found = false;

                        for (Order o : super.getOrderHistory()) {
                            if (o.getId() == orderId) {
                                complaint(o);
                                found = true;
                                break;
                            }
                        }
                        if (!found) {
                            System.out.println("Order dengan ID tersebut tidak ditemukan.");
                        }
                        break;

                    case 3: // Lihat komplain
                        printComplaints();
                        break;

                    case 4:
                        search(Driver.tukangItems, Driver.servicesItems);
                        break;

                    case 5: // Membuat Pesanan
                        System.out.println("\nDaftar Tukang yang Tersedia:");
                        for (String key : Driver.tukangItems.keySet()) {
                            Tukang tukang = Driver.tukangItems.get(key);
                            System.out.println("ID: " + key + ", Nama: " + tukang.getName() + ", Layanan: " + tukang.getServiceCategory().getName() + ", Harga: " + tukang.getServiceCategory().getPrice());
                        }

                        System.out.println("Masukkan ID Tukang yang ingin dipesan: ");
                        String tukangId = sc.nextLine();

                        Tukang selectedTukang = Driver.tukangItems.get(tukangId);

                        if (selectedTukang != null) {
                            order(selectedTukang); // Memanggil method order
                        } else {
                            System.out.println("ID Tukang tidak ditemukan.");
                        }
                        break;

                    case 6:
                        AddressMenu();
                        break;

                    case 7:
                        tukangFavoritMenu();
                        break;

                    case 8:
                        for (Order order : ongoingOrders) {
                            order.printOrderInfo();
                        }

                        System.out.println("Masukkan ID Order untuk dibayar: ");
                        int idOrder = sc.nextInt();
                        sc.nextLine();

                        finishOrder(ongoingOrders.get(idOrder - 1));
                        break;

                    case 0: // Keluar
                        System.out.println("Terima kasih telah menggunakan aplikasi.");
                        break;

                    default:
                        System.out.println("Pilihan tidak valid.");
                }
            } catch (Exception e) {
                System.out.println("Pilihan tidak valid");
                sc.nextLine();
            }
        } while (choice != 0);
    }


}
