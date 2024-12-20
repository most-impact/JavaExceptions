import models.UserCredential;
import exception.WrongLoginException;
import exception.WrongPasswordException;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter login: ");
        String login = scanner.nextLine();

        System.out.println("Enter password: ");
        String password = scanner.nextLine();

        System.out.println("Confirm password: ");
        String confirmPassword = scanner.nextLine();

        try {
            UserCredential.validate(login, password, confirmPassword);
            UserCredential user = new UserCredential(login, password);
            System.out.println("User credentials are valid.");
        } catch (WrongLoginException e) {
            System.out.println("Login validation error: " + e.getMessage());
        } catch (WrongPasswordException e) {
            System.out.println("Password validation error: " + e.getMessage());
        }
    }
}
