import java.io.Serializable;

/**
 * This class represents a detached house.
 * Extends from Accommodation
 */
public class DetachedHouse extends Accommodation implements Serializable {
    private boolean garden;

    /**
     * This constructor initializes the detached house with the given parameters.
     *
     * @param location the location of the DetachedHouse
     * @param providerName the name of the guy owning the apartment
     * @param name the name of the apartment
     * @param m2 the square metres of the apartment
     * @param price the price per night of the apartment
     * @param wifi boolean that shows if wifi is included
     * @param parking boolean that shows if parking is included
     * @param airConditioning boolean that shows if air conditioning is included
     * @param garden boolean that shows if the house has garden
     */
    public DetachedHouse(String location, String providerName, String name, int m2, int price, boolean wifi, boolean parking, boolean airConditioning, boolean garden){
        super(location,providerName,name,m2, price, wifi, parking, airConditioning);
        this.garden=garden;
    }

    /**
     * This method updates the garden of the detached house.
     * @param garden the garden to be set
     */
    public void setGarden(boolean garden){
        this.garden=garden;
    }

    /**
     * @return true or false according to detached houses garden
     */
    public boolean getGarden(){
        return this.garden;
    }

}