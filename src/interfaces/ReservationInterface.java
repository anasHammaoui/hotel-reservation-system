package src.interfaces;

import java.util.List;
import java.util.UUID;

import src.models.Reservation;

public interface ReservationInterface {
    void bookARoom(UUID userId, String hotelName, List<Reservation> reservation, int nights);
    void cancelReservation(UUID userId, String hotelName, List<Reservation> reservation);
    void reservationHistory(UUID userId, List<Reservation> reservation);
}
