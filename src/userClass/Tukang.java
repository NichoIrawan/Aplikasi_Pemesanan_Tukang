package tubespbo.src.userClass;

import tubespbo.src.component.Certificate;
import tubespbo.src.component.Order;
import tubespbo.src.component.Services;
import tubespbo.src.component.StatusOrder;

import java.util.ArrayList;
import java.util.Scanner;

public class Tukang extends User{
    private double rating;
    private ArrayList<Certificate> certificationList = new ArrayList<>();
    private double balance;
    private Services serviceCategory;
    private ArrayList<Order> ongoingOrders = new ArrayList<>();
    private int orderCount;
    static Scanner sc = new Scanner(System.in);

    //Dummy purpose only
    public Tukang(String email, String password, int id, String name, double rating, double balance, Services serviceCategory, int orderCount) {
        super(email, password, id, name);
        this.rating = rating;
        this.balance = balance;
        this.serviceCategory = serviceCategory;
        this.orderCount = orderCount;
        serviceCategory.addListTukang(this);
    }
    //------------------

    public Tukang(String email, String password, int id, String name, Services serviceCategory) {
        super(email, password, id, name);
        this.rating = 0;
        this.balance = 0;
        this.orderCount = 0;
        this.serviceCategory = serviceCategory;
        serviceCategory.addListTukang(this);
    }

    public void addTukangOrder(Order order) {
        ongoingOrders.add(order);
    }

    public double getRating() {
        return rating/orderCount;
    }

    public void addRating(double rating) {
        this.rating += rating;
    }

    public void addBalance(double balance) {this.balance += balance;}

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setServiceCategory(Services serviceCategory) {
        this.serviceCategory.removeListTukang(this);
        this.serviceCategory = serviceCategory;
        this.serviceCategory.addListTukang(this);
    }

    public void getCertification() {
        for (Certificate certificate : certificationList) {
            System.out.println(certificate.certificateImg);
        }
    }

    public Services getServiceCategory() {
        return serviceCategory;
    }

    private void addCertification(Certificate certification) {
        certificationList.add(certification);
    }

    public void setCertification(Certificate certification) {
        try {
            if (this.certificationList.size() <= 5) {
                addCertification(certification);
            } else {
                if (certification.getIdTukang() == super.getId() && certification.isVerified()){
                    this.certificationList.add(certification);
                } else {
                    System.out.println("Sertifikat belum terverifikasi");
                }
            }
        } catch (Exception e) {
            System.out.println("[Error] Index tidak valid");
        }
    }

    public Certificate proposeCertification(String certificationImg) {
        return new Certificate(super.getId(), certificationImg);
    }

    public void accOrder(){
        System.out.println();

        try {
            if(ongoingOrders.isEmpty()){
                System.out.println("Belum ada pesanan untuk saat ini");
            } else {
                for (Order order : ongoingOrders) {
                    System.out.println("Order ID: " + order.getId());
                    order.printOrderInfoTukang();
                    System.out.println();
                }

                System.out.println("Pilih id order yang ingin diterima: ");
                int item = sc.nextInt();

                if(item > ongoingOrders.size() || item < 0){
                    System.out.println("Order tidak ditemukan");
                } else {
                    if (ongoingOrders.get(item-1).getStatus().equals(StatusOrder.MenungguKonfirmasi)) {
                        ongoingOrders.get(item-1).setStatus(StatusOrder.DalamProsesPembayaran);
                        System.out.println("Berhasil menerima order!");
                    } else {
                        System.out.println("Pesanan sudah dikonfirmasi");
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("[Error] Index tidak valid");
            sc.nextLine();
        }
    }

    @Override
    public void callMenu() {
        int choice;

        do {
            System.out.println("\n=========== Menu Tukang ===========");
            System.out.println("Jenis jasa anda: " + this.serviceCategory.getName());
            System.out.println("Harga jasa anda: " + this.serviceCategory.getPrice());
            System.out.println("Saldo anda: " + this.balance);
            System.out.println("-------------------------------------");
            System.out.println("1. Terima Order");
            System.out.println("2. Sertifikat");
            System.out.println("3. Lihat History Pesanan");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1: // Terima Order
                    accOrder();
                    break;

                case 2: // Sertifikat
                    certificateMenu();
                    break;

                case 3: // Lihat history pekerjaan
                    System.out.println("History Anda");
                    if(ongoingOrders.isEmpty()){
                        System.out.println("Belum ada pesanan");
                    }
                    for (Order order : ongoingOrders) {
                        if (order.getStatus().equals(StatusOrder.Selesai)) {
                            order.printOrderInfoTukang();
                        }
                    }
                    break;

                case 0: // Keluar
                    System.out.println("Terima kasih telah menggunakan aplikasi.");
                    break;

                default:
                    System.out.println("Pilihan tidak valid.");
            }
        } while (choice != 0);
    }

    @Override
    public String toString() {
        return String.format(
                "%d-%s %.2f [%s]\n",
                super.getId(), super.getName(), this.rating, this.serviceCategory.getName()
        );
    }

    public void certificateMenu(){
        int choice;
        do {
            System.out.println("1. Lihat Sertifikat");
            System.out.println("2. Tambah Sertifikat");
            System.out.println("3. Hapus Sertifikat");
            System.out.println("0. Kembali");
            System.out.print("Pilih menu: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1: // Lihat Sertifikat
                    System.out.println("Sertifikat Anda");
                    for (Certificate cert : certificationList) {
                        System.out.println(cert.toString());
                    }
                    System.out.println();
                    break;
                case 2: // Tambah Sertifikat
                    System.out.println("Tambah file sertifikat: ");
                    String fileId = sc.nextLine();
                    Certificate cert = new Certificate(certificationList.size() + 1, fileId);
                    addCertification(cert);
                    break;

                case 3: // Hapus Sertifikat
                    for (Certificate certs : certificationList) {
                        System.out.println(certs.toString());
                    }
                    System.out.println();
                    System.out.println("Pilih sertifikat yang ingin dihapus: ");
                    int item = sc.nextInt();
                    certificationList.remove(item - 1);
                    break;

                case 0: // Keluar
                    callMenu();
                    break;

                default:
                    System.out.println("Pilihan tidak valid.");
            }
        } while (choice != 0);
    }
}
