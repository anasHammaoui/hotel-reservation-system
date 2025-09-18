package src.services;

import java.util.HashMap;
import src.models.Hotel;

public class HotelService {

    public boolean createHotel(HashMap<String, Hotel> hotels ,String name, int availableRooms, double rating){
        if (hotels.containsKey(name)){
            return false;
        }
            Hotel hotel = new Hotel(name, availableRooms, rating);
            hotels.put(name,hotel);
            return true;
    }

    public HashMap<String, Hotel> listHotels(HashMap<String, Hotel> hotels, boolean filter){
        if (!filter) {
            return hotels;
        }
        HashMap<String, Hotel> availableHotels = new HashMap<>();
        for (Hotel hotel: hotels.values()){
            if (hotel.getAvailableRooms() > 0){
                availableHotels.put(hotel.getName(), hotel);
            }
        }
        return availableHotels;
    }
    
}