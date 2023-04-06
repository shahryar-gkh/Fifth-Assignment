package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Application application = new Application();
    static boolean loginAllowed = false;
    static String accountType = "";

    public static void main(String[] args) {
        Admin manager = new Admin("manager", "P@$$word12345", "ceo.retailtherapy@gmail.com");
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
                if (loginAllowed) {
                    switch (accountType) {
                        case "1":
                            //userMenu();
                        case "2":
                            //sellerMenu();
                        case "3":
                            //adminMenu();
                    }
                }
            }
            else if (logInOrSignup.equals("2")) {
                signup();
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
        String choice = input.nextLine();
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
        if (choice.equals("1")) {
            System.out.println("Please enter your email address:");
            String email = input.nextLine();
            System.out.println("Now enter your phone number:");
            String phone = input.nextLine();
            System.out.println("Finally, enter your home/work address and try to be as specific as possible:");
            String address = input.nextLine();
            User newUser = new User(username, password, email, phone, address, 0);
            application.createAccount(newUser);
        }
        else if (choice.equals("2")) {
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
            System.out.println("\nYour request was sent and will be authorized soon. Thank you for your patience.");
        }
    }

    public static void mainMenu() {
//        Scanner input = new Scanner(System.in);
//        int showOrMovie;
//        do {
//            System.out.println("\nWelcome to your Netflix account.\n1. TV Shows\n2. Movies\n3. View your Netflix profile\n(Enter 0 to log out)");
//            showOrMovie = input.nextInt();
//            if (showOrMovie == 1) {
//                //tvShowsMenu();
//            }
//            else if (showOrMovie == 2) {
//                //moviesMenu();
//            }
//            else if (showOrMovie == 3) {
//                //viewProfile();
//            }
//        }
//        while (showOrMovie != 0 && !deleteAccount);
//        if (deleteAccount) {
//            actions.deleteAccount(actions.getCurrentUser().getUsername());
//        }
//        actions.logout();
    }
}