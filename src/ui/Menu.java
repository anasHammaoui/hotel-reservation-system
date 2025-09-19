package src.ui;

import java.util.HashMap;
import java.util.Scanner;
import java.util.UUID;

import src.interfaces.ReservationInterface;
import src.models.Hotel;
import src.repositories.AuthRepository;
import src.repositories.HotelRepository;

public class Menu {

    private AuthRepository auth;
    private HotelRepository hotels;
    private ReservationInterface reservations;

    public Menu(AuthRepository auth, HotelRepository hotels,ReservationInterface reservations){
        this.auth = auth;
        this.hotels = hotels;
        this.reservations = reservations;
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
                    this.reservationMangement(input,reservations, auth);
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
                    if (hotels.createHotel(name, availableRooms, rating)){
                        System.out.println("Hotel created with success");
                    } else {
                        System.out.println("Failed to create hotel");
                    }
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
                        System.out.println("Hotel Id: "+hotel.getId());
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
                case 3:
                    System.out.print("Enter hotel Id: ");
                    UUID id = UUID.fromString(input.nextLine());
                    System.out.print("Enter new name: ");
                    String newName = input.nextLine();
                    System.out.print("Enter available rooms: ");
                    int newAvRooms = input.nextInt();
                    System.out.print("Enter new rating: ");
                    double newRating = input.nextDouble();
                    input.nextLine();
                    if (hotels.updateHotel(id, newName, newAvRooms, newRating)){
                        System.out.println("Hotel updated with success");
                    } else {
                        System.out.println("Failed to update, check if hotel exists");
                    }
                break;
                case 4:
                    System.out.print("Enter hotel Id: ");
                    UUID hotelId = UUID.fromString(input.nextLine());
                    if (hotels.deleteHotel(hotelId)){
                        System.out.println("Hotel deleted with success");
                    } else {
                        System.out.println("Failed to delete, check if hotel exists");
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
    public void reservationMangement(Scanner input, ReservationInterface reservations, AuthRepository auth){
                System.out.println("*****Reservation Management******");
        String menu = """
                1)Book a room
                2)Cancel reservation
                3)See reservation history
                0)Exit""";
        
        int choice;
        while(true){
            System.out.println(menu);
            choice = input.nextInt();
            input.nextLine();
            switch (choice) {
                case 1:
                    System.out.print("Enter hotel name: ");
                    String name = input.nextLine();
                    System.out.print("Enter nights: ");
                    int nights = input.nextInt();
                    input.nextLine();
                    try{
                        reservations.bookARoom(auth.getId(), name, nights);
                    } catch (IllegalArgumentException e){
                        System.err.println(e.getMessage());
                    }
                    break;
                case 2:
                    break;
                case 3:
                break;
                case 4:
                    // System.out.print("Enter hotel Id: ");
                    // UUID hotelId = UUID.fromString(input.nextLine());
                    // if (hotels.deleteHotel(hotelId)){
                    //     System.out.println("Hotel deleted with success");
                    // } else {
                    //     System.out.println("Failed to delete, check if hotel exists");
                    // }
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
