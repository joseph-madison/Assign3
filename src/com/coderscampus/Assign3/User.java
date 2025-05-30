package com.coderscampus.Assign3;

public class User {
    private final String username;
    private final String password;
    private final String fileName;

    public User(String username, String password, String filename) {
        this.username = username;
        this.password = password;
        this.fileName = filename;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getFilename() {
        return fileName;

    }
}


































