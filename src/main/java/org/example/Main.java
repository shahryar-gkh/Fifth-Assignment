package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Application application = new Application();
    static boolean loginAllowed = false;
    static String accountType = "";
    static User me = new User("Shahryar", "123456", "shahryar.gkh@gmail.com", "09176561983", "Tehran, Velenjak, Daneshjoo boulevard, Shahid Beheshti boys dormitory", 0);
    static Admin manager = new Admin("manager", "P@$$word12345", "ceo.retailtherapy@gmail.com");
    static Seller samsung = new Seller("Samsung", "G@L@XY__5678", 1);
    static Seller grandCentral = new Seller("GrandCentral", "B00KS4everyone", 1);
    static Seller drCTuna = new Seller("Dr.C.Tuna", "123SkincareMatters", 1);
    public static void main(String[] args) {
        application.createAccount(me);
        application.createAccount(manager);
        application.createAccount(samsung);
        application.createAccount(grandCentral);
        application.createAccount(drCTuna);
        Phone galaxyS23 = new Phone("Galaxy S23", "Smart phone", "Samsung", "Graphite",
                6.1, 168, 256, 8, "Snapdragon 8 gen 2",
                50, 12, 3900, 759, 170);
        application.addProduct(galaxyS23, samsung.getUsername());
        Book mockingbird = new Book("To Kill a Mockingbird", "Grand Central Publishing",
                "Harper Lee", "Novel", 11, 230);
        application.addProduct(mockingbird, grandCentral.getUsername());
        Health drTunaSunscreen = new Health("Dr. C. Tuna sunscreen", "Sunscreen",
                "Dr. C. Tuna", false, 9, 95);
        application.addProduct(drTunaSunscreen, drCTuna.getUsername());
        runMenu();
    }

    public static void runMenu() {
        Scanner input = new Scanner(System.in);
        String logInOrSignup;
        do {
            System.out.println("\n\nRETAIL THERAPY\n\nBuy whatever you like,\nfrom wherever you like,\nby just a few clicks." +
                    "\nweb address: retailtherapy.com\nsupport phone number: (+98)9176561983\n\n1. Log In\n2. Sign Up" +
                    "\n(Enter anything else to close the program)");
            logInOrSignup = input.nextLine();
            if (logInOrSignup.equals("1")) {
                login();
            } else if (logInOrSignup.equals("2")) {
                signup();
            }
            if (loginAllowed) {
                switch (accountType) {
                    case "1":
                        userMenu();
                        break;
                    case "2":
                        sellerMenu();
                        break;
                    case "3":
                        adminMenu();
                        break;
                }
            }
            loginAllowed = false;
        }
        while (logInOrSignup.equals("1") || logInOrSignup.equals("2"));
    }

    //Logging In
    public static void login() {
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
                    } else {
                        System.out.println("Password is incorrect.");
                    }
                } else {
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
                        if (application.findSeller(username, password).getRequestResult() == 1) {
                            loginAllowed = true;
                        } else if (application.findSeller(username, password).getRequestResult() == 0) {
                            System.out.println("\nYour request hasn't been viewed by the admin yet. We thank you for your patience!");
                        }
                        return;
                    } else {
                        System.out.println("Password is incorrect.");
                    }
                } else {
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
                    } else {
                        System.out.println("Password is incorrect.");
                    }
                } else {
                    System.out.println("No account under this username exists.");
                }
                login();
                break;
            }
        }
    }

    public static void signup() {
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
        } else if (accountType.equals("2")) {
            ArrayList<Product> productOffers = new ArrayList<>();
            Product newProduct;
            System.out.println("\nAs a seller, you need to have at least one product to offer to the online shop" +
                    "\nYou will have to enter the attributes of your product(s) and wait for\nthe administrators to confirm that you're qualified as a seller." +
                    "\nRemember that this is only for giving the admin an idea of what you're offering\nand you are not actually adding these products;" +
                    "\nthat will be done thoroughly once your account is authorized.");
            while (true) {
                System.out.println("\nEnter the name of your product:");
                String name = input.nextLine();
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
            Seller newSeller = new Seller(username, password, 0);
            application.createAccount(newSeller);
            System.out.println("\nYour request was sent and will be authorized soon.\nUse the login menu to see the status of your request." +
                    "\nYou will be logged in immediately if your account gets authorized.\nThank you for your patience.");
        }
    }

    //user menu

    public static void userMenu() {
        Scanner input = new Scanner(System.in);
        String choice;
        do {
            System.out.println("\n\"RETAIL THERAPY\"\n\n1. Search for products\n2. View categories\n3. View shopping cart\n4. View profile\nEnter anything else to log out");
            choice = input.nextLine();
            switch (choice) {
                case "1":
                    search();
                    break;
                case "2":
                    //categories();
                    break;
                case "3":
                    viewShoppingCart();
                    break;
                case "4":
                    viewProfile();
                    break;
            }
        }
        while (choice.equals("1") || choice.equals("2") || choice.equals("3") || choice.equals("4"));
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

    public static void viewShoppingCart() {
        User currentUser = (User) application.getCurrentAccount();
        Scanner input = new Scanner(System.in);
        if (currentUser.getShoppingCart().isEmpty()) {
            System.out.println("\nYour shopping cart is empty.");
        }
        else {
            System.out.println("\nYour shopping cart:");
            application.printListOfProductsInArraylist(currentUser.getShoppingCart());
            System.out.println("\n1. Purchase item(s) in shopping cart\n2. Go back to menu");
            String purchaseOrNot = input.nextLine();
            if (purchaseOrNot.equals("1")) {
                currentUser.purchase();
                currentUser.submitOrder();
                for (Product product : currentUser.getShoppingCart()) {
                    product.setQuantity(product.getQuantity() - 1);
                }
                currentUser.clearShoppingCart();
                System.out.println("\nYou've just purchased the item(s) in your shopping cart!\nThank you for choosing \"RETAIL THERAPY\".");
            }
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
                            System.out.println("This password doesn't belong to your account. Try again or enter 0 to return:");
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
                        System.out.println('\n' + currentUser.getEmail() + "\nThis is your current email. What would you like to change it into?" +
                                "(Enter 0 if you've changed your mind)");
                        String newEmail = input.nextLine();
                        if (!newEmail.equals("0")) {
                            application.changeEmail(currentUser.getUsername(), newEmail);
                            System.out.println("Your email was changed to \"" + currentUser.getEmail() + '"');
                        }
                        break;
                    }
                    case "3": {
                        System.out.println('\n' + currentUser.getPhoneNumber() + "\nThis is your current phone number. What would you like to change it into?" +
                                "(Enter 0 if you've changed your mind)");
                        String newNumber = input.nextLine();
                        if (!newNumber.equals("0")) {
                            application.changeNumber(currentUser.getUsername(), newNumber);
                            System.out.println("Your phone number was changed to \"" + currentUser.getPhoneNumber() + '"');
                        }
                        break;
                    }
                    case "4": {
                        System.out.println('\n' + currentUser.getAddress() + "\nThis is your current address. What would you like to change it into?" +
                                "(Enter 0 if you've changed your mind)");
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
                } else {
                    System.out.println("\nYour shopping cart:");
                    application.printListOfProductsInArraylist(currentUser.getShoppingCart());
                }
                break;
            }
            case "4": {
                if (currentUser.getPurchasedProducts().isEmpty()) {
                    System.out.println("\nYou haven't purchased anything yet.");
                } else {
                    System.out.println("\nThese are all of the items you've purchased so far:");
                    application.printListOfProductsInArraylist(currentUser.getPurchasedProducts());
                }
                break;
            }
            case "5": {
                if (currentUser.getAllOrders().isEmpty()) {
                    System.out.println("You haven't submitted any orders yet.");
                } else {
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

    //seller menu

    public static void sellerMenu() {
        Scanner input = new Scanner(System.in);
        String choice;
        do {
            System.out.println("\n\"RETAIL THERAPY\"\n  for sellers\n\n1. Add products\n2. View profile\nEnter anything else to log out");
            choice = input.nextLine();
            switch (choice) {
                case "1":
                    addProduct();
                    break;
                case "2":
                    viewSellerProfile();
                    break;
            }
        }
        while (choice.equals("1") || choice.equals("2"));
        application.logout();
    }

    public static void addProduct() {
        Scanner input = new Scanner(System.in);
        System.out.println("\nWhat category does your product belong to?\n1. Clothing\n2. Health\n3. Beauty\n4. Phone\n5. Laptop\n6. Books" +
                "\n7. Kids\n8. Stationery\n9. Tools\n10. Groceries");
        String category = input.nextLine();
        switch (category) {
            case "1": {
                addClothing();
                break;
            }
            case "2": {
                addHealth();
                break;
            }
            case "3": {
                addBeauty();
                break;
            }
            case "4": {
                addPhone();
                break;
            }
            case "5": {
                addLaptop();
                break;
            }
            case "6": {
                addBook();
                break;
            }
            case "7": {
                addKids();
                break;
            }
            case "8": {
                addStationery();
                break;
            }
            case "9": {
                addTool();
                break;
            }
            case "10": {
                addGroceries();
                break;
            }
        }
    }

    public static void addClothing() {
        Scanner input = new Scanner(System.in);
        String addOrNot;
        do {
            System.out.println("\nName of product:");
            String name = input.nextLine();
            System.out.println("Type of clothing:");
            String type = input.nextLine();
            System.out.println("Brand:");
            String brand = input.nextLine();
            System.out.println("Size:");
            String size = input.nextLine();
            System.out.println("Color:");
            String color = input.nextLine();
            System.out.println("Gender:");
            String gender = input.nextLine();
            System.out.println("Price:");
            float price = Float.parseFloat(input.nextLine());
            System.out.println("Number of \"" + name + "\" you're adding:");
            int quantity = Integer.parseInt(input.nextLine());
            Clothing newClothes = new Clothing(name, type, brand, size, color, gender, price, quantity);
            application.addProduct(newClothes, application.getCurrentAccount().getUsername());
            System.out.println("\nProduct was added successfully.\nEnter 1 to add more pieces of clothing and enter 2 if you'd like to return:");
            addOrNot = input.nextLine();
        }
        while (addOrNot.equals("1"));
    }

    public static void addHealth() {
        Scanner input = new Scanner(System.in);
        String addOrNot;
        do {
            System.out.println("\nName of product:");
            String name = input.nextLine();
            System.out.println("Type of health product:");
            String type = input.nextLine();
            System.out.println("Brand:");
            String brand = input.nextLine();
            System.out.println("Is this product natural?\n1. Yes\n2. No");
            String natural = input.nextLine();
            boolean isNatural = natural.equals("1");
            System.out.println("Price:");
            float price = Float.parseFloat(input.nextLine());
            System.out.println("Number of \"" + name + "\" you're adding:");
            int quantity = Integer.parseInt(input.nextLine());
            Health newHealth = new Health(name, type, brand, isNatural, price, quantity);
            application.addProduct(newHealth, application.getCurrentAccount().getUsername());
            System.out.println("\nProduct was added successfully.\nEnter 1 to add more health products and enter 2 if you'd like to return:");
            addOrNot = input.nextLine();
        }
        while (addOrNot.equals("1"));
    }

    public static void addBeauty() {
        Scanner input = new Scanner(System.in);
        String addOrNot;
        do {
            System.out.println("\nName of product:");
            String name = input.nextLine();
            System.out.println("Type of beauty product:");
            String type = input.nextLine();
            System.out.println("Brand:");
            String brand = input.nextLine();
            System.out.println("SPF:");
            int spf = Integer.parseInt(input.nextLine());
            System.out.println("Price:");
            float price = Float.parseFloat(input.nextLine());
            System.out.println("Number of \"" + name + "\" you're adding:");
            int quantity = Integer.parseInt(input.nextLine());
            Beauty newBeauty = new Beauty(name, type, brand, spf, price, quantity);
            application.addProduct(newBeauty, application.getCurrentAccount().getUsername());
            System.out.println("\nProduct was added successfully.\nEnter 1 to add more beauty products and enter 2 if you'd like to return:");
            addOrNot = input.nextLine();
        }
        while (addOrNot.equals("1"));
    }

    public static void addPhone() {
        Scanner input = new Scanner(System.in);
        String addOrNot;
        do {
            System.out.println("\nName of product:");
            String name = input.nextLine();
            System.out.println("Type of product:");
            String type = input.nextLine();
            System.out.println("Company:");
            String company = input.nextLine();
            System.out.println("Color:");
            String color = input.nextLine();
            System.out.println("Screen size (in inches):");
            double size = Double.parseDouble(input.nextLine());
            System.out.println("Weight (in grams):");
            int weight = Integer.parseInt(input.nextLine());
            System.out.println("Internal storage (in gigabytes):");
            int storage = Integer.parseInt(input.nextLine());
            System.out.println("Ram (in gigabytes):");
            int ram = Integer.parseInt(input.nextLine());
            System.out.println("Processor:");
            String processor = input.nextLine();
            System.out.println("Main camera quality (in megapixels):");
            int mainCamera = Integer.parseInt(input.nextLine());
            System.out.println("Selfie camera quality (in megapixels):");
            int selfieCamera = Integer.parseInt(input.nextLine());
            System.out.println("Battery capacity (in mAh):");
            int battery = Integer.parseInt(input.nextLine());
            System.out.println("Price:");
            float price = Float.parseFloat(input.nextLine());
            System.out.println("Number of \"" + name + "\" you're adding:");
            int quantity = Integer.parseInt(input.nextLine());
            Phone newPhone = new Phone(name, type, company, color, size, weight, storage, ram, processor, mainCamera, selfieCamera, battery, price, quantity);
            application.addProduct(newPhone, application.getCurrentAccount().getUsername());
            System.out.println("\nProduct was added successfully.\nEnter 1 to add more phones and enter 2 if you'd like to return:");
            addOrNot = input.nextLine();
        }
        while (addOrNot.equals("1"));
    }

    public static void addLaptop() {
        Scanner input = new Scanner(System.in);
        String addOrNot;
        do {
            System.out.println("\nName of product:");
            String name = input.nextLine();
            System.out.println("Type of product:");
            String type = input.nextLine();
            System.out.println("Company:");
            String company = input.nextLine();
            System.out.println("Color:");
            String color = input.nextLine();
            System.out.println("Screen size (in inches):");
            double size = Double.parseDouble(input.nextLine());
            System.out.println("Weight (in grams):");
            int weight = Integer.parseInt(input.nextLine());
            System.out.println("Internal storage (in gigabytes):");
            int storage = Integer.parseInt(input.nextLine());
            System.out.println("Ram (in gigabytes):");
            int ram = Integer.parseInt(input.nextLine());
            System.out.println("CPU:");
            String cpu = input.nextLine();
            System.out.println("GPU:");
            String gpu = input.nextLine();
            System.out.println("GPU memory size (in gigabytes):");
            int gpuSize = Integer.parseInt(input.nextLine());
            System.out.println("Battery capacity (in mAh):");
            int battery = Integer.parseInt(input.nextLine());
            System.out.println("Price:");
            float price = Float.parseFloat(input.nextLine());
            System.out.println("Number of \"" + name + "\" you're adding:");
            int quantity = Integer.parseInt(input.nextLine());
            Laptop newlaptop = new Laptop(name, type, company, color, size, weight, storage, ram, cpu, gpu, gpuSize, battery, price, quantity);
            application.addProduct(newlaptop, application.getCurrentAccount().getUsername());
            System.out.println("\nProduct was added successfully.\nEnter 1 to add more laptops and enter 2 if you'd like to return:");
            addOrNot = input.nextLine();
        }
        while (addOrNot.equals("1"));
    }

    public static void addBook() {
        Scanner input = new Scanner(System.in);
        String addOrNot;
        do {
            System.out.println("\nName of product:");
            String name = input.nextLine();
            System.out.println("Publisher:");
            String publisher = input.nextLine();
            System.out.println("Author:");
            String author = input.nextLine();
            System.out.println("Genre:");
            String genre = input.nextLine();
            System.out.println("Price:");
            float price = Float.parseFloat(input.nextLine());
            System.out.println("Number of \"" + name + "\" you're adding:");
            int quantity = Integer.parseInt(input.nextLine());
            Book newBook = new Book(name, publisher, author, genre, price, quantity);
            application.addProduct(newBook, application.getCurrentAccount().getUsername());
            System.out.println("\nProduct was added successfully.\nEnter 1 to add more books and enter 2 if you'd like to return:");
            addOrNot = input.nextLine();
        }
        while (addOrNot.equals("1"));
    }

    public static void addKids() {
        Scanner input = new Scanner(System.in);
        String addOrNot;
        do {
            System.out.println("\nName of product:");
            String name = input.nextLine();
            System.out.println("Type of kids product:");
            String type = input.nextLine();
            System.out.println("Brand:");
            String brand = input.nextLine();
            System.out.println("Color:");
            String color = input.nextLine();
            System.out.println("Price:");
            float price = Float.parseFloat(input.nextLine());
            System.out.println("Number of \"" + name + "\" you're adding:");
            int quantity = Integer.parseInt(input.nextLine());
            Kids newKids = new Kids(name, type, brand, color, price, quantity);
            application.addProduct(newKids, application.getCurrentAccount().getUsername());
            System.out.println("\nProduct was added successfully.\nEnter 1 to add more kids' products and enter 2 if you'd like to return:");
            addOrNot = input.nextLine();
        }
        while (addOrNot.equals("1"));
    }

    public static void addStationery() {
        Scanner input = new Scanner(System.in);
        String addOrNot;
        do {
            System.out.println("\nName of product:");
            String name = input.nextLine();
            System.out.println("Type of stationery:");
            String type = input.nextLine();
            System.out.println("Company:");
            String company = input.nextLine();
            System.out.println("Color:");
            String color = input.nextLine();
            System.out.println("Price:");
            float price = Float.parseFloat(input.nextLine());
            System.out.println("Number of \"" + name + "\" you're adding:");
            int quantity = Integer.parseInt(input.nextLine());
            Stationery newStationery = new Stationery(name, type, company, color, price, quantity);
            application.addProduct(newStationery, application.getCurrentAccount().getUsername());
            System.out.println("\nProduct was added successfully.\nEnter 1 to add more stationery and enter 2 if you'd like to return:");
            addOrNot = input.nextLine();
        }
        while (addOrNot.equals("1"));
    }

    public static void addTool() {
        Scanner input = new Scanner(System.in);
        String addOrNot;
        do {
            System.out.println("\nName of product:");
            String name = input.nextLine();
            System.out.println("Type of tool:");
            String type = input.nextLine();
            System.out.println("Color:");
            String color = input.nextLine();
            System.out.println("Material:");
            String material = input.nextLine();
            System.out.println("Price:");
            float price = Float.parseFloat(input.nextLine());
            System.out.println("Number of \"" + name + "\" you're adding:");
            int quantity = Integer.parseInt(input.nextLine());
            Tools newTool = new Tools(name, type, color, material, price, quantity);
            application.addProduct(newTool, application.getCurrentAccount().getUsername());
            System.out.println("\nProduct was added successfully.\nEnter 1 to add more tools and enter 2 if you'd like to return:");
            addOrNot = input.nextLine();
        }
        while (addOrNot.equals("1"));
    }

    public static void addGroceries() {
        Scanner input = new Scanner(System.in);
        String addOrNot;
        do {
            System.out.println("\nName of product:");
            String name = input.nextLine();
            System.out.println("Group of groceries:");
            String group = input.nextLine();
            System.out.println("Net weight (in grams):");
            int weight = Integer.parseInt(input.nextLine());
            System.out.println("Price:");
            float price = Float.parseFloat(input.nextLine());
            System.out.println("Number of \"" + name + "\" you're adding:");
            int quantity = Integer.parseInt(input.nextLine());
            Groceries newGroceries = new Groceries(name, group, weight, price, quantity);
            application.addProduct(newGroceries, application.getCurrentAccount().getUsername());
            System.out.println("\nProduct was added successfully.\nEnter 1 to add more groceries and enter 2 if you'd like to return:");
            addOrNot = input.nextLine();
        }
        while (addOrNot.equals("1"));
    }

    public static void viewSellerProfile() {
        Seller currentSeller = (Seller) application.getCurrentAccount();
        System.out.println("\nUsername: " + currentSeller.getUsername());
        System.out.print("Password: ");
        for (int i = 0; i < currentSeller.getPassword().length(); i++) {
            System.out.print("*");
        }
        System.out.println("\n\n1. Go back to the menu\n2. Change Password\n3. View your products");
        Scanner input = new Scanner(System.in);
        String choice = input.nextLine();
        if (choice.equals("2")) {
            System.out.println("Please verify your password:");
            String passwordVerify = input.nextLine();
            while (!passwordVerify.equals(currentSeller.getPassword())) {
                System.out.println("This password doesn't belong to your account. Try again or enter 0 to return:");
                passwordVerify = input.nextLine();
                if (passwordVerify.equals("0")) {
                    return;
                }
            }
            System.out.println("What would you like your new password to be?");
            String newPassword = input.nextLine();
            application.changePassword(currentSeller.getUsername(), newPassword);
            System.out.println("Your password has been changed successfully.");
        } else if (choice.equals("3")) {
            if (currentSeller.getAvailableProducts().isEmpty()) {
                System.out.println("\nYou don't have any products available in the shop.");
            } else {
                System.out.println("\nYour products:");
                application.printListOfProductsInArraylist(currentSeller.getAvailableProducts());
            }
        }
    }


    //admin menu

    public static void adminMenu() {
        Scanner input = new Scanner(System.in);
        String choice;
        do {
            System.out.println("\n\"RETAIL THERAPY\"\n  for admins\n\n1. View seller requests\n2. View profile\nEnter anything else to log out");
            choice = input.nextLine();
            switch (choice) {
                case "1":
                    viewSellerRequests();
                    break;
                case "2":
                    viewAdminProfile();
                    break;
            }
        }
        while (choice.equals("1") || choice.equals("2"));
        application.logout();
    }

    public static void viewSellerRequests() {
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.println("\nHere you can see every seller's request who want to be a part of \"RETAIL THERAPY\".\nThey will be shown to you one by one." +
                    "\nEnter 1 to continue or enter anything else to go back to the menu.");
            String viewOrNot = input.nextLine();
            if (viewOrNot.equals("1")) {
                if (!application.viewSellerRequest()) {
                    System.out.println("\nThere are no requests from sellers.");
                    return;
                }
            } else {
                return;
            }
        }
    }

    public static void viewAdminProfile() {
        Admin currentAdmin = (Admin) application.getCurrentAccount();
        System.out.println("\nUsername: " + currentAdmin.getUsername());
        System.out.print("Password: ");
        for (int i = 0; i < currentAdmin.getPassword().length(); i++) {
            System.out.print("*");
        }
        System.out.println("\n\n1. Go back to the menu\n2. Change Password");
        Scanner input = new Scanner(System.in);
        String choice = input.nextLine();
        if (choice.equals("2")) {
            System.out.println("Please verify your password:");
            String passwordVerify = input.nextLine();
            while (!passwordVerify.equals(currentAdmin.getPassword())) {
                System.out.println("This password doesn't belong to your account. Try again or enter 0 to return:");
                passwordVerify = input.nextLine();
                if (passwordVerify.equals("0")) {
                    return;
                }
            }
            System.out.println("What would you like your new password to be?");
            String newPassword = input.nextLine();
            application.changePassword(currentAdmin.getUsername(), newPassword);
            System.out.println("Your password has been changed successfully.");
        }
    }
}