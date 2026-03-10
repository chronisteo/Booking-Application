import java.io.Serializable;
import java.util.ArrayList;

/**
 * This class represents an AccommodationOwner,
 * subclass of Provider
 * AccommodationOwner is able to register and login to the booking-app,
 * and add accommodations for short or long term booking
 */

public class AccommodationOwner extends Provider implements Serializable {

    private final ArrayList<Accommodation> accommodations;

    /**
     * constructor that gets as parameters,the username of the AccommodationOwner,
     * the password,the FullName and the address
     * @param username username of AccommodationOwner
     * @param password password of AccommodationOwner
     * @param full_name FullName of AccommodationOwner
     * @param address address of AccommodationOwner
     */

    public AccommodationOwner(String username, String password, String full_name, String address){
        super(username,password,full_name,address);
        accommodations=new ArrayList<>();
    }

    /**
     * getter for accommodations
     * @return Arraylist of accommodations
     */

    public ArrayList<Accommodation> getAccommodations(){
        return accommodations;
    }

    /**
     * method to add one accommodation to arraylist of accommodations
     * @param accommodation the accommodation to add
     */

    public void addAccommodation(Accommodation accommodation){
        accommodations.add(accommodation);
    }

    /**
     * method that removes one accommodation from arraylist of accommodations
     * @param accommodation the accommodation to remove
     * @param users all registered users
     */

    public void removeAccommodation(Accommodation accommodation, ArrayList<User> users){

        ArrayList<Reservation> toRemove1=new ArrayList<>();
        ArrayList<Reservation> toAdd1=new ArrayList<>();

        for(Reservation reservation:getProviderReservations()){
            if(accommodation.getName().equals(reservation.getBuilding().getName())){
                toRemove1.add(reservation);
                toAdd1.add(reservation);
            }

        }

        getProviderReservations().removeAll(toRemove1);
        getProviderCancellations().addAll(toAdd1);

        ArrayList<Reservation> toRemove2=new ArrayList<>();
        ArrayList<Reservation> toAdd2=new ArrayList<>();

        for(User user:users){
            if(user instanceof Customer){
                for(Reservation reservation: ((Customer) user).getReservations()) {
                    if (accommodation.getName().equals(reservation.getBuilding().getName())) {
                        toRemove2.add(reservation);
                        toAdd2.add(reservation);
                    }

                }
                ((Customer) user).getReservations().removeAll(toRemove2);
                ((Customer) user).getCancellations().addAll(toAdd2);
            }

        }

        accommodations.remove(accommodation);
    }


}
