package org.example;

import java.util.ArrayList;

public class Application {
    private Account currentAccount = new Account();
    private ArrayList<Account> accounts = new ArrayList<>();
    private ArrayList<Product> products = new ArrayList<>();
    private ArrayList<ArrayList<Product>> orders = new ArrayList();
    private ArrayList<SellerRequest> sellerRequests = new ArrayList<>();

    public Account getCurrentAccount() {
        return currentAccount;
    }


    public void addToRequests(SellerRequest request) {
        sellerRequests.add(request);
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

    public void createAccount(Account newAccount) {
        accounts.add(newAccount);
        currentAccount = newAccount;
    }

    public boolean usernameTaken(String username){
        for (Account account : accounts) {
            if (account.getClass().equals(User.class) && account.getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }
    public boolean adminUsernameTaken(String username){
        for (Account account : accounts) {
            if (account.getClass().equals(Admin.class) && account.getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }
    public boolean sellerUsernameTaken(String username) {
        for (Account account : accounts) {
            if (account.getClass().equals(Seller.class) && account.getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }

    public boolean isPasswordValid(String username, String password) {
        for (Account account : accounts) {
            if (account.getUsername().equals(username) && account.getPassword().equals(password)) {
                currentAccount = account;
                return true;
            }
        }
        return false;
    }

    public void changePassword(String username, String newPassword) {
        for (Account account : accounts) {
            if (account.getUsername().equals(username)) {
                account.setPassword(newPassword);
                currentAccount = account;
            }
        }
    }

    public void changeEmail(String username, String newEmail) {
        for (Account account : accounts) {
            if (account.getUsername().equals(username)) {
                User user = (User) account;
                user.setEmail(newEmail);
                currentAccount = user;
            }
        }
    }

    public void changeNumber(String username, String newNumber) {
        for (Account account : accounts) {
            if (account.getUsername().equals(username)) {
                User user = (User) account;
                user.setPhoneNumber(newNumber);
                currentAccount = account;
            }
        }
    }

    public void changeAddress(String username, String newAddress) {
        for (Account account : accounts) {
            if (account.getUsername().equals(username)) {
                User user = (User) account;
                user.setAddress(newAddress);
                currentAccount = account;
            }
        }
    }

    public void logout() {
        currentAccount = null;
    }

    public void deleteAccount(String username) {
        for (Account account : accounts) {
            if (username.equals(account.getUsername())) {
                accounts.remove(account);
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
