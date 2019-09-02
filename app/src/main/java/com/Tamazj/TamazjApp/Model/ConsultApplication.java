package com.Tamazj.TamazjApp.Model;

public class ConsultApplication {

    private String consultType;
    private String consultApplicationPeriod;
    private String consultIcon;

    public ConsultApplication() { }

    public ConsultApplication(String consultType, String consultApplicationPeriod, String consultIcon) {
        this.consultType = consultType;
        this.consultApplicationPeriod = consultApplicationPeriod;
        this.consultIcon = consultIcon;
    }

    public String getConsultType() {
        return consultType;
    }

    public void setConsultType(String consultType) {
        this.consultType = consultType;
    }

    public String getConsultApplicationPeriod() {
        return consultApplicationPeriod;
    }

    public void setConsultApplicationPeriod(String consultApplicationPeriod) {
        this.consultApplicationPeriod = consultApplicationPeriod;
    }

    public String getConsultIcon() {
        return consultIcon;
    }

    public void setConsultIcon(String consultIcon) {
        this.consultIcon = consultIcon;
    }
}
