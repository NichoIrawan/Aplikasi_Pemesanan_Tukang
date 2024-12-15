package tubespbo.src.component;

public class Certificate {
    public final long certificateImg;
    private final String idTukang;
    private boolean isVerified;

    public Certificate(String idTukang, long certificateImg) {
        this.idTukang = idTukang;
        this.certificateImg = certificateImg;
        this.isVerified = false;
    }

    public boolean isVerified() {
        return isVerified;
    }

    public void setVerified() {
        isVerified = !isVerified;
    }

    public String getIdTukang() {
        return idTukang;
    }
}
