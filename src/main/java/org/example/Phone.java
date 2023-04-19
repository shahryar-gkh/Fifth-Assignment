package org.example;

public class Phone extends Product {
    public Phone(String name, String category, String companyName, String color, double sizeInInches, int weightInGrams, int storageInGigabytes,
                 int ram, String processor, int mainCamera, int selfieCamera, int batteryCapacity, float price, int quantity) {
        this.name = name;
        this.category = category;
        this.companyName = companyName;
        this.color = color;
        this.sizeInInches = sizeInInches;
        this.weightInGrams = weightInGrams;
        this.storageInGigabytes = storageInGigabytes;
        this.ram = ram;
        this.processor = processor;
        this.mainCamera = mainCamera;
        this.selfieCamera = selfieCamera;
        this.batteryCapacity = batteryCapacity;
        this.price = price;
        this.quantity = quantity;
    }

    private String category;
    private String companyName;
    private String color;
    private double sizeInInches;
    private int weightInGrams;
    private int storageInGigabytes;
    private int ram;
    private String processor;
    private int mainCamera;
    private int selfieCamera;
    private int batteryCapacity;

    //Setters

    public void setCategory(String category) {
        this.category = category;
    }
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public void setSizeInInches(double sizeInInches) {
        this.sizeInInches = sizeInInches;
    }
    public void setWeightInGrams(int weightInGrams) {
        this.weightInGrams = weightInGrams;
    }
    public void setStorageInGigabytes(int storageInGigabytes) {
        this.storageInGigabytes = storageInGigabytes;
    }
    public void setRam(int ram) {
        this.ram = ram;
    }
    public void setProcessor(String processor) {
        this.processor = processor;
    }
    public void setMainCamera(int mainCamera) {
        this.mainCamera = mainCamera;
    }
    public void setSelfieCamera(int selfieCamera) {
        this.selfieCamera = selfieCamera;
    }
    public void setBatteryCapacity(int batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }

    //Getters

    public String getCategory() {
        return category;
    }
    public String getCompanyName() {
        return companyName;
    }
    public String getColor() {
        return color;
    }
    public double getSizeInInches() {
        return sizeInInches;
    }
    public int getWeightInGrams() {
        return weightInGrams;
    }
    public int getStorageInGigabytes() {
        return storageInGigabytes;
    }
    public int getRam() {
        return ram;
    }
    public String getProcessor() {
        return processor;
    }
    public int getMainCamera() {
        return mainCamera;
    }
    public int getSelfieCamera() {
        return selfieCamera;
    }
    public int getBatteryCapacity() {
        return batteryCapacity;
    }

    @Override
    public String toString() {
        return '\n' + category +
                super.toString() +
                "\nCompany: " + companyName +
                "\nColor: " + color +
                "\nSize: " + sizeInInches + " inches" +
                "\nWeight: " + weightInGrams + " grams" +
                "\nStorage: " + storageInGigabytes + " GB"+
                "\nRam: " + ram + " GB" +
                "\nProcessor: " + processor +
                "\nMain camera: " + mainCamera + " MP" +
                "\nSelfie camera: " + selfieCamera + " MP" +
                "\nBattery: " + batteryCapacity + " mAh";
    }
}
