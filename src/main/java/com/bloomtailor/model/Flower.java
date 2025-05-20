package com.bloomtailor.model;

import jakarta.persistence.*;

@Entity
public class Flower {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String imageName;
    private String color;
    private double pricePerStem;

    public Flower() {
    }

    public Flower(Long id, String name, String imageName, String color, double pricePerStem) {
        this.id = id;
        this.name = name;
        this.imageName = imageName;
        this.color = color;
        this.pricePerStem = pricePerStem;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getPricePerStem() {
        return pricePerStem;
    }

    public void setPricePerStem(double pricePerStem) {
        this.pricePerStem = pricePerStem;
    }
}
