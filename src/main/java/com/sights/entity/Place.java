package com.sights.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "sights")
public class Place {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    private String category;
    private float avg_rating;
    private float geo_latitude;
    private float geo_longitude;

    public Place(String name, String category, float avg_rating, float geo_latitude, float geo_longitude) {
        this.name = name;
        this.category = category;
        this.avg_rating = avg_rating;
        this.geo_latitude = geo_latitude;
        this.geo_longitude = geo_longitude;
    }

    public Place() {

    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public float getAvg_rating() {
        return avg_rating;
    }

    public void setAvg_rating(float avg_rating) {
        this.avg_rating = avg_rating;
    }

    public float getGeo_latitude() {
        return geo_latitude;
    }

    public void setGeo_latitude(float geo_latitude) {
        this.geo_latitude = geo_latitude;
    }

    public float getGeo_longitude() {
        return geo_longitude;
    }

    public void setGeo_longitude(float geo_longitude) {
        this.geo_longitude = geo_longitude;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Place{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", avg_rating=" + avg_rating +
                ", geo_latitude=" + geo_latitude +
                ", geo_longitude=" + geo_longitude +
                '}';
    }
}
