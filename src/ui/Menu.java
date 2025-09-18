package src.ui;

import java.util.Scanner;

import src.repositories.AuthRepository;

public class Menu {

    private AuthRepository auth;
    public Menu(AuthRepository auth){
        this.auth = auth;
    }

    public String guestMenu(){
        String menu = """
                1)Register
                2)Login
                0)Exit""";
        return menu;
    }
    public void registerMenu(Scanner input){
        System.out.println("*****Register Menu******");
        System.out.print("Enter your name: ");
        String fullName = input.nextLine();
        System.out.print("Enter your email: ");
        String email = input.nextLine();
        System.out.print("Enter your password: ");
        String password = input.nextLine();
        String message = auth.register(fullName,email,password);
        if (message.equals("done")){
            this.authenticatedMenu(input);
        } else {
            System.err.println(message);
        }
    }
    public void loginMenu(Scanner input){
        System.out.println("*****Login Menu******");
        System.out.print("Enter your Email:");
        String email = input.nextLine();
        System.out.print("Enter your password: ");
        String password = input.nextLine();
        String message = auth.login(email,password);
        if (message.equals("done")){
            this.authenticatedMenu(input);
        } else  {
           System.err.println(message);
        }
    }

    public void authenticatedMenu(Scanner input){
        System.out.println("*****Welcome "+ auth.getAuthUser(auth.isLogedIn(), auth.getId()).getFullName() +"******");
        String menu = """
                1)Hotel management
                2)Reservation management
                0)Exit""";
        int choice;
        while(true){
            System.out.println(menu);
            choice = input.nextInt();
            input.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("hotel");
                    break;
                case 2:
                    System.out.println("reservation");
                    break;
                case 0:
                    System.exit(0);
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }

}
