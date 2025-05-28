package com.coderscampus.Assign3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

import static com.coderscampus.Assign3.UserService.*;

public class UserApplication {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int attempts = 0;
        final int MAX_ATTEMPTS = 5;
        while (true) {
            System.out.print("Enter username: ");
            String username = scanner.nextLine();

            System.out.print("Enter password: ");
            String password = scanner.nextLine();


            String fileName = Arrays.toString(args);
            int loggedInUser = readUsersFromFile("data.txt");

            UserPojo[] userPojos = loadUsers("data.txt");
            boolean authenticated = false;
            assert userPojos != null;
            for (UserPojo userPojo : userPojos) {
                if (userPojo.getUsername().equals(username) && userPojo.getPassword().equals(password)) {
                    System.out.println("Welcome " + userPojo.getFilename());
                    authenticated = true;
                    break;
                }
            }
            if (!authenticated) {
                attempts++;
                if (attempts < 5) {
                    System.out.println("Invalid login, please try again.");
                } else {
                    System.out.println("Too many failed login attempts, you are now locked out.");
                }
            }
        }

    }

    public static UserPojo[] loadUsers(String filename) {
        try {
            Scanner fileScanner = new Scanner(new File(filename));
            int userCount = 0;

            while (fileScanner.hasNextLine()) {
                fileScanner.nextLine();
                userCount++;
            }

            fileScanner = new Scanner(new File(filename));
            UserPojo[] users = new UserPojo[userCount];
            int index = 0;

            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    users[index++] = new UserPojo(parts[0], parts[1], parts[2]);
                }
            }

            fileScanner.close();
            return users;

        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filename);
            return null;
        }
    }
}
