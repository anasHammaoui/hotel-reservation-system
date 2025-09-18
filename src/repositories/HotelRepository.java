package src.repositories;

import java.util.HashMap;
import java.util.UUID;

import src.interfaces.HotelInterface;
import src.models.Hotel;
import src.services.HotelService;

public class HotelRepository implements HotelInterface {
    private HashMap<String,Hotel> hotels = new HashMap<>();
    private HotelService hotelService = new HotelService();

    @Override
    public boolean createHotel(String name, int availableRooms, double rating){
       return hotelService.createHotel(hotels, name, availableRooms, rating);
    }

    @Override
    public HashMap<String, Hotel> listHotels(boolean filter){
        return hotelService.listHotels(hotels, filter);
    }

    @Override
    public boolean updateHotel(UUID id,String name, int availableRooms, double rating){
        return hotelService.updateHotel(hotels, id, name, availableRooms, rating);
    }

    @Override
    public boolean deleteHotel(UUID id){

    }
}
