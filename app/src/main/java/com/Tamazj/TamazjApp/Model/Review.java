package com.Tamazj.TamazjApp.Model;

public class Review {

    private String imgUrl;
    private String time;
    private String name;
    private String rate;
    private String reviewBody;


    public Review(String imgUrl, String time, String name, String rate, String reviewBody) {
        this.imgUrl = imgUrl;
        this.time = time;
        this.name = name;
        this.rate = rate;
        this.reviewBody = reviewBody;
    }
    public Review(String rate){
        this.rate = rate;
    }


    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getReviewBody() {
        return reviewBody;
    }

    public void setReviewBody(String reviewBody) {
        this.reviewBody = reviewBody;
    }
}
