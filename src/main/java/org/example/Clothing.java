package org.example;

public class Clothing extends Product {

    public Clothing(String name, String category, String brand, String size, String color, String gender, float price, int quantity) {
        this.name = name;
        this.category = category;
        this.brand = brand;
        this.size = size;
        this.color = color;
        this.gender = gender;
        this.price = price;
        this.quantity = quantity;
    }

    private String category;
    private String brand;
    private String size;
    private String color;
    private String gender;

    //Setters

    public void setCategory(String category) {
        this.category = category;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }
    public void setSize(String size) {
        this.size = size;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }

    //Getters

    public String getCategory() {
        return category;
    }
    public String getBrand() {
        return brand;
    }
    public String getSize() {
        return size;
    }
    public String getColor() {
        return color;
    }
    public String getGender() {
        return gender;
    }

    @Override
    public String toString() {
        return '\n' + category +
                super.toString() +
                "\nBrand: " + brand +
                "\nSize: " + size +
                "\nColor: " + color +
                "\nGender: " + gender;
    }
}
