package src.repositories;

import java.util.List;
import java.util.UUID;

import src.interfaces.HotelInterface;
import src.interfaces.ReservationInterface;
import src.interfaces.ReservationServiceInterface;
import src.models.Reservation;

public class ReservationRepository implements ReservationInterface{
    private List<Reservation> reservations;
    private HotelInterface hotels;
    private ReservationServiceInterface reservationService;
    public ReservationRepository( HotelInterface hotels, ReservationServiceInterface reservationService){
        this.hotels = hotels;
        this.reservationService = reservationService;
    }
    public void bookARoom(UUID userId, String hotelName, List<Reservation> reservation, int nights){
    reservationService.bookARoom(userId, hotelName, hotels.getHotels(), reservations, nights);
    }
    public void cancelReservation(UUID userId, String hotelName, List<Reservation> reservation){

    }
    public void reservationHistory(UUID userId, List<Reservation> reservation){

    }
}
