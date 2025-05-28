package com.coderscampus.Assign3;

public class UserPojo {
    private final String username;
    private final String password;
    private final String fileName;

    public UserPojo(String username, String password, String filename) {
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


































