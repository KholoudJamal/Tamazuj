package com.Tamazj.TamazjApp.Model;

public class ReceiveMessage {

    private  String messageBody;
    private  String time;

    public ReceiveMessage(String messageBody, String time) {
        this.messageBody = messageBody;
        this.time = time;
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

}
