package src.repositories;

import java.util.HashMap;
import java.util.UUID;

import src.interfaces.HotelInterface;
import src.models.Hotel;
import src.services.HotelService;

public class HotelRepository implements HotelInterface {
    private HashMap<String,Hotel> hotels = new HashMap<>();
    private HotelService hotelService = new HotelService();
    AuthRepository user;
    public HotelRepository(AuthRepository user){
        this.user = user;
    }
    @Override
    public boolean createHotel(String name, int availableRooms, double rating){
        if (user.isLogedIn()){
            return hotelService.createHotel(hotels, name, availableRooms, rating);
        }
        return false;
    }

    @Override
    public HashMap<String, Hotel> listHotels(boolean filter){
        if (user.isLogedIn()){
        return hotelService.listHotels(hotels, filter);
        }
        return null;
    }

    @Override
    public boolean updateHotel(UUID id,String name, int availableRooms, double rating){
        if (user.isLogedIn()){
        return hotelService.updateHotel(hotels, id, name, availableRooms, rating);
        }
        return false;
    }

    @Override
    public boolean deleteHotel(UUID id){
        if (user.isLogedIn()){
         return hotelService.deleteHotel(hotels,id);
         }
        return false;
    }
}
