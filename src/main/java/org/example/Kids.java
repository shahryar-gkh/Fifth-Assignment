package org.example;

public class Kids extends Product {
    private String category;
    private String color;

    //Setters

    public void setCategory(String category) {
        this.category = category;
    }
    public void setColor(String color) {
        this.color = color;
    }

    //Getters

    public String getCategory() {
        return category;
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
