import java.io.Serializable;
import java.util.ArrayList;

/**
 * This class represents a building for renting with some valuable info.
 */

public class Building implements Serializable {


    private final String  providerName;
    private String name;
    private int m2;
    private int price;

    private final ArrayList<Date> reservationDates;

    /**
     * This constructor initializes a building with the given parameters.
     * It creates an arraylist of reservation Dates for the specific building.
     *
     * @param providerName The name of the guy owning the building
     * @param name The name of the building
     * @param m2 The square metres of the building
     * @param price The price for 1 night
     */
    public Building(String providerName, String name, int m2, int price){
        this.providerName=providerName;
        this.name=name;
        this.m2=m2;
        this.price=price;
        reservationDates=new ArrayList<>();
    }

    /**
     * This method updates the building's name.
     *
     * @param name building's name
     */
    public void setName(String name){
        this.name=name;
    }

    /**
     * This method updates the square metres of the building.
     *
     * @param m2 m2
     */
    public void setM2(int m2) {
        this.m2=m2;
    }

    /**
     * This method updates the price of the building.
     *
     * @param price price
     */
    public void setPrice(int price) {
        this.price=price;
    }

    /**
     *
     * @return the name of the building
     */
    public String getName(){
        return name;
    }

    /**
     *
     * @return the square metres of the building.
     */
    public int getM2(){
        return  this.m2;
    }

    /**
     *
     * @return the price of the building
     */
    public int getPrice(){
        return this.price;
    }

    /**
     *
     * @return an arraylist with the reserved dates.
     */
    public ArrayList<Date> getReservationDates(){
        return  reservationDates;
    }

    /**
     *
     * @return the provider's name.
     */
    public String getProviderName() {
        return providerName;
    }

    /**
     * This method checks if the period between the given dates as parameters is available or reserved.
     *
     * @param d1 the checkIn date
     * @param d2 the checkOut date
     * @return true or false depending on the given dates and the fact that they are reserved or not
     */
    public boolean isReserved(Date d1, Date d2){
        for(int i=0;i<reservationDates.size();){
            if(d1.moreThan(reservationDates.get(i)) && d2.lessThan(reservationDates.get(i+1)))
                return true;
            else if(d1.lessThan(reservationDates.get(i)) && d2.moreThan(reservationDates.get(i+1)))
                return true;
            else if(d1.moreThan(reservationDates.get(i)) && d1.lessThan(reservationDates.get(i+1)) && d2.moreThan(reservationDates.get(i+1)))
                return true;
            else if(d1.lessThan(reservationDates.get(i)) && d2.moreThan(reservationDates.get(i)) && d2.lessThan(reservationDates.get(i+1)))
                return true;
            if(d1.isEquals(reservationDates.get(i)) || d1.isEquals(reservationDates.get(i+1)) || d2.isEquals(reservationDates.get(i)) || d2.isEquals(reservationDates.get(i+1)))
                return true;
            i+=2;
        }
        return false;
    }

}
