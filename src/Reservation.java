import java.io.Serializable;

/**
 * class that represents a customer's reservation
 * at specific dates
 */

public class Reservation implements Serializable {
    private final String customerName;
    private final Date checkIn;
    private final Date checkOut;
    private final Building building;

    /**
     * constructor that gets as parameters customer's name ,arrival date,departure date and type of building
     * @param customerName customer's name
     * @param checkIn arrival date
     * @param checkOut departure date
     * @param building type of building(either accommodation or hotelRoom)
     */
    public Reservation(String customerName, Date checkIn, Date checkOut, Building building){
        this.building=building;
        this.customerName=customerName;
        this.checkIn=checkIn;
        this.checkOut=checkOut;
    }



    /**
     * method that gets customer's name
     * @return name
     */

    public String getCustomerName() {
        return customerName;
    }

    /**
     * method that gets customer's arrival date
     * @return arrivate date
     */

    public Date getCheckIn() {
        return checkIn;
    }

    /**
     * method that gets building
     * @return building
     */

    public Building getBuilding() {
        return building;
    }

    /**
     * method that gets customer's departure date
     * @return departure date
     */

    public Date getCheckOut() {
        return checkOut;
    }


}
