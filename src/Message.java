
import java.util.Date;

public class Message {
    private final String msgId;
    private final String roomId;
    private String msgBody;
    private final Date msgDate;
    private final People sender;

    public Message(String msgBody, Date msgDate, String msgId, String roomId, People sender) {
        this.msgBody = msgBody;
        this.msgDate = msgDate;
        this.msgId = msgId;
        this.roomId = roomId;
        this.sender = sender;
    }

    //Getter msgID & msgBody
    public String getMsgId() {
        return msgId;
    }

    public String getRoomId() {
        return roomId;
    }

    public String getMsgBody() {
        return msgBody;
    }

    //Setter buat edit message
    public void setMsgBody(String msgBody) {
        this.msgBody = msgBody;
    }

    public Date getMsgDate() {
        return msgDate;
    }

    public People getSender() {
        return sender;
    }
}
