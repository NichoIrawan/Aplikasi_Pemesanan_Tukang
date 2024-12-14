package tubespbo.src.userClass;

import tubespbo.src.component.Services;

public class Tukang extends User{
    private double rating;
    private long[] certification;
    private double balance;
    private Services serviceCategory;

    public Tukang(String email, String password, String id, String name, Services serviceCategory) {
        super(email, password, id, name);
        this.rating = 0;
        this.balance = 0;
        this.serviceCategory = serviceCategory;
        serviceCategory.addListTukang(this);
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Services getServiceCategory() {
        return serviceCategory;
    }

    public void setServiceCategory(Services serviceCategory) {
        this.serviceCategory.removeListTukang(this);
        this.serviceCategory = serviceCategory;
        this.serviceCategory.addListTukang(this);
    }


}
