import java.io.Serializable;
import java.util.ArrayList;

/**
 * class that represents a HotelOwner(subclass of Provider)
 * a hotelOwner is able to add hotels and hotelRooms
 * with specific benefits
 */

public class HotelOwner extends Provider implements Serializable {

    private final ArrayList<Hotel> hotels;

    /**
     * constructor that gets as parameters hotelOwner's username,password,FullName and address
     * @param username hotelOwner's username
     * @param password hotelOwner's password
     * @param full_name hotelOwner's FullName
     * @param address hotelOwner's address
     */

    public HotelOwner(String username, String password, String full_name, String address){
        super(username,password,full_name,address);
        hotels=new ArrayList<>();
    }

    /**
     * getter for arraylist of hotels
     * @return arraylist of hotels
     */

    public ArrayList<Hotel> getHotels(){
        return hotels;
    }

    /**
     * method that adds a hotel to hotelOwner's hotels
     * @param hotel specific hotel to add
     */

    public void addHotel(Hotel hotel){
        hotels.add(hotel);
    }

    /**
     * method that removes a hotel from hotelOwner's hotels and simultaneously removes the all the reservations made in this hotel
     * @param hotel specific hotel to remove
     * @param users all users
     */

    public void removeHotel(Hotel hotel, ArrayList<User> users){

        ArrayList<Reservation> toRemove1=new ArrayList<>();
        ArrayList<Reservation> toAdd1=new ArrayList<>();

        for(Reservation reservation:getProviderReservations()){
            if(hotel.getName().equals(reservation.getBuilding().getName())){
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
                    if (hotel.getName().equals(reservation.getBuilding().getName())) {
                        toRemove2.add(reservation);
                        toAdd2.add(reservation);
                    }

                }
                ((Customer) user).getReservations().removeAll(toRemove2);
                ((Customer) user).getCancellations().addAll(toAdd2);
            }

        }

        hotels.remove(hotel);
    }

}
