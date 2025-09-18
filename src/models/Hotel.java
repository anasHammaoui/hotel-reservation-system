package src.models;

import java.util.UUID;

public class Hotel {
    private UUID id;
    private String name;
    private int availableRooms;
    private double rating;

    public Hotel(String name, int availableRooms, double rating){
        this.id = UUID.randomUUID();
        this.name = name;
        this.availableRooms = availableRooms;
        this.rating = rating;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAvailableRooms() {
        return availableRooms;
    }

    public void setAvailableRooms(int availableRooms) {
        this.availableRooms = availableRooms;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }
}
