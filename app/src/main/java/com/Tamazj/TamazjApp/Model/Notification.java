package com.Tamazj.TamazjApp.Model;

public class Notification {

    private String notificationText;
    private String time;
    private boolean isNew;

    public Notification(String notificationText, String time, boolean isNew) {
        this.notificationText = notificationText;
        this.time = time;
        this.isNew = isNew;
    }

    public String getNotificationText() {
        return notificationText;
    }

    public void setNotificationText(String notificationText) {
        this.notificationText = notificationText;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public boolean isNew() {
        return isNew;
    }

    public void setNew(boolean aNew) {
        isNew = aNew;
    }
}
