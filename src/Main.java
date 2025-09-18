package src;

import java.util.Scanner;

import src.repositories.AuthRepository;
import src.ui.Menu;

public class Main {
    public static void main(String[] args) {
 
        Scanner input = new Scanner(System.in);
        AuthRepository auth = new AuthRepository();
        Menu menu = new Menu(auth);
        int choice;
        while(true){
            System.out.println("*****Main Menu******");
            System.out.println(menu.guestMenu());
            choice = input.nextInt();
            input.nextLine();
            switch(choice){
                case 1 -> menu.registerMenu(input);
                case 2 -> menu.loginMenu(input);
                case 0 -> System.exit(0);
                default ->  System.out.println("Invalid choice. Please try again.");
            }

        }
    }
}
