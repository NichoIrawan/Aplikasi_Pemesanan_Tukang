
import java.util.ArrayList;

public class ChatRoom {
    private final String roomId;
    private final People user1;
    private final People user2;
    private ArrayList<Message> messages;

    public ChatRoom(String roomId, People user1, People user2) {
        this.roomId = roomId;
        this.user1 = user1;
        this.user2 = user2;
    }

    public String getRoomId() {
        return roomId;
    }

    public People getUser1() {
        return user1;
    }

    public People getUser2() {
        return user2;
    }

    public void showMessage() {
        for (Message message : messages) {
            System.out.println(message); 
        }
    } 
}
