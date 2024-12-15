package tubespbo.src.component;

public class Complaint {
    private final String body;
    private final String orderId;

    public Complaint(String body, String orderId) {
        this.body = body;
        this.orderId = orderId;
    }

    public String getBody() {
        return body;
    }

    public String getOrderId() {
        return orderId;
    }
}
