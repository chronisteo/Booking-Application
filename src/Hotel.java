import java.io.Serializable;
import java.util.ArrayList;

/**
 * This class represents a Hotel,with all its services and the hotel rooms it contains
 */

public class Hotel implements Serializable {
    private String name;
    private String location;
    private final boolean breakfast;
    private final boolean pool;
    private boolean wifi;
    private boolean parking;
    private final boolean airConditioning;
    private final ArrayList<HotelRoom> hotelRooms;

    /**
     * This constructor initializes the hotel with the given parameters.
     * It also creates an arraylist with all the hotel rooms it has.
     *
     * @param location the location of the hotel
     * @param name The name of the hotel
     * @param breakfast boolean if it includes breakfast or not
     * @param pool boolean if it has pool or not
     * @param wifi boolean if it has Wi-fi or not
     * @param parking boolean if it has parking or not
     * @param airConditioning boolean if it has air conditioning or not
     */
    public Hotel(String location, String name, boolean breakfast, boolean pool, boolean wifi, boolean parking, boolean airConditioning){
        this.location=location;
        hotelRooms=new ArrayList<>();
        this.name=name;
        this.breakfast=breakfast;
        this.pool=pool;
        this.wifi=wifi;
        this.parking=parking;
        this.airConditioning=airConditioning;
    }

    /**
     * This method updates the location of the hotel
     * @param location the location of the hotel
     */

    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * This method updates the name of the hotel
     * @param name the name of the hotel to be set
     */
    public void setName(String name){
        this.name=name;
    }


    /**
     * This method updates the hotel's Wi-fi
     * @param wifi the Wi-fi to be set
     */
    public void setWifi(boolean wifi){
        this.wifi=wifi;
    }

    /**
     * This method updates the hotel's parking
     * @param parking the parking to be set
     */
    public void setParking(boolean parking){
        this.parking=parking;
    }


    /**
     * @return the location of the hotel
     */

    public String getLocation() {
        return location;
    }

    /**
     * @return the name of the hotel
     */
    public String getName(){
        return this.name;
    }

    /**
     * @return true of false according to the hotel's breakfast
     */
    public boolean getBreakfast(){
        return this.breakfast;
    }

    /**
     * @return true or false according to the hotel's pool
     */
    public boolean getPool(){
        return this.pool;
    }

    /**
     * @return true or false according to the hotel's Wi-fi
     */
    public boolean getWifi(){
        return this.wifi;
    }

    /**
     * @return true or false according to the hotel's parking
     */
    public boolean getParking(){
        return this.parking;
    }

    /**
     * @return true or false according to the hotel's air conditioning
     */
    public boolean getAirConditioning(){
        return this.airConditioning;
    }

    /**
     * @return all the hotel rooms the hotel has
     */
    public ArrayList<HotelRoom> getHotelRooms(){
        return hotelRooms;
    }

    /**
     * This method adds a hotel room to the specific hotel
     * @param hotelRoom the hotel room to be added
     */
    public void addHotelRoom(HotelRoom hotelRoom){
        hotelRooms.add(hotelRoom);
    }

}
