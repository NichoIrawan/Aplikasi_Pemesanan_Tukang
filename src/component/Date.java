package tubespbo.src.component;

public class Date {
    private int tanggal;
    private int bulan;
    private int tahun;


    public Date(int tanggal, int bulan, int tahun) {
        this.tanggal = tanggal;
        this.bulan = bulan;
        this.tahun = tahun;
    }

    public int getTanggal() {
        return tanggal;
    }

    public int getBulan() {
        return bulan;
    }

    public int getTahun() {
        return tahun;
    }

    public void setTanggal(int tanggal) {
        this.tanggal = tanggal;
    }

    public void setBulan(int bulan) {
        this.bulan = bulan;
    }

    public void setTahun(int tahun) {
        this.tahun = tahun;
}

    @Override
    public String toString() {
        return String.format("%02d-%02d-%04d", tanggal, bulan, tahun);
    }
}
