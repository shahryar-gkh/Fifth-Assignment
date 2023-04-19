package org.example;

public class Laptop extends Product {
    public Laptop(String name, String category, String companyName, String color, double sizeInInches, int weightInGrams, int storageInGigabytes,
                int ram, String cpu, String gpu, int gpuSize, int battery, float price, int quantity) {
        this.name = name;
        this.category = category;
        this.companyName = companyName;
        this.color = color;
        this.sizeInInches = sizeInInches;
        this.weightInGrams = weightInGrams;
        this.storageInGigabytes = storageInGigabytes;
        this.ram = ram;
        this.cpu = cpu;
        this.gpu = gpu;
        this.gpuSize = gpuSize;
        this.battery = battery;
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
    private String cpu;
    private String gpu;
    private int gpuSize;
    private int battery;

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
    public void setCpu(String cpu) {
        this.cpu = cpu;
    }
    public void setGpu(String gpu) {
        this.gpu = gpu;
    }
    public void setGpuSize(int gpuSize) {
        this.gpuSize = gpuSize;
    }
    public void setBattery(int battery) {
        this.battery = battery;
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
    public String getCpu() {
        return cpu;
    }
    public String getGpu() {
        return gpu;
    }
    public int getGpuSize() {
        return gpuSize;
    }
    public int getBattery() {
        return battery;
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
                "\nCPU: " + cpu +
                "\nGPU: " + gpu +
                "\nGPU size: " + gpuSize +
                "\nBattery: " + battery;
    }
}
