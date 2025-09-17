package src;

import java.util.Scanner;

import src.repositories.AuthRepository;
import src.ui.Menu;

public class Main {
    public static void main(String[] args) {
 
        Scanner input = new Scanner(System.in);
        AuthRepository auth = new AuthRepository();
        Menu menu = new Menu();
        int choice;
        while(true){
            System.out.print("\n");
            System.out.println(menu.guestMenu());
            choice = input.nextInt();
            input.nextLine();
            switch(choice){
                case 1 -> menu.registerMenu(input, auth);
                case 0 -> {
                    System.exit(0);
                }
            }

        }
    }
}
