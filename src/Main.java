package src;

import java.util.Scanner;

import src.repositories.AuthRepository;

public class Main {
    public static void main(String[] args) {
        AuthRepository auth = new AuthRepository();
        Scanner input = new Scanner(System.in);
        System.out.println("enter your name: ");
        String fullName = input.nextLine();
        System.out.println("enter your email: ");
        String email = input.nextLine();
        System.out.println("enter your password: ");
        String password = input.nextLine();
        auth.register(fullName,email,password);
        System.out.println(auth.isLogedIn());
        System.out.println(auth.getId());
        input.close();
    }
}
