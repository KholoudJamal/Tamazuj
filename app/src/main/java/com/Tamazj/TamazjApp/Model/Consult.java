package com.Tamazj.TamazjApp.Model;

public class Consult {

    private String Name;
    private String type;
    private String time;
    private String img;
    private boolean isScheduled;

    public Consult(String name, String type, String time, String img, boolean isScheduled) {
        Name = name;
        this.type = type;
        this.time = time;
        this.img = img;
        this.isScheduled = isScheduled;
    }

    public Consult(boolean isScheduled) {
        this.isScheduled = isScheduled;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public boolean isScheduled() {
        return isScheduled;
    }

    public void setScheduled(boolean scheduled) {
        isScheduled = scheduled;
    }
}
