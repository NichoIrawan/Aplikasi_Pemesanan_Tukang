package tubespbo.src.userClass;

import tubespbo.src.component.Certificate;
import tubespbo.src.component.Services;

public class Tukang extends User{
    private double rating;
    private Certificate[] certification;
    private double balance;
    private Services serviceCategory;
    private int orderCount;

    //Dummy purpose only
    public Tukang(String email, String password, String id, String name, double rating, double balance, Services serviceCategory, int orderCount) {
        super(email, password, id, name);
        this.rating = rating;
        this.balance = balance;
        this.serviceCategory = serviceCategory;
        this.orderCount = orderCount;
        serviceCategory.addListTukang(this);
    }
    //------------------

    public Tukang(String email, String password, String id, String name, Services serviceCategory) {
        super(email, password, id, name);
        this.rating = 0;
        this.balance = 0;
        this.orderCount = 0;
        this.serviceCategory = serviceCategory;
        serviceCategory.addListTukang(this);
    }

    public double getRating() {
        return rating/orderCount;
    }

    public void addRating(double rating) {
        this.rating += rating;
    }

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
        for (Certificate certificate : certification) {
            System.out.println(certificate.certificateImg);
        }
    }

    public Services getServiceCategory() {
        return serviceCategory;
    }

    private void addCertification(Certificate certification) {
        this.certification[this.certification.length - 1] = certification;
    }

    public void setCertification(int i, Certificate certification) {
        try {
            if (this.certification.length <= 5) {
                addCertification(certification);
            } else {
                if (certification.getIdTukang().equals(super.getId()) && certification.isVerified()){
                    this.certification[i] = certification;
                } else {
                    System.out.println("Sertifikat belum terverifikasi");
                }
            }
        } catch (Exception e) {
            System.out.println("[Error] Index tidak valid");
        }
    }


    public Certificate proposeCertification(long certificationImg) {
        return new Certificate(super.getId(), certificationImg);
    }

    public void confirmOrder() {
        orderCount++;
    }

    @Override
    public void callMenu() {

    }
}
