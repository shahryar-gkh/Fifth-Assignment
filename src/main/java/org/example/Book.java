package org.example;

public class Book extends Product {
    public Book(String name, String publisher, String author, String genre, float price, int quantity) {
        this.name = name;
        this.publisher = publisher;
        this.author = author;
        this.genre = genre;
        this.price = price;
        this.quantity = quantity;
    }

    private String publisher;
    private String author;
    private String genre;

    //Setters

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public void setGenre(String genre) {
        this.genre = genre;
    }

    //Getters

    public String getPublisher() {
        return publisher;
    }
    public String getAuthor() {
        return author;
    }
    public String getGenre() {
        return genre;
    }

    @Override
    public String toString() {
        return  super.toString() +
                "\nAuthor: " + author +
                "\nPublisher: " + publisher +
                "\nGenre: " + genre;
    }
}
