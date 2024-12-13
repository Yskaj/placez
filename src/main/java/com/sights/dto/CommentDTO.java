package com.sights.dto;

public class CommentDTO {
    private String comment;
    private float rating;
    private long place_id;

    public CommentDTO(long place_id,String comment, float rating) {
        this.place_id = place_id;
        this.comment = comment;
        this.rating = rating;
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

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }
}
