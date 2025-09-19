package src.ui;

import java.util.HashMap;
import java.util.Scanner;

import src.models.Hotel;
import src.repositories.AuthRepository;
import src.repositories.HotelRepository;

public class Menu {

    private AuthRepository auth;
    private HotelRepository hotels;

    public Menu(AuthRepository auth, HotelRepository hotels){
        this.auth = auth;
        this.hotels = hotels;
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
                    hotelManagementMenu(input);
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

    public void hotelManagementMenu(Scanner input){
        System.out.println("*****Hotel Management******");
        String menu = """
                1)Create Hotel
                2)List hotels
                3)Update hotel
                4)Delete hotel
                0)Exit""";
        String listHotelsMenu = """
                1)List all hotels
                2)List available hotels
                0)Exit
                """;
        int choice;
        while(true){
            System.out.println(menu);
            choice = input.nextInt();
            input.nextLine();
            switch (choice) {
                case 1:
                    System.out.print("Enter hotel name: ");
                    String name = input.nextLine();
                    System.out.print("Enter available rooms: ");
                    int availableRooms = input.nextInt();
                    System.out.print("Enter hotel rating: ");
                    double rating = input.nextDouble();
                    input.nextLine();
                    hotels.createHotel(name, availableRooms, rating);
                    break;
                case 2:
                    while(true){
                        System.out.print(listHotelsMenu);
                    choice = input.nextInt();
                    input.nextLine();
                    HashMap<String, Hotel> listhHotels = new HashMap<>();
                        if (choice == 1){
                        listhHotels = hotels.listHotels(false);
                    } else if (choice == 2){
                        listhHotels = hotels.listHotels(true);
                    } else {
                        break;
                    }
                    if (listhHotels.size() > 0){
                        for (Hotel hotel : listhHotels.values()){
                        System.out.println("******Hotel "+ hotel.getName() + "******");
                        System.out.println("Hotel Name: "+hotel.getName());
                        System.out.println("Hotel Rating: "+hotel.getRating());
                        System.out.println("Available rooms: "+hotel.getAvailableRooms());
                        }
                    } else {
                        System.out.println("No available hotels yet:)");
                        continue;
                    }
                    System.out.print("Click 0 to go back: ");
                    int exit = input.nextInt();
                    input.nextLine();
                    if (exit == 0){
                        break;
                    }
                    }
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }
}
