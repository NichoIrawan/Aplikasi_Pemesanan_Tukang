package tubespbo.src;

import tubespbo.src.component.Services;
import tubespbo.src.userClass.Tukang;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    static HashMap<String , Tukang> tukangItems = new HashMap<>();
    static Services plumber = new Services("Tukang Ledeng", "Penyelesai masalah toilet", 300000);
    static Services foreman = new Services("Mandor", "Pengawas Lapangan", 300000);
    static ArrayList<Services> servicesItems = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        servicesItems.add(plumber);
        servicesItems.add(foreman);
        Tukang tukang1 = new Tukang("Budi@gmail.com", "023123", "1", "Budi Setiawan", 0.0, plumber);
        Tukang tukang2 = new Tukang("tololgaming123@gmail.com", "1293109", "2", "Aryosetown", 0.0, plumber);
        plumber.addListTukang(tukang1);
        plumber.addListTukang(tukang2);
        tukangItems.put("1", tukang1);
        tukangItems.put("2", tukang2);
        search();


        
    }

    public static void search(){
        System.out.println("==========SEARCH TUKANG==========");
        System.out.println("1. Cari Tukang berdasarkan nama");
        System.out.println("2. Cari Tukang berdasarkan service");
        System.out.println("Pilih Opsi:");
        int input = Integer.parseInt(sc.nextLine());
        while(input != 0){

            if (input == 1){
                searchTukangByName();
            } else if (input == 2){
                searchTukangByServices();
            } else {
                System.out.println("Input invalid");
            }
            System.out.println("==========SEARCH TUKANG==========");
            System.out.println("1. Cari Tukang berdasarkan nama");
            System.out.println("2. Cari Tukang berdasarkan service");
            System.out.println("Pilih Opsi Pencarian:");
            input = Integer.parseInt(sc.nextLine());
        }

    }

    public static void searchTukangByName() {
        String ind = null;
        System.out.println("Masukaan nama tukang:");
        String item = sc.nextLine();
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
            order(tukangItems.get(ind));
        } else {
            System.out.println("Tukang tidak ditemukan");
        }

    }

    public static void searchTukangByServices() {
        System.out.println("Masukaan jenis servis:");
        String item = sc.nextLine();
        for (Services s : servicesItems) {
            if (s.getName().equals(item)) {
                ArrayList<Tukang> listTukang = s.getListTukang();
                for (Tukang tukang : listTukang) {
                    System.out.println(tukang.getName());
                }
                System.out.println("Pilih tukang sesuai Urutan: ");
                int item2 = Integer.parseInt(sc.nextLine());
                order(listTukang.get(item2 - 1));
            }
        }

    }

    public static void order(Tukang tukang){
        System.out.println("==========PESAN TUKANG==========");
        System.out.println("1. Pesan Tukang");
        System.out.println("9. Kembali");
        System.out.println("Pilih Opsi:");
        int input = Integer.parseInt(sc.nextLine());
        if (input == 1) {
            System.out.println("Anda memesan tukang: " + tukang.getServiceCategory().getName() + " Pak " + tukang.getName());
            System.out.println("Total harga: " + tukang.getServiceCategory().getPrice());
            search();
        } else if (input == 9) {
            search();
        } else {
            System.out.println("Input invalid");
            search();
        }

    }



}
