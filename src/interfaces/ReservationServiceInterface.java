package src.interfaces;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import src.models.Hotel;
import src.models.Reservation;

public interface ReservationServiceInterface {
    void bookARoom(UUID userId, String hotelName, HashMap<String, Hotel> hotels, List<Reservation> reservation, int nights);
    void cancelReservation(UUID userId, String hotelName, HashMap<String, Hotel> hotels, List<Reservation> reservation);
    void reservationHistory(UUID userId, HashMap<String, Hotel> hotels, List<Reservation> reservation);
}
