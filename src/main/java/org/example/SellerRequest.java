package org.example;

import java.util.ArrayList;

public class SellerRequest {
    public SellerRequest (String sellerUsername, String sellerPassword, ArrayList sellerProducts) {
        this.sellerUsername = sellerUsername;
        this.sellerPassword = sellerPassword;
        this.sellerProducts = sellerProducts;
    }
    private String sellerUsername;
    private String sellerPassword;
    private ArrayList<Product> sellerProducts = new ArrayList<>();
}
