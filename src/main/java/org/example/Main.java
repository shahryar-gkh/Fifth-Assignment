package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Application application = new Application();
    static boolean loginAllowed = false;
    static String accountType = "";
    static User me = new User("Shahryar", "123456", "shahryar.gkh@gmail.com", "09176561983", "Tehran, Velenjak, Daneshjoo boulevard, Shahid Beheshti boys dormitory", 0);
    static Admin manager = new Admin("manager", "P@$$word12345", "ceo.retailtherapy@gmail.com");

    public static void main(String[] args) {
        application.createAccount(me);
        application.createAccount(manager);
        runMenu();
    }

    public static void runMenu(){
        Scanner input = new Scanner(System.in);
        String logInOrSignup;
        do {
            System.out.println("\n\nRETAIL THERAPY\n\nBuy whatever you like,\nfrom wherever you like,\nby just a few clicks.\nweb address: retailtherapy.com\nsupport phone number: (+98)9176561983\n\n1. Log In\n2. Sign Up\n(Enter anything else to close the program)");
            logInOrSignup = input.next();
            if (logInOrSignup.equals("1")) {
                login();
            }
            else if (logInOrSignup.equals("2")) {
                signup();
            }
            if (loginAllowed) {
                switch (accountType) {
                    case "1":
                        userMenu();
                    case "2":
                        //sellerMenu();
                    case "3":
                        //adminMenu();
                }
            }
        }
        while (logInOrSignup.equals("1") || logInOrSignup.equals("2"));
    }

    //Logging In
    public static void login(){
        Scanner input = new Scanner(System.in);
        System.out.println("\nWhat are you logging in as?\n1. User\n2. Seller\n3. Admin\n(Enter anything else to go back to the menu)");
        accountType = input.nextLine();
        switch (accountType) {
            case "1": {
                System.out.println("\nUsername:");
                String username = input.nextLine();
                System.out.println("Password:");
                String password = input.nextLine();
                if (application.usernameTaken(username)) {
                    if (application.isPasswordValid(username, password)) {
                        loginAllowed = true;
                        return;
                    }
                    else {
                        System.out.println("Password is incorrect.");
                    }
                }
                else {
                    System.out.println("No account under this username exists.");
                }
                login();
                break;
            }
            case "2": {
                System.out.println("\nUsername:");
                String username = input.nextLine();
                System.out.println("Password:");
                String password = input.nextLine();
                if (application.sellerUsernameTaken(username)) {
                    if (application.isPasswordValid(username, password)) {
                        loginAllowed = true;
                        return;
                    }
                    else {
                        System.out.println("Password is incorrect.");
                    }
                }
                else {
                    System.out.println("No account under this username exists.");
                }
                login();
                break;
            }
            case "3": {
                System.out.println("\nUsername:");
                String username = input.nextLine();
                System.out.println("Password:");
                String password = input.nextLine();
                if (application.adminUsernameTaken(username)) {
                    if (application.isPasswordValid(username, password)) {
                        loginAllowed = true;
                        return;
                    }
                    else {
                        System.out.println("Password is incorrect.");
                    }
                }
                else {
                    System.out.println("No account under this username exists.");
                }
                login();
                break;
            }
        }
    }

    public static void signup(){
        Scanner input = new Scanner(System.in);
        System.out.println("\nWhat type of an account are you signing up for?\n1. User\n2. Seller");
        accountType = input.nextLine();
        System.out.println("\nWhat would you like your username to be?");
        String username = input.nextLine();
        if (application.usernameTaken(username)) {
            do {
                System.out.println("\nThis username is already taken. Please choose another one:");
                username = input.nextLine();
            }
            while (application.usernameTaken(username));
        }
        System.out.println("Choose a safe password:");
        String password = input.nextLine();
        if (accountType.equals("1")) {
            System.out.println("Please enter your email address:");
            String email = input.nextLine();
            System.out.println("Now enter your phone number:");
            String phone = input.nextLine();
            System.out.println("Finally, enter your home/work address and try to be as specific as possible:");
            String address = input.nextLine();
            User newUser = new User(username, password, email, phone, address, 0);
            application.createAccount(newUser);
            loginAllowed = true;
        }
        else if (accountType.equals("2")) {
            ArrayList<Product> productOffers = new ArrayList<>();
            Product newProduct;
            System.out.println("\nAs a seller, you need to have at least one product to offer to the online shop.\nYou will have to enter the attributes of your product(s) and wait for\nthe administrators to confirm that you're qualified as a seller.\nRemember that this is only for giving the admin an idea of what you're offering\nand you are not actually adding these products;\nthat will be done thoroughly once your account is authorized.");
            while (true) {
                System.out.println("\nEnter the name of your product:");
                String name  = input.nextLine();
                System.out.println("Enter the number of these products that you have available:");
                int quantity = Integer.parseInt(input.nextLine());
                System.out.println("Enter the price of your product:");
                float price = Float.parseFloat(input.nextLine());
                newProduct = new Product(name, quantity, price);
                productOffers.add(newProduct);
                System.out.println("\nProduct was added. Enter 1 if you'd like to add more:");
                String adding = input.nextLine();
                if (!adding.equals("1")) {
                    break;
                }
            }
            SellerRequest sellerRequest = new SellerRequest(username, password, productOffers);
            application.addToRequests(sellerRequest);
            System.out.println("\nYour request was sent and will be authorized soon. Thank you for your patience.");
        }
    }

    public static void userMenu() {
        Scanner input = new Scanner(System.in);
        String choice;
        do {
            System.out.println("\n\"RETAIL THERAPY\"\n\n1. Search for products\n2. View categories\n3. View profile\nEnter anything else to log out");
            choice = input.nextLine();
            switch (choice) {
                case "1":
                    search();
                    break;
                case "2":
                    //categories();
                    break;
                case "3":
                    viewProfile();
                    break;
            }
        }
        while (choice.equals("1") || choice.equals("2") || choice.equals("3"));
        application.logout();
    }

    public static void search() {
        Scanner input = new Scanner(System.in);
        User currentUser = (User) application.getCurrentAccount();
        System.out.println("\nEnter the name of the product you're looking for\nEnter 0 if you want to return to the menu:");
        String name;
        while (true) {
            name = input.nextLine();
            if (name.equalsIgnoreCase("0")) {
                return;
            } else if (application.searchInAllProducts(name).size() == 0) {
                System.out.println("\nThis product doesn't exist. Make sure you're typing in at least a part of the product's name.\nEnter 0 if you want to return to the menu:");
            } else {
                break;
            }
        }
        application.printListOfProductsInArraylist(application.searchInAllProducts(name));
        if (application.searchInAllProducts(name).size() > 1) {
            do {
                System.out.println("\nPlease be more specific with the product's name. Enter the full name (Or enter 0 if you want to go back to the menu):");
                name = input.nextLine();
                if (name.equalsIgnoreCase("e")) {
                    return;
                }
            }
            while (application.searchInAllProducts(name).size() > 1 || !application.doesProductExistWithExactName(name));
            application.printListOfProductsInArraylist(application.searchInAllProducts(name));
        }
        System.out.println("\nWould you like to add this item to your shopping cart?\n1. Yes\n2. No");
        int addOrNot = Integer.parseInt(input.nextLine());
        if (addOrNot == 1) {
            Product currentProduct = application.searchInAllProducts(name).get(0);
            currentUser.addToShoppingCart(currentProduct);
        }
    }

    public static void viewProfile() {
        User currentUser = (User) application.getCurrentAccount();
        System.out.println("\nUsername: " + currentUser.getUsername());
        System.out.print("Password: ");
        for (int i = 0; i < currentUser.getPassword().length(); i++) {
            System.out.print("*");
        }
        System.out.println("\nEmail: " + currentUser.getEmail() + "\nPhone number: " + currentUser.getPhoneNumber() + "\nAddress: " + currentUser.getAddress());
        System.out.println("\n1. Go back to the menu\n2. Edit Profile\n3. View shopping cart\n4. View all purchased items\n5. View all orders");
        Scanner input = new Scanner(System.in);
        String choice = input.nextLine();
        switch (choice) {
            case "2": {
                System.out.println("\nWhat would you like to change?\n1. Password\n2. Email\n3. Phone number\n4. Address");
                String change = input.nextLine();
                switch (change) {
                    case "1": {
                        System.out.println("Please verify your password:");
                        String passwordVerify = input.nextLine();
                        while (!passwordVerify.equals(currentUser.getPassword())) {
                            System.out.println("This password doesn't belong to your account. Try again (or enter 0 to return):");
                            passwordVerify = input.nextLine();
                            if (passwordVerify.equals("0")) {
                                return;
                            }
                        }
                        System.out.println("What would you like your new password to be?");
                        String newPassword = input.nextLine();
                        application.changePassword(currentUser.getUsername(), newPassword);
                        System.out.println("Your password has been changed successfully.");
                        break;
                    }
                    case "2": {
                        System.out.println('\n' + currentUser.getEmail() + "\nThis is your current email. What would you like to change it into? (Enter 0 if you've changed your mind)");
                        String newEmail = input.nextLine();
                        if (!newEmail.equals("0")) {
                            application.changeEmail(currentUser.getUsername(), newEmail);
                            System.out.println("Your email was changed to \"" + currentUser.getEmail() + '"');
                        }
                        break;
                    }
                    case "3": {
                        System.out.println('\n' + currentUser.getPhoneNumber() + "\nThis is your current phone number. What would you like to change it into? (Enter 0 if you've changed your mind)");
                        String newNumber = input.nextLine();
                        if (!newNumber.equals("0")) {
                            application.changeNumber(currentUser.getUsername(), newNumber);
                            System.out.println("Your phone number was changed to \"" + currentUser.getPhoneNumber() + '"');
                        }
                        break;
                    }
                    case "4": {
                        System.out.println('\n' + currentUser.getAddress() + "\nThis is your current address. What would you like to change it into? (Enter 0 if you've changed your mind)");
                        String newAddress = input.nextLine();
                        if (!newAddress.equals("0")) {
                            application.changeAddress(currentUser.getUsername(), newAddress);
                            System.out.println("Your address was changed to \"" + currentUser.getAddress() + '"');
                        }
                        break;
                    }
                }
                break;
            }
            case "3": {
                if (currentUser.getShoppingCart().isEmpty()) {
                    System.out.println("\nYour shopping cart is empty.");
                }
                else {
                    System.out.println("\nYour shopping cart:");
                    application.printListOfProductsInArraylist(currentUser.getShoppingCart());
                }
                break;
            }
            case "4": {
                if (currentUser.getPurchasedProducts().isEmpty()) {
                    System.out.println("\nYou haven't purchased anything yet.");
                }
                else {
                    System.out.println("\nThese are all of the items you've purchased so far:");
                    application.printListOfProductsInArraylist(currentUser.getPurchasedProducts());
                }
                break;
            }
            case "5": {
                if (currentUser.getAllOrders().isEmpty()) {
                    System.out.println("You haven't submitted any orders yet.");
                }
                else {
                    System.out.println("\nThese are all of your orders:");
                    int i = 1;
                    for (ArrayList<Product> orders : currentUser.getAllOrders()) {
                        System.out.println("\nOrder number " + i);
                        application.printListOfProductsInArraylist(orders);
                        i++;
                    }
                }
                break;
            }
        }
    }
}