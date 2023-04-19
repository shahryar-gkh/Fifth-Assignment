package org.example;

import java.util.ArrayList;

public class SellerRequest {
    public SellerRequest (String sellerUsername, String sellerPassword, ArrayList<Product> sellerProducts) {
        this.sellerUsername = sellerUsername;
        this.sellerPassword = sellerPassword;
        this.sellerProducts = sellerProducts;
    }

    private String sellerUsername;
    private String sellerPassword;
    private ArrayList<Product> sellerProducts = new ArrayList<>();

    //Setters

    public void setSellerUsername(String sellerUsername) {
        this.sellerUsername = sellerUsername;
    }
    public void setSellerPassword(String sellerPassword) {
        this.sellerPassword = sellerPassword;
    }
    public void setSellerProducts(ArrayList<Product> sellerProducts) {
        this.sellerProducts = sellerProducts;
    }

    //Getters

    public String getSellerUsername() {
        return sellerUsername;
    }
    public String getSellerPassword() {
        return sellerPassword;
    }
    public ArrayList<Product> getSellerProducts() {
        return sellerProducts;
    }

    @Override
    public String toString() {
        return "\nSeller username: " + sellerUsername +
                "\nSeller products: " + sellerProducts;
    }
}
