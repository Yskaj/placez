package com.sights.dto;

public class PlaceDTO { //передача данных в запрос
    private String name;
    private String category;
    private float geo_latitude;
    private float geo_longitude;

    public PlaceDTO(String name, String category, float geo_latitude, float geo_longitude) {
        this.name = name;
        this.category = category;
        this.geo_latitude = geo_latitude;
        this.geo_longitude = geo_longitude;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
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
}
