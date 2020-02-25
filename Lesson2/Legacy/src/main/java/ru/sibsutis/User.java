package ru.sibsutis;

abstract class User {
    private String name, email;

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public String getEmail() {
        return this.email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}