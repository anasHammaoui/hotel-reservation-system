package src.ui;

import java.util.Scanner;

import src.repositories.AuthRepository;

public class Menu {
    public String guestMenu(){
        String menu = """
                1)Register
                2)Login
                0)Exit""";
        return menu;
    }
    public void registerMenu(Scanner input, AuthRepository auth){
        System.out.print("Enter your name: ");
        String fullName = input.nextLine();
        System.out.print("Enter your email: ");
        String email = input.nextLine();
        System.out.print("Enter your password: ");
        String password = input.nextLine();
        String message = auth.register(fullName,email,password);
        if (message == "done"){
            System.out.println(auth.isLogedIn());
            System.out.println(auth.getId());
        } else {
            System.err.println(message);
        }
    }
    public void loginMenu(Scanner input, AuthRepository auth){
        System.out.print("Enter your Email:");
        String email = input.nextLine();
        System.out.print("Enter your password: ");
        String password = input.nextLine();
        String message = auth.login(email,password);
        if (message == "done"){
            System.out.println(auth.isLogedIn());
            System.out.println(auth.getId());
        } else  {
           System.err.println(message);
        }
    }
}
