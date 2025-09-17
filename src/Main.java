package src;

import java.util.Scanner;

import src.repositories.AuthRepository;

public class Main {
    public static void main(String[] args) {
 
        Scanner input = new Scanner(System.in);
        AuthRepository auth = new AuthRepository();
        while(true){
        System.out.println("enter your name: ");
        String fullName = input.nextLine();
        System.out.println("enter your email: ");
        String email = input.nextLine();
        System.out.println("enter your password: ");
        String password = input.nextLine();
        if (auth.register(fullName,email,password)){
            System.out.println(auth.isLogedIn());
            System.out.println(auth.getId());
        } else {
            System.out.println("failed to register");
            break;
        }
        }
        input.close();
    }
}
