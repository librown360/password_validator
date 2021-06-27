package com.lisab;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // get and store password from input

        // Request user type
        System.out.println("Enter user type: ");
        // Read user type
        Scanner scr1 = new Scanner(System.in);
        // Store user type
        String userType = scr1.nextLine();
        // Request user password
        System.out.println("Enter password: ");
        // Read user password
        Scanner scr2 = new Scanner(System.in);
        // Store user password
        String password = scr2.nextLine();

        ValidatePassword v = new ValidatePassword();
        v.u.setUserType(userType);
        v.u.setPassword(password);
        v.validateUser();

    }
}
