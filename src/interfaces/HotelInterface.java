package src.interfaces;

import java.util.UUID;

import src.models.Hotel;

public interface HotelInterface {
    boolean createHotel(String name, int availableRooms, double rating);
    Hotel[] listHotels(boolean filter);
    boolean updateHotel(UUID id,String name, int availableRooms, double rating);
    boolean deleteHotel(UUID id);

}
