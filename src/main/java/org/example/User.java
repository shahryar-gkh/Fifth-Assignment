package org.example;

import java.util.ArrayList;
import java.util.HashMap;

public class User {
    private String username;
    private String password;
    private String email;
    private String phoneNumber;
    private String address;
    private float wallet;
    private ArrayList<Product> shoppingCart;
    private ArrayList<Product> purchasedProducts;
    private ArrayList<ArrayList<Product>> allOrders;
    private HashMap<String, String> comment;

    //Setters

    public void setUsername(String username) {
        this.username = username;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public void setWallet(float wallet) {
        this.wallet = wallet;
    }

    //Getters


    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }
    public String getEmail() {
        return email;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public String getAddress() {
        return address;
    }
    public float getWallet() {
        return wallet;
    }

    @Override
    public String toString() {
        return  "\nUsername = " + username +
                "\nPassword = " + password +
                "\nEmail = " + email +
                "\nPhone number = " + phoneNumber +
                "\nAddress = " + address +
                "\nWallet = " + wallet +
                "\nShopping cart = " + shoppingCart +
                "\nPurchased products = " + purchasedProducts +
                "\nAll orders = " + allOrders;
    }

    //Other methods

    public void addToShoppingCart(Product product) {
        shoppingCart.add(product);
    }
    public void submitOrder() {
        allOrders.add(shoppingCart);
    }
    public void purchase() {
        purchasedProducts.addAll(shoppingCart);
    }

}