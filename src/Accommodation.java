import java.io.Serializable;

/**
 * This class represents a specific category of the building.
 * Accommodation is a subclass from Building.
 */

public class Accommodation extends Building implements Serializable {

    private String location;
    private boolean wifi;
    private boolean parking;
    private boolean airConditioning;

    /**
     * This constructor initializes an accommodation with the given parameters.
     *
     * @param location the location of the accommodation
     * @param providerName The name of the guy owning the building
     * @param name The name of the building
     * @param m2 The square metres of the building
     * @param price The price for 1 night
     * @param wifi boolean that shows if Wi-Fi is included
     * @param parking boolean that shows if parking is included
     * @param airConditioning boolean that shows if air conditioning is included
     */
    public Accommodation(String location, String providerName, String name, int m2, int price, boolean wifi, boolean parking, boolean airConditioning){
        super(providerName,name,m2,price);
        this.location=location;
        this.wifi=wifi;
        this.parking=parking;
        this.airConditioning=airConditioning;
    }


    /**
     * This method updates the Wi-Fi of the accommodation.
     *
     * @param wifi Wi-Fi to be set
     */
    public void setWifi(boolean wifi ) {
        this.wifi=wifi;
    }

    /**
     * This method updates the parking of the accommodation.
     *
     * @param parking parking to be set
     */
    public void setParking(boolean parking) {
        this.parking=parking;
    }

    /**
     * This method updates the air conditioning of the accommodation.
     *
     * @param airConditioning air conditioning to be set
     */
    public void setAirConditioning(boolean airConditioning) {
        this.airConditioning=airConditioning;
    }

    /**
     * This method updates the location of the accommodation.
     *
     * @param location location to be set
     */

    public void setLocation(String location){
        this.location=location;
    }
    /**
     * @return true or false according to accommodation's wifi.
     */
    public boolean getWifi(){
        return this.wifi;
    }

    /**
     * @return true or false according to accommodation's parking
     */
    public boolean getParking(){
        return  this.parking;
    }

    /**
     * @return true or false according to accommodation's air conditioning
     */
    public boolean getAirConditioning(){
        return this.airConditioning;
    }

    /**
     * @return accommodation's location
     */

    public  String getLocation(){
        return location;
    }


}
