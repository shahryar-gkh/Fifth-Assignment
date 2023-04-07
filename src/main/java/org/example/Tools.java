package org.example;

public class Tools extends Product {
    private String category;
    private String color;
    private String material;

    //Setters

    public void setCategory(String category) {
        this.category = category;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public void setMaterial(String material) {
        this.material = material;
    }

    //Getters

    public String getCategory() {
        return category;
    }
    public String getColor() {
        return color;
    }
    public String getMaterial() {
        return material;
    }

    @Override
    public String toString() {
        return '\n' + category +
                super.toString() +
                "\nColor: " + color +
                "\nMaterial: " + material;
    }
}
