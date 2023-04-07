package org.example;

public class Book extends Product {
    private String category;
    private String publisher;
    private String author;
    private String genre;

    //Setters

    public void setCategory(String category) {
        this.category = category;
    }
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

    public String getCategory() {
        return category;
    }
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
        return '\n' + category +
                super.toString() +
                "\nAuthor: " + author +
                "\nPublisher: " + publisher +
                "\nGenre: " + genre;
    }
}
