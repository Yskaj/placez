package com.sights.dto;

public class SimpleNameDTO {
    private String name;
    private double avg_raiting;

    public SimpleNameDTO(String name, double avg_raiting) {
        this.name = name;
        this.avg_raiting = avg_raiting;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAvg_raiting() {
        return avg_raiting;
    }

    public void setAvg_raiting(double avg_raiting) {
        this.avg_raiting = avg_raiting;
    }
}
