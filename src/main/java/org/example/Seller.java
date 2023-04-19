package org.example;

import java.util.ArrayList;

public class Seller extends Account {
    public Seller() {
    }

    public Seller(String username, String password, int requestResult) {
        super(username, password);
        this.requestResult = requestResult;
    }

    private int requestResult;

    //0 for pending, 1 for accepted and 2 for rejected

    private ArrayList<Product> availableProducts = new ArrayList<>();

    //Setters
    public void setRequestResult(int requestResult) {
        this.requestResult = requestResult;
    }

    //Getters
    public int getRequestResult() {
        return requestResult;
    }
    public ArrayList<Product> getAvailableProducts() {
        return availableProducts;
    }


    public void addToAvailableProducts(Product product) {
        availableProducts.add(product);
    }
    @Override
    public String toString() {
        return super.toString();
    }
}
