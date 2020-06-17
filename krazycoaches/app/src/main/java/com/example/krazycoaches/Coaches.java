package com.example.krazycoaches;

public class Coaches {
    int image;
    int hunger;
    int hobby;
    String[] Quotes;

    public Coaches(int image, int health, int hobby, String[] quotes, String name) {
        this.image = image;
        this.hunger = hunger;
        this.hobby = hobby;
        Quotes = quotes;
        this.name = name;
    }

    String name;

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public int getHunger() {
        return hunger;
    }

    public void setHealth(int hunger) {
        this.hunger = hunger;
    }

    public int getHobby() {
        return hobby;
    }

    public void setHobby(int hobby) {
        this.hobby = hobby;
    }

    public String[] getQuotes() {
        return Quotes;
    }

    public void setQuotes(String[] Quotes) {
        this.Quotes =Quotes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}