package models;

import exception.WrongLoginException;
import exception.WrongPasswordException;

public class UserCredential {
    private String login;
    private String password;

    public UserCredential(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public static void validate(String login, String password, String confirmPassword)
            throws WrongLoginException, WrongPasswordException {
        if (login == null || login.length() > 20 || !login.matches("^[a-zA-Z0-9_]+$")) {
            throw new WrongLoginException("Login must be less than 20 characters and contain only letters, digits, and underscores.");
        }

        if (password == null || password.length() > 20 || !password.matches("^[a-zA-Z0-9_]+$")) {
            throw new WrongPasswordException("Password must be less than 20 characters and contain only letters, digits, and underscores.");
        }

        if (!password.equals(confirmPassword)) {
            throw new WrongPasswordException("Password and confirm password do not match.");
        }
    }
}