package tubespbo.src.component;

public class Address {
    private String desc;
    private String jalan;
    private String kelurahan;
    private String kecamatan;
    private String kota;
    private String provinsi;
    private String kodePos;

    public Address(String jalan, String kelurahan, String kecamatan, String kota, String provinsi, String kodePos) {
        this.desc = "";
        this.jalan = jalan;
        this.kelurahan = kelurahan;
        this.kecamatan = kecamatan;
        this.kota = kota;
        this.provinsi = provinsi;
        this.kodePos = kodePos;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getJalan() {
        return jalan;
    }

    public void setJalan(String jalan) {
        this.jalan = jalan;
    }

    public String getKelurahan() {
        return kelurahan;
    }

    public void setKelurahan(String kelurahan) {
        this.kelurahan = kelurahan;
    }

    public String getKecamatan() {
        return kecamatan;
    }

    public void setKecamatan(String kecamatan) {
        this.kecamatan = kecamatan;
    }

    public String getKota() {
        return kota;
    }

    public void setKota(String kota) {
        this.kota = kota;
    }

    public String getProvinsi() {
        return provinsi;
    }

    public void setProvinsi(String provinsi) {
        this.provinsi = provinsi;
    }

    public String getKodePos() {
        return kodePos;
    }

    public void setKodePos(String kodePos) {
        this.kodePos = kodePos;
    }

    @Override
    public String toString() {
        return String.format("%s, %s, %s, %s, %s %s",
                jalan, kelurahan, kecamatan, kota, provinsi, kodePos);
    }
}
