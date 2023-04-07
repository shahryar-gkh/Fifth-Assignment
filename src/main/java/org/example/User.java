package org.example;

import java.util.ArrayList;
import java.util.HashMap;

public class User extends Account {
    Account userAccount = new Account();
    private String email;
    private String phoneNumber;
    private String address;
    private float wallet;
    private ArrayList<Product> shoppingCart = new ArrayList<>();
    private ArrayList<Product> purchasedProducts = new ArrayList<>();
    private ArrayList<ArrayList<Product>> allOrders = new ArrayList<>();
    private HashMap<String, String> comment = new HashMap<>();

    public User(Account userAccount) {
        this.userAccount = userAccount;
    }

    public User(String username, String password, String email, String phoneNumber, String address, float wallet) {
        super(username, password);
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.wallet = wallet;
    }

    //Setters

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
    public ArrayList<Product> getShoppingCart() {
        return shoppingCart;
    }
    public ArrayList<Product> getPurchasedProducts() {
        return purchasedProducts;
    }
    public ArrayList<ArrayList<Product>> getAllOrders() {
        return allOrders;
    }

    @Override
    public String toString() {
        return  "\nUsername = " + userAccount.username +
                "\nPassword = " + userAccount.password +
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