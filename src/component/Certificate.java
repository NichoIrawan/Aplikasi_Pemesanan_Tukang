package tubespbo.src.component;

public class Certificate {
    public final String certificateImg;
    private final int idTukang;
    private boolean isVerified;

    public Certificate(int idTukang, String certificateImg) {
        this.idTukang = idTukang;
        this.certificateImg = certificateImg;
        this.isVerified = true;
    }

    public boolean isVerified() {
        return isVerified;
    }

    public void setVerified() {
        isVerified = !isVerified;
    }

    public int getIdTukang() {
        return idTukang;
    }

    public String toString() {
        return idTukang + "\t" + certificateImg + "\t";
    }
}
