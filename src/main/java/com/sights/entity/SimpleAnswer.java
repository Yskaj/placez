package com.sights.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class SimpleAnswer {

    @Id
    private Long id;
    private String name;
    private float avg_rating;

    public SimpleAnswer(Long id, String name, float avg_raiting) {
        this.id = id;
        this.name = name;
        this.avg_rating = avg_raiting;
    }

    public SimpleAnswer() {

    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getAvg_rating() {
        return avg_rating;
    }

    public void setAvg_rating(float avg_rating) {
        this.avg_rating = avg_rating;
    }
}
