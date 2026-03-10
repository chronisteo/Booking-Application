import java.io.Serializable;

/**
 * This class represents an apartment.
 */

public class Apartment extends Accommodation implements Serializable {
    private int floor;

    /**
     * This constructor initializes the apartment with the given parameters.
     *
     * @param location the location of the apartment
     * @param providerName the name of the guy owning the apartment
     * @param name the name of the apartment
     * @param m2 the square metres of the apartment
     * @param price the price per night of the apartment
     * @param wifi boolean that shows if wifi is included
     * @param parking boolean that shows if parking is included
     * @param airConditioning boolean that shows if air conditioning is included
     * @param floor the number of the floor where the apartment is
     */
    public Apartment(String location, String providerName, String name, int m2, int price, boolean wifi, boolean parking, boolean airConditioning, int floor){
        super(location,providerName,name,m2, price,  wifi, parking, airConditioning);
        this.floor=floor;
    }

    /**
     * This method updates the floor where the apartment is.
     * @param floor the floor to be set
     */
    public void setFloor(int floor){
        this.floor=floor;
    }

    /**
     * @return the number of floor where the apartment is
     */
    public int getFloor() {
        return floor;
    }

}
