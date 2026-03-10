import java.io.Serializable;

/**
 * This class represents a villa.
 * Extends from DetachedHouse
 */
public class Villa extends DetachedHouse implements Serializable {

    private boolean pool;

    /**
     * This constructor initializes a villa with the given parameters.
     *
     * @param location the location of the villa
     * @param providerName the name of the guy owning the apartment
     * @param name the name of the apartment
     * @param m2 the square metres of the apartment
     * @param price the price per night of the apartment
     * @param wifi boolean that shows if wi-fi is included
     * @param parking boolean that shows if parking is included
     * @param airConditioning boolean that shows if air conditioning is included
     * @param garden boolean that shows if the house has garden
     * @param pool boolean that shows if the house has pool
     */
    public Villa(String location, String providerName, String name, int m2, int price, boolean wifi, boolean parking, boolean airConditioning, boolean garden, boolean pool){
        super(location,providerName,name,m2, price,wifi, parking, airConditioning,garden);
        this.pool=pool;
    }

    /**
     * This method updates the villa's pool.
     *
     * @param pool the pool to be set
     */
    public void setPool(boolean pool){
        this.pool=pool;
    }

    /**
     * @return true of false according to villa's pool
     */
    public boolean getPool(){
        return this.pool;
    }


}