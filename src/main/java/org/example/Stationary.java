package org.example;

public class Stationary extends Product {
    private String category;
    private String brand;
    private String color;

    //Setters

    public void setCategory(String category) {
        this.category = category;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }
    public void setColor(String color) {
        this.color = color;
    }

    //Getters

    public String getCategory() {
        return category;
    }
    public String getBrand() {
        return brand;
    }
    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return '\n' + category +
                super.toString() +
                "\nBrand: " + brand +
                "\nColor: " + color;
    }
}
