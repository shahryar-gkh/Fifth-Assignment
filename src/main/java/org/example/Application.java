package org.example;

import java.util.ArrayList;

public class Application {
    private User currentUser = new User();
    private ArrayList<User> users = new ArrayList<>();
    private ArrayList<Product> products = new ArrayList<>();

    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(String username, String password) {
        currentUser.setUsername(username);
        currentUser.setPassword(password);
    }

    public void printListOfProductsInArraylist(ArrayList<Product> listOfProducts) {
        for (Product product : listOfProducts) {
            System.out.println(product);
        }
    }

    public boolean doesProductExistWithExactName(String productName) {
        for (Product product : products) {
            if (product.getName().equalsIgnoreCase(productName)) {
                return true;
            }
        }
        return false;
    }

    public void createAccount(String username, String password) {
        User newUser = new User();
        newUser.setUsername(username);
        newUser.setPassword(password);
        users.add(newUser);
    }

    public boolean usernameTaken(String username){
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }

    public boolean login(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                currentUser = user;
                currentUser.setUsername(username);
                currentUser.setPassword(password);
                return true;
            }
        }
        return false;
    }

    public void changePassword(String username, String newPassword) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                user.setPassword(newPassword);
                currentUser = user;
            }
        }
    }

    public void logout() {
        currentUser = null;
    }

    public void deleteAccount(String username) {
        for (User user : users) {
            if (username.equals(user.getUsername())) {
                users.remove(user);
            }
        }
    }

    public ArrayList<Product> searchByTitle(String name) {
        ArrayList<Product> searchResult = new ArrayList<>();
        for (Product product : products) {
            if (product.getName().toLowerCase().contains(name.toLowerCase())) {
                searchResult.add(product);
            }
        }
        return searchResult;
    }
}
