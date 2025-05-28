package com.coderscampus.Assign3;


import java.io.BufferedReader;

import java.io.FileReader;
import java.io.IOException;

public class UserService {

    public static int readUsersFromFile(String filename) throws IOException, IOException {

        BufferedReader reader = new BufferedReader(new FileReader("data.txt"));
        int userCount = 0;
        while (reader.readLine() != null) {
            userCount++;
        }
        reader.close();

        UserPojo[] userPojos = new UserPojo[userCount];

        BufferedReader readerAgain = new BufferedReader(new FileReader("data.txt"));
        String line;
        int index = 0;
        while ((line = readerAgain.readLine()) != null) {
            String[] parts = line.split(",");
            if (parts.length == 3) {
                String username = parts[0].trim();
                String password = parts[1].trim();
                String name = parts[2].trim();
                userPojos[index++] = new UserPojo(username, password, name);
            }
        }
        readerAgain.close();

        return userCount;
    }
}


