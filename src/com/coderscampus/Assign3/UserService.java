package com.coderscampus.Assign3;


import java.io.*;

import java.util.Scanner;

public class UserService {

    public static User[] loadUsers(String filename) {
            try {
                Scanner fileScanner = new Scanner(new File(filename));
                int userCount = 0;

                while (fileScanner.hasNextLine()) {
                    fileScanner.nextLine();
                    userCount++;
                }

                fileScanner = new Scanner(new File(filename));
                User[] users = new User[userCount];
                int index = 0;

                while (fileScanner.hasNextLine()) {
                    String line = fileScanner.nextLine();
                    String[] parts = line.split(",");
                    if (parts.length == 3) {
                        users[index++] = new User(parts[0], parts[1], parts[2]);
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

