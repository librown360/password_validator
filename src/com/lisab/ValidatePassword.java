package com.lisab;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidatePassword {

        // call user class for password
        User u = new User();

        // flags for determining if password is valid
        boolean passwordHasValidLength;
        boolean passwordHasLetter;
        boolean passwordHasNumber;

    // method to validate password length
        public void validatePasswordLength() {

            // password length requirement
            int requiredPasswordLength = 8;

            // determine the password length
            int passwordCount = u.getPassword().length();

            // validate the password length and display appropriate message
            if (passwordCount >= requiredPasswordLength) {
                passwordHasValidLength = true;
            } else {
                System.out.println("The password must be at least 8 characters.");
            }
        }

        // method to validate if password has a letter
        public void validatePasswordHasLetter() {

            // pattern for finding a letter
            String letterPattern = ".*[a-z].*";

            // create and compile pattern eliminating case
            Pattern pattern = Pattern.compile(letterPattern, Pattern.CASE_INSENSITIVE);

            // create matcher to compare pattern with password
            Matcher matcher = pattern.matcher(u.getPassword());

            passwordHasLetter = matcher.matches();

            // check password for letter and set flag/message accordingly
            if (passwordHasLetter == true) {
                passwordHasLetter = true;
            } else {
                System.out.println("The password must contain at least one letter.");
            }
        }

        // method to validate if password has a number
        public void validatePasswordHasNumber() {

            // pattern for finding a number
            String numberPattern = ".*[0-9].*";

            // create and compile pattern
            Pattern pattern = Pattern.compile(numberPattern);

            // create matcher to compare pattern with password
            Matcher matcher = pattern.matcher(u.getPassword());

            passwordHasNumber = matcher.matches();

            // check password for number and set flag/message accordingly
            if (passwordHasNumber == true) {
                passwordHasNumber = true;
            } else {
                System.out.println("The password must contain at least one number.");
            }
        }

        // method to determine whether password is valid or invalid
        public void validatePassword() {
            if (passwordHasValidLength == true && passwordHasLetter == true && passwordHasNumber == true) {
                System.out.println("The password is accepted");
            }
        }
}
