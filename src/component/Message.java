package tubespbo.src.component;

import java.util.Date;

public class Message {
     private final String msgId;
     private final String RoomId;
     private final String msgSender;
     private String msgBody;
     private final Date msgDate;

     Message(String msgId, String RoomId, String msgSender, String msgBody, Date msgDate){
        this.msgId = msgId;
        this.RoomId = RoomId;
        this.msgSender = msgSender;
        this.msgBody = msgBody;
        this.msgDate = msgDate;
     }

    public String getRoomId() {
        return RoomId;
    }

    public String getMsgSender() {
        return msgSender;
    }

    public String getMsgId() {
        return msgId;
    }

    public Date getMsgDate() {
        return msgDate;
    }

    public String getMsgBody() {
        return msgBody;
    }

    public void setMsgBody(String msgBody) {
        this.msgBody = msgBody;
    }
}
