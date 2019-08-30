package com.Tamazj.TamazjApp.Model;

public class Distinguished_Advisors_Model {
    private String area_counseling_image;
    private  String area_counseling_name;
    private  String area_counseling_catogory;

    public Distinguished_Advisors_Model(String area_counseling_image, String area_counseling_name, String area_counseling_catogory) {
        this.area_counseling_image = area_counseling_image;
        this.area_counseling_name = area_counseling_name;
        this.area_counseling_catogory = area_counseling_catogory;
    }


    public String getArea_counseling_image() {
        return area_counseling_image;
    }

    public void setArea_counseling_image(String area_counseling_image) {
        this.area_counseling_image = area_counseling_image;
    }

    public String getArea_counseling_name() {
        return area_counseling_name;
    }

    public void setArea_counseling_name(String area_counseling_name) {
        this.area_counseling_name = area_counseling_name;
    }

    public String getArea_counseling_catogory() {
        return area_counseling_catogory;
    }

    public void setArea_counseling_catogory(String area_counseling_catogory) {
        this.area_counseling_catogory = area_counseling_catogory;
    }
}
