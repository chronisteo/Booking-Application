import java.io.Serializable;

/**
 * This class represents a hotel room from an existing hotel.
 */

public class HotelRoom extends Building implements Serializable {
    private final boolean nonSmoking;
    private final boolean balcony;
    private final boolean tv;
    private int number;
    /**
     * This constructor initializes the hotel room with the given parameters
     * @param providerName The name of the guy owning the building
     * @param name The name of the building
     * @param m2 The square metres of the building
     * @param price The price for 1 night
     * @param nonSmoking boolean that shows if smoking is forbidden in the room
     * @param balcony boolean that shows if the room has balcony
     * @param tv boolean that shows if the room has tv
     */

    public HotelRoom(String providerName, String name, int m2, int price, boolean nonSmoking, boolean balcony, boolean tv){
        super(providerName,name,m2,price);
        this.nonSmoking=nonSmoking;
        this.balcony=balcony;
        this.tv=tv;
        number=0;
    }



    /**
     *
     * @param number
     * Sets the serial number of room
     */
    public void setNumber(int number){
        this.number=number;
    }
    /**
     *
     * @return true or false according to the nonSmoking of the room
     */
    public boolean getNonSmoking(){
        return this.nonSmoking;
    }

    /**
     *
     * @return true of false according to the room's balcony
     */
    public boolean getBalcony(){
        return this.balcony;
    }

    /**
     *
     * @return true or false according to the room's tv
     */
    public boolean getTv(){
        return this.tv;
    }

    /**
     *
     * @return room's number
     */
    public int getNumber(){
        return number;
    }


}