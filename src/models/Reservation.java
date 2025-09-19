package src.models;
import java.sql.Timestamp;
import java.util.UUID;

public class Reservation {
    private UUID id;
    private Timestamp instant;
    private UUID hotelId;
    private UUID clientId;
    private int nights;
    
    public Reservation( UUID hotelId, int nights ){
        this.id = UUID.randomUUID();
        this.instant = new Timestamp(System.currentTimeMillis());
        this.hotelId = hotelId;
        this.nights = nights;
    }
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Timestamp getInstant() {
        return instant;
    }

    public void setInstant(Timestamp instant) {
        this.instant = instant;
    }

    public UUID getHotelId() {
        return hotelId;
    }

    public void setHotelId(UUID hotelId) {
        this.hotelId = hotelId;
    }

    public UUID getClientId() {
        return clientId;
    }

    public void setClientId(UUID clientId) {
        this.clientId = clientId;
    }

    public int getNights() {
        return nights;
    }

    public void setNights(int nights) {
        this.nights = nights;
    }
}
