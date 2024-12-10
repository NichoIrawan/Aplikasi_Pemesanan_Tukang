package tubespbo.src;

import java.util.ArrayList;

public class ChatRoom {
    private final String RoomId;
    private final Person user1;
    private final Person user2;
    private ArrayList<Message> messages;

    public ChatRoom(String RoomId, Person user1, Person user2) {
        this.RoomId = RoomId;
        this.user1 = user1;
        this.user2 = user2;
    }

    public Person getUser2() {
        return user2;
    }

    public Person getUser1() {
        return user1;
    }

    public String getRoomId() {
        return RoomId;
    }

    public void showMessages(){

    }
}
