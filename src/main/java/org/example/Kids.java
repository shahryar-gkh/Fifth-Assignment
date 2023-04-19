package org.example;

public class Kids extends Product {
    public Kids(String name, String category, String brand,String color, float price, int quantity) {
        this.name = name;
        this.category = category;
        this.brand = brand;
        this.color = color;
        this.price = price;
        this.quantity = quantity;
    }

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
                "\nColor: " + color;
    }
}
