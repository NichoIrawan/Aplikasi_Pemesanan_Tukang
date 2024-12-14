package tubespbo.src.component;

import tubespbo.src.userClass.Tukang;

import java.util.ArrayList;

public class Services {
    private String name;
    private String description;
    private double price;
    private ArrayList<Tukang> listTukang;

    public Services(String name, String description, double price) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.listTukang = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public ArrayList<Tukang> getListTukang() {
        return listTukang;
    }

    public void addListTukang(Tukang tukang) {
        listTukang.add(tukang);
    }

    public void removeListTukang(Tukang tukang) {
        listTukang.remove(tukang);
    }
}
