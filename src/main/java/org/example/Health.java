package org.example;

public class Health extends Product {
    private String category;
    private String brand;
    private boolean natural;

    //Setters

    public void setCategory(String category) {
        this.category = category;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }
    public void setNatural(boolean natural) {
        this.natural = natural;
    }

    //Getters

    public String getCategory() {
        return category;
    }
    public String getBrand() {
        return brand;
    }
    public boolean isNatural() {
        return natural;
    }

    @Override
    public String toString() {
        if (natural) {
            return '\n' + category +
                    super.toString() +
                    "\nBrand: " + brand +
                    "\nNatural";
        }
        else {
            return '\n' + category +
                    super.toString() +
                    "\nBrand: " + brand +
                    "\nChemical";
        }
    }
}
