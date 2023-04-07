package org.example;

public class Beauty extends Product {
    private String category;
    private String brand;
    private int spf;

    //Setters

    public void setCategory(String category) {
        this.category = category;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }
    public void setSpf(int spf) {
        this.spf = spf;
    }

    //Getters

    public String getCategory() {
        return category;
    }
    public String getBrand() {
        return brand;
    }
    public int getSpf() {
        return spf;
    }

    @Override
    public String toString() {
        if (spf != 0) {
            return '\n' + category +
                    super.toString() +
                    "\nBrand: " + brand +
                    "\nSPF: " + spf;
        }
        else {
            return '\n' + category +
                    super.toString() +
                    "\nBrand: " + brand;
        }
    }
}
