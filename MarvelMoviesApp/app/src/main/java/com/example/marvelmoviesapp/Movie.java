package com.example.movielist;

public class Movie {
    private String name;
    private int imageResourceId;

    public Movie(String name, int imageResourceId) {
        this.name = name;
        this.imageResourceId = imageResourceId;
    }

    public String getName() {
        return name;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }
}
