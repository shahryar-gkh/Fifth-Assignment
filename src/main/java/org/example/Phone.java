package org.example;

public class Phone extends Product {
    private String category;
    private String companyName;
    private String color;
    private int sizeInInches;
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
    public void setSizeInInches(int sizeInInches) {
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
    public int getSizeInInches() {
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
