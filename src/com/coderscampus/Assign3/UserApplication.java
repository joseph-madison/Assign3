package com.coderscampus.Assign3;

import java.util.Objects;
import java.util.Scanner;

import static com.coderscampus.Assign3.UserService.*;

public class UserApplication {


    public static void main(String[] Args) {
    try {
        User[] users = loadUsers("data.txt");
        Scanner scanner = new Scanner(System.in);
        int MAX_ATTEMPTS = 5;
        int attempts = 0;

        while (attempts < MAX_ATTEMPTS) {
            System.out.print("Enter username: ");

            String username = scanner.nextLine();

            System.out.print("Enter password: ");

            String password = scanner.nextLine();

            boolean authenticated = false;
            for (User user : Objects.requireNonNull(users))
                if (user.getUsername().equalsIgnoreCase(username) && user.getPassword().equals(password)) {
                    System.out.println("Welcome " + user.getName());
                    return;
                }


            if (!authenticated) {
                attempts++;
                System.out.println("Invalid login, please try again.");
                if (attempts == MAX_ATTEMPTS) {
                    System.out.println("Too many failed login attempts, you are now locked out.");
                }

            }
        }
        scanner.close();

        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }
}









