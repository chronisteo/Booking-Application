import java.io.Serializable;

/**
 * This class represents a maisonette.
 * Extends from DetachedHouse
 */

public class Maisonette extends DetachedHouse implements Serializable {

    /**
     * This constructor initializes the maisonette with the given parameters.
     *
     * @param providerName the name of the guy owning the apartment
     * @param name the name of the apartment
     * @param m2 the square metres of the apartment
     * @param price the price per night of the apartment
     * @param wifi boolean that shows if wifi is included
     * @param parking boolean that shows if parking is included
     * @param airConditioning boolean that shows if air conditioning is included
     * @param garden boolean that shows if the house has garden
     */
    public Maisonette(String location, String providerName, String name, int m2, int price, boolean wifi, boolean parking, boolean airConditioning, boolean garden){
        super(location,providerName,name,m2, price, wifi, parking, airConditioning,garden);

    }

}

