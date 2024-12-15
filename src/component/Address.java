package tubespbo.src.component;

public class Address {
    private String detailAddress;
    private String kelurahan;
    private String kecamatan;
    private String kota;
    private String provinsi;
    private int kodePos;

    public Address(String detailAddress, String kelurahan, String kecamatan, String kota, String provinsi, int kodePos) {
        this.detailAddress = detailAddress;
        this.kelurahan = kelurahan;
        this.kecamatan = kecamatan;
        this.kota = kota;
        this.provinsi = provinsi;
        this.kodePos = kodePos;
    }

    public String getDetailAddress() {
        return detailAddress;
    }

    public String getKelurahan() {
        return kelurahan;
    }

    public String getKecamatan() {
        return kecamatan;
    }

    public String getKota() {
        return kota;
    }

    public String getProvinsi() {
        return provinsi;
    }

    public int getKodePos() {
        return kodePos;
    }
}
