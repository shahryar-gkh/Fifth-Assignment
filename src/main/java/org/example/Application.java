package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Application {
    private Account currentAccount = new Account();
    private ArrayList<Account> accounts = new ArrayList<>();
    private ArrayList<Product> products = new ArrayList<>();
    private ArrayList<ArrayList<Product>> orders = new ArrayList<>();
    private ArrayList<SellerRequest> sellerRequests = new ArrayList<>();

    public Account getCurrentAccount() {
        return currentAccount;
    }

    public void addToRequests(SellerRequest request) {
        sellerRequests.add(request);
    }

    public boolean viewSellerRequest() {
        if (sellerRequests.size() == 0) {
            return false;
        }
        else {
            SellerRequest newRequest = sellerRequests.get(0);
            System.out.println('\n' + newRequest.getSellerUsername());
            for (Product product : newRequest.getSellerProducts()) {
                System.out.println("\nProduct name: " + product.getName() + "\nQuantity: " + product.getQuantity() + "\nPrice: " + product.getPrice());
            }
            Seller potentialSeller = new Seller();
            for (Account account : accounts) {
                if (account.getUsername().equals(newRequest.getSellerUsername()) && account.getPassword().equals(newRequest.getSellerPassword())) {
                    potentialSeller = (Seller) account;
                }
            }
            System.out.println("\nDo you authorize this seller to work with \"RETAIL THERAPY\"?\n1. Yes\n2. No");
            Scanner input = new Scanner(System.in);
            String authorization = input.nextLine();
            if (authorization.equals("1")) {
                potentialSeller.setRequestResult(1);
                sellerRequests.remove(0);
            }
            else if (authorization.equals("2")) {
                potentialSeller.setRequestResult(2);
                sellerRequests.remove(0);
                accounts.remove(potentialSeller);
            }
            return true;
        }
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

    public Seller findSeller(String username, String password) {
        Seller seller = new Seller();
        for (Account account : accounts) {
            if (account.getUsername().equals(username) && account.getPassword().equals(password)) {
                seller = (Seller) account;
                break;
            }
        }
        return seller;
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
                break;
            }
        }
    }

    public void changeEmail(String username, String newEmail) {
        for (Account account : accounts) {
            if (account.getUsername().equals(username)) {
                User user = (User) account;
                user.setEmail(newEmail);
                currentAccount = user;
                break;
            }
        }
    }

    public void changeNumber(String username, String newNumber) {
        for (Account account : accounts) {
            if (account.getUsername().equals(username)) {
                User user = (User) account;
                user.setPhoneNumber(newNumber);
                currentAccount = account;
                break;
            }
        }
    }

    public void changeAddress(String username, String newAddress) {
        for (Account account : accounts) {
            if (account.getUsername().equals(username)) {
                User user = (User) account;
                user.setAddress(newAddress);
                currentAccount = account;
                break;
            }
        }
    }

    public void logout() {
        currentAccount = null;
    }

    public ArrayList<Product> searchInAllProducts(String name) {
        ArrayList<Product> searchResult = new ArrayList<>();
        for (Product product : products) {
            if (product.getName().toLowerCase().contains(name.toLowerCase())) {
                searchResult.add(product);
            }
        }
        return searchResult;
    }

    public void addProduct(Product product, String username) {
        products.add(product);
        for (Account account : accounts) {
            if (account.getUsername().equals(username)) {
                Seller seller = (Seller) account;
                seller.addToAvailableProducts(product);
                break;
            }
        }
    }
}
