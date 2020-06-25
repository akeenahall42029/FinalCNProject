package com.example.krazycoaches;

public class AboutInfo {
    int coach_img;
    String coach_name;
    String coach_asso;
    String coach_college;
    String coach_hobby;
    String coach_fav_food;
    String coach_quality;

    public AboutInfo(int coach_img, String coach_name, String coach_asso, String coach_college, String coach_hobby, String coach_fav_food, String coach_quality) {
        this.coach_img = coach_img;
        this.coach_name = coach_name;
        this.coach_asso = coach_asso;
        this.coach_college = coach_college;
        this.coach_hobby = coach_hobby;
        this.coach_fav_food = coach_fav_food;
        this.coach_quality = coach_quality;
    }

    public int getCoach_img() {
        return coach_img;
    }

    public void setCoach_img(int coach_img) {
        this.coach_img = coach_img;
    }

    public String getCoach_name() {
        return coach_name;
    }

    public void setCoach_name(String coach_name) {
        this.coach_name = coach_name;
    }

    public String getCoach_asso() {
        return coach_asso;
    }

    public void setCoach_asso(String coach_asso) {
        this.coach_asso = coach_asso;
    }

    public String getCoach_college() {
        return coach_college;
    }

    public void setCoach_college(String coach_college) {
        this.coach_college = coach_college;
    }

    public String getCoach_hobby() {
        return coach_hobby;
    }

    public void setCoach_hobby(String coach_hobby) {
        this.coach_hobby = coach_hobby;
    }

    public String getCoach_fav_food() {
        return coach_fav_food;
    }

    public void setCoach_fav_food(String coach_fav_food) {
        this.coach_fav_food = coach_fav_food;
    }

    public String getCoach_quality() {
        return coach_quality;
    }

    public void setCoach_quality(String coach_quality) {
        this.coach_quality = coach_quality;
    }
}
