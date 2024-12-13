package com.sights.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "comments")
public class Comment {
    @Id
    private Long id;
    private long place_id;
    private String comment;
    private double rating;

    public Comment() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public Comment(Long place_id, String comment, float rating) {
        this.place_id = place_id;
        this.comment = comment;
        this.rating = rating;
    }

    public Comment(String comment) {
        this.comment = comment;
    }

    public long getPlace_id() {
        return place_id;
    }

    public void setPlace_id(long place_id) {
        this.place_id = place_id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }
}
