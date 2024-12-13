package com.sights.entity;

import java.util.List;

public class PlaceInformation {
    String name;
    float rating;
    List<Comment> comments;

    public PlaceInformation(String name, float rating, List<Comment> comments) {
        this.name = name;
        this.rating = rating;
        this.comments = comments;
    }

    public PlaceInformation(String name) {
        this.name = name;
        this.rating = 0;
    }

    @Override
    public String toString() {
        return "name='" + name + '\'' +
                ", rating=" + rating;
    }
}
