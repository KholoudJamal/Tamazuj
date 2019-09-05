package com.Tamazj.TamazjApp.Model;

public class Message {

    private  String messageBody;
    private  String time;
    private boolean isSeen;
    private boolean isReceive;

    public Message(boolean isReceive){
        this.isReceive = isReceive;
    }

    public Message(boolean isReceive, boolean isSeen){
        this.isReceive = isReceive;
        this.isSeen = isSeen;
    }

    public Message(String messageBody, String time, boolean isSeen, boolean isReceive) {
        this.messageBody = messageBody;
        this.time = time;
        this.isSeen = isSeen;
        this.isReceive = isReceive;
    }

    public String getMessageBody() {
        return messageBody;
    }

    public void setMessageBody(String messageBody) {
        this.messageBody = messageBody;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public boolean isSeen() {
        return isSeen;
    }

    public void setSeen(boolean seen) {
        isSeen = seen;
    }

    public boolean isReceive() {
        return isReceive;
    }

    public void setReceive(boolean receive) {
        isReceive = receive;
    }
}
