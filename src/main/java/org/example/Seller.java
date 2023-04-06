package org.example;

import java.util.ArrayList;

public class Seller extends Account {
    public Seller() {
    }
    public Seller(String username, String password) {
        super(username, password);
    }

    private ArrayList<Product> availableProducts;
}
