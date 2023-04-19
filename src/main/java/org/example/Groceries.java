package org.example;

public class Groceries extends Product {
    public Groceries(String name, String category, int netWeight, float price, int quantity) {
        this.name = name;
        this.category = category;
        this.netWeight = netWeight;
        this.price = price;
        this.quantity = quantity;
    }
    private String category;
    private int netWeight;

    //Setters

    public void setCategory(String category) {
        this.category = category;
    }
    public void setNetWeight(int netWeight) {
        this.netWeight = netWeight;
    }

    //Getters

    public String getCategory() {
        return category;
    }
    public int getNetWeight() {
        return netWeight;
    }

    @Override
    public String toString() {
        return '\n' + category +
                super.toString() +
                "\nNet weight: " + netWeight;
    }
}
