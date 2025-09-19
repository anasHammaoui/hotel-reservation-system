package src.services;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import src.interfaces.ReservationServiceInterface;
import src.models.Hotel;
import src.models.Reservation;

public class ReservationService implements ReservationServiceInterface {
    public void bookARoom(UUID userId, String hotelName, HashMap<String, Hotel> hotels, List<Reservation> reservations, int nights){
        if(hotels.get(hotelName).getAvailableRooms() > 0){
            Reservation reservation = new Reservation(hotels.get(hotelName).getId(), nights);
            reservations.add(reservation);
            hotels.get(hotelName).setAvailableRooms(hotels.get(hotelName).getAvailableRooms() - 1);
            System.out.println("Room reserveed with success");
        } else{
            throw new IllegalArgumentException("No available rooms found!");
        }
    }
    public void cancelReservation(UUID userId, String hotelName, HashMap<String, Hotel> hotels, List<Reservation> reservation){

    }
    public void reservationHistory(UUID userId, HashMap<String, Hotel> hotels, List<Reservation> reservation){

    }
}
