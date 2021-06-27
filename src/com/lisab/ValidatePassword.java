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
        boolean passwordHasSpecialCharacter;

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
                validatePasswordHasSpecialCharacter();
                validateAdminPassword();
            }

        }

        // method to validate regular password length
        public void validateRegularPasswordLength() {

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

        // method to validate password has a special character
        public void validatePasswordHasSpecialCharacter() {

            // pattern for finding a special character
            String specialCharacterPattern = ".*['!'||'@'||'#'||'$'||'%'||'^'||'&'||'*'].*";

            // create and compile pattern
            Pattern pattern = Pattern.compile(specialCharacterPattern);

            // create matcher to compare pattern with password
            Matcher matcher = pattern.matcher(u.getPassword());

            passwordHasSpecialCharacter = matcher.matches();

            // check password for special character and set flag/message accordingly
            if (passwordHasSpecialCharacter == true) {
                passwordHasSpecialCharacter = true;
            } else {
                System.out.println("The password must contain at least one of the following characters: " +
                        "!, @, #, $, %, ^, &, or *.");
            }
        }

        // method to determine whether admin password is valid or invalid
        public void validateAdminPassword() {
            if (passwordHasValidLength == true && passwordHasLetter == true && passwordHasNumber == true &&
                    passwordHasSpecialCharacter == true) {
                System.out.println("The password is accepted");
            }
        }
}
