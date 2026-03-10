import java.io.Serializable;
import java.util.ArrayList;


/**
 * class that represents a customer ,
 * subclass of User
 * customer is able to search through accommodations and hotels
 * and make either a reservation or a cancellation
 * also,customer is able to receive messages from admin users
 */

public class Customer extends User implements Serializable {
    private final ArrayList<Reservation> reservations;
    private final ArrayList<Reservation> cancellations;
    private String address;
    private final ArrayList<Message> inbox;

    /**
     * constructor that gets as parameters,the username,the password,the FullName
     * and the address of the customer
     * @param username username of customer
     * @param password password of customer
     * @param full_name FullName of customer
     * @param address address of customer
     */

    public Customer(String username, String password, String full_name, String address){
        super(username, password, full_name);
        this.address=address;
        reservations=new ArrayList<>();
        cancellations=new ArrayList<>();
        inbox=new ArrayList<>();
    }

    /**
     * setter method for customer's address
     * @param address customer's address
     */

    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * method to get the arraylist of reservations
     * @return arraylist of reservations
     */

    public ArrayList<Reservation> getReservations(){
        return reservations;
    }

    /**
     * method to get the arraylist of cancellations
     * @return arraylist of cancellations
     */

    public ArrayList<Reservation> getCancellations(){
        return  cancellations;
    }

    /**
     * method to get customer's address
     * @return customer's address
     */

    public String getAddress(){
        return address;
    }

    /**
     * method to get customer's address
     * @return customer's inbox
     */

    public ArrayList<Message> getInbox(){
        return inbox;
    }

    /**
     * method to add a new message to customer's inbox
     * @param message the new message from admin
     */

    public void addMessage(Message message){
        inbox.add(message);
    }



    /**
     * this method helps customer to make a reservation
     * this method also add the reservation to the reservation's arraylist of the specific provider and the reservation's arraylist of the specific customer
     * @param d1 arrival date
     * @param d2 departure date
     * @param building specific accommodation or hotelRoom
     * @param users all users
     */

    public void makeReservation(Date d1, Date d2, Building building, ArrayList<User> users){

        Reservation r1=new Reservation(this.getFull_name(),d1,d2,building);
        reservations.add(r1);
        building.getReservationDates().add(d1);
        building.getReservationDates().add(d2);
        for(User user:users){
            if(user instanceof Provider)
                if(user.getFull_name().equals(building.getProviderName()))
                    ((Provider) user).addReservation(r1);
        }

    }

    /**
     * this method helps customer to make a cancellation
     * this method also add the reservation to the cancellation's arraylist of the specific provider and the cancellation's arraylist of the specific customer
     * @param users all users
     */

    public void makeCancellation(ArrayList<User> users,int choice){

        cancellations.add(reservations.get(choice));



        reservations.get(choice).getBuilding().getReservationDates().remove(reservations.get(choice).getCheckIn());
        reservations.get(choice).getBuilding().getReservationDates().remove(reservations.get(choice).getCheckOut());

        for(User user:users){
            if(user instanceof Provider)
                if(user.getFull_name().equals(reservations.get(choice).getBuilding().getProviderName())) {
                    ((Provider) user).addCancellation(reservations.get(choice));
                    ((Provider) user).getProviderReservations().remove(reservations.get(choice));
                }
        }
        reservations.remove(reservations.get(choice));

    }


}
