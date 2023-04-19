package org.example;

import java.util.ArrayList;
import java.util.HashMap;

public class Product {
    public Product() {

    }
    public Product(String name, int quantity, float price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    protected String name;
    protected int quantity;
    protected float price;
    protected ArrayList<HashMap<String, String>> comments = new ArrayList<>();

    //Setters

    public void setName(String name) {
        this.name = name;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public void setPrice(float price) {
        this.price = price;
    }

    //Getters

    public String getName() {
        return name;
    }
    public int getQuantity() {
        return quantity;
    }
    public float getPrice() {
        return price;
    }

    @Override
    public String toString() {
        if (comments.isEmpty()) {
            return "\nName: " + name +
                    "\nQuantity: " + quantity +
                    "\nPrice: " + price;
        }
        else {
            return "\nName: " + name +
                    "\nQuantity: " + quantity +
                    "\nPrice: " + price +
                    "\nComments: " + comments;
        }
    }
}