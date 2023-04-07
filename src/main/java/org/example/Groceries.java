package org.example;

public class Groceries extends Product {
    private String category;
    private String netWeight;

    //Setters

    public void setCategory(String category) {
        this.category = category;
    }
    public void setNetWeight(String netWeight) {
        this.netWeight = netWeight;
    }

    //Getters

    public String getCategory() {
        return category;
    }
    public String getNetWeight() {
        return netWeight;
    }

    @Override
    public String toString() {
        return '\n' + category +
                super.toString() +
                "\nNet weight: " + netWeight;
    }
}
