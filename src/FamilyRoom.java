import java.io.Serializable;

/**
 * This class represents a double room,that specifies a category of the hotel room.
 * Extends from HotelRoom
 */
public class FamilyRoom extends HotelRoom implements Serializable {
    /**
     * This constructor initializes the family room with the given parameters
     *
     * @param providerName The name of the guy owning the building
     * @param hotelName The name of the building
     * @param m2 The square metres of the building
     * @param price The price for 1 night
     * @param nonSmoking boolean that shows if smoking is forbidden in the room
     * @param balcony boolean that shows if the room has balcony
     * @param tv boolean that shows if the room has tv
     */
    public FamilyRoom(String providerName, String hotelName, int m2, int price, boolean nonSmoking, boolean balcony, boolean tv){
        super(providerName,hotelName,m2,price,nonSmoking,balcony,tv);
    }

}
