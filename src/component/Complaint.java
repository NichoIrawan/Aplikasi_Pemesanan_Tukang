package tubespbo.src.component;

public class Complaint {
    private final String body;
    private final int orderId;

    public Complaint(String body, int orderId) {
        this.body = body;
        this.orderId = orderId;
    }

    public String getBody() {
        return body;
    }

    public int getOrderId() {
        return orderId;
    }

    @Override
    public String toString() {
        return String.format("%s - %d", body, orderId);
    }
}
