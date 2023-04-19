package org.example;

public class Admin extends Account {
    private String email;

    public Admin(String username, String password, String email) {
        super(username, password);
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nEmail: " + email;
    }
}
