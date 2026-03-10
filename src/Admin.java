import java.io.Serializable;

/**
 * class(that extends from User) that represents an admin of a booking-system
 * an admin is able to accept Providers and Customers,send messages to Providers and Customers
 * and view reservations
 */

public class Admin extends User implements Serializable {
    private  String address;
    /**
     * constructor that gets as parameters,the username of the Admin,
     * the password,the FullName and the address
     * @param username the username of Admin
     * @param password the password of Admin
     * @param full_name the FullName of Admin
     * @param address the address of Admin
     */

    public Admin(String username, String password, String full_name, String address){
        super(username, password, full_name);
        this.address=address;
    }

    /**
     * method that sets address of admin
     * @param address admin's new address
     */

    public void setAddress(String address){
        this.address=address;
    }

    /**
     * method that returns admin's address
     * @return admin's address
     */

    public String getAddress() {
        return address;
    }

}
