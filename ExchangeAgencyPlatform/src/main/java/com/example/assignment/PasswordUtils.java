package com.example.assignment;

import org.mindrot.jbcrypt.BCrypt;

public class PasswordUtils {

    public static String hashPassword(String plainTextPassword) {
        return BCrypt.hashpw(plainTextPassword, BCrypt.gensalt());
    }

    public static boolean checkPassword(String plainTextPassword, String hashedPassword) {
        return BCrypt.checkpw(plainTextPassword, hashedPassword);
    }

    public static void main(String[] args) {
        String password = "mySecurePassword";
        String hashedPassword = hashPassword(password);
        System.out.println("Hashed Password: " + hashedPassword);
        boolean passwordMatch = checkPassword(password, hashedPassword);
        System.out.println("Password Match: " + passwordMatch);
    }
}

