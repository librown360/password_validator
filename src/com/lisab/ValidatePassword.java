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
        boolean passwordHasSpecialCharacters;

        // validate user password based on user type
        public void validateUser() {

            String uType = u.getUserType();

            if(uType.equals("regular")) {
                validateRegularPasswordLength();
                validatePasswordHasLetter();
                validatePasswordHasNumber();
                validateRegularPassword();
            } else {
                validateAdminPasswordLength();
                validatePasswordHasLetter();
                validatePasswordHasNumber();
                validateAdminPasswordHasSpecialCharacters();
                validateAdminPassword();
            }

        }

        // method to validate regular password length
        public void validateRegularPasswordLength() {

            // password length requirement
            int requiredPasswordLength = 10;

            // determine the password length
            int passwordCount = u.getPassword().length();

            // validate the password length and display appropriate message
            if (passwordCount >= requiredPasswordLength) {
                passwordHasValidLength = true;
            } else {
                System.out.println("The password must be at least 10 characters.");
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

        // method to determine whether regular password is valid or invalid
        public void validateRegularPassword() {
            if (passwordHasValidLength == true && passwordHasLetter == true && passwordHasNumber == true) {
                System.out.println("The password is accepted");
            }
        }

        // method to validate admin password length
        public void validateAdminPasswordLength() {
            // password length requirement
            int requiredPasswordLength = 13;

            // determine the password length
            int passwordCount = u.getPassword().length();

            // validate the password length and display appropriate message
            if (passwordCount >= requiredPasswordLength) {
                passwordHasValidLength = true;
            } else {
                System.out.println("The password must be at least 13 characters.");
            }
    }

        // method to validate password has at least three special characters
        public void validateAdminPasswordHasSpecialCharacters() {

            // pattern for finding at least one of any of these special characters
            String specialCharacterPattern = "[!@#$%^&*]{1}";

            // create and compile pattern
            Pattern pattern = Pattern.compile(specialCharacterPattern);

            // create matcher to compare pattern with password
            Matcher matcher = pattern.matcher(u.getPassword());

            //loop through password to count occurrences of special characters
            int count = 0;
            while (matcher.find()){
                count++;
                //System.out.println("found: " + count + " : " + m.start() + " - "
                  //      + m.end());
            }

            // check for three occurrences of special characters and set flag accordingly
            if (count >= 3) {
                passwordHasSpecialCharacters = true;
            } else {
                passwordHasSpecialCharacters = false;
                System.out.println("The password must contain at least three of any of the following characters: " +
                        "!, @, #, $, %, ^, &, or *.");
            }

        }

        // method to determine whether admin password is valid or invalid
        public void validateAdminPassword() {
            if (passwordHasValidLength == true && passwordHasLetter == true && passwordHasNumber == true &&
                    passwordHasSpecialCharacters == true) {
                System.out.println("The password is accepted");
            }
        }
}
