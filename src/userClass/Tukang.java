package tubespbo.src.userClass;

import tubespbo.src.component.Services;

public class Tukang extends User{
    private double rating;
    private long[] certification;
    private double balance;
    private Services serviceCategory;

    public Tukang(String email, String password, String id, String name, double rating, Services serviceCategory) {
        super(email, password, id, name);
        this.rating = rating;
        this.serviceCategory = serviceCategory;
    }

    public Services getServiceCategory() {
        return serviceCategory;
    }
}
