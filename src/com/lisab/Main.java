package com.lisab;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// get and store password from input

        // Request user to enter password
        System.out.println("Enter password");
        // Read in user password
        Scanner scanner = new Scanner(System.in);
        // Store user password
        String password = scanner.nextLine();

        // validate password
        ValidatePassword v = new ValidatePassword();
        v.u.setPassword(password);
        v.validatePasswordLength();
        v.validatePasswordHasLetter();
        v.validatePasswordHasNumber();
        v.validatePassword();

    }
}
