import java.io.Serializable;
import java.util.ArrayList;

/**
 * class that represents a Provider(subclass of User)
 * a Provider is able to add/remove accommodations,hotelRooms which
 * depends on the kind of Provider he/she is(accommodations/AccommodationOwner,hotelRooms/HotelOwner).
 * also,a Provider receives messages from admin and is able to watch at his/hers accommodations/hotelRooms
 */

public class Provider extends User implements Serializable {

    private String address;
    private final ArrayList<Message> inbox;
    private final ArrayList<Reservation> providerReservations;
    private final ArrayList<Reservation> providerCancellations;


    /**
     * constructor that gets as parameters,username,password,FullName and address of Provider
     * @param username Provider's username
     * @param password Provider's password
     * @param full_name Provider's FullName
     * @param address Provider's address
     */

    public Provider(String username, String password, String full_name, String address){

        super(username, password,full_name);
        this.address=address;
        inbox=new ArrayList<>();
        providerReservations=new ArrayList<>();
        providerCancellations=new ArrayList<>();
    }

    /**
     * method that sets Provider's address
     * @param address address
     */

    public void setAddress(String address){
        this.address=address;
    }

    /**
     * method that gets arraylist of cancellations
     * @return cancellations
     */

    public ArrayList<Reservation> getProviderCancellations() {
        return providerCancellations;
    }

    /**
     * method that gets arraylist of reservations
     * @return reservations
     */

    public ArrayList<Reservation> getProviderReservations() {
        return providerReservations;
    }

    /**
     * method that gets arraylist of messages
     * @return inbox
     */

    public ArrayList<Message> getInbox(){
        return inbox;
    }

    /**
     * method that gets address
     * @return address
     */

    public String getAddress(){
        return address;
    }

    /**
     * method that adds a reservation to arraylist reservations
     * @param reservation reservation
     */

    public void addReservation(Reservation reservation){
        providerReservations.add(reservation);
    }


    /**
     * method that adds a reservation to arraylist cancellations
     * @param reservation reservation
     */

    public void addCancellation(Reservation reservation){
        providerCancellations.add(reservation);
    }

    /**
     * method that adds a reservation to arraylist inbox
     * @param message message
     */

    public void addMessage(Message message){
        inbox.add(message);
    }
}
