package org.example;

public class Laptop extends Product {
    private String category;
    private String companyName;
    private String color;
    private int sizeInInches;
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
