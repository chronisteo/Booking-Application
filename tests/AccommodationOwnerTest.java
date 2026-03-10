import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class AccommodationOwnerTest {


    @Test
    public void getAccommodations() {
        AccommodationOwner owner=new AccommodationOwner("petros","12345","Petros Papas","Aigaiou 81");

        Villa villa=new Villa("Panorama","Petros Papas","Villa1",234,213,true,true,true,true,true);
        Maisonette maisonette=new Maisonette("Lagyna","Petros Papas","Maisonette1",234,243,true,true,true,true);
        Apartment apartment=new Apartment("Panorama","Petros Papaps","Apartment1",56,54,true,true,true,5);

        owner.addAccommodation(villa);
        owner.addAccommodation(maisonette);
        owner.addAccommodation(apartment);

        assertNotEquals(null,owner.getAccommodations());
        assertEquals(villa,owner.getAccommodations().get(0));
        assertEquals(maisonette,owner.getAccommodations().get(1));
        assertEquals(apartment,owner.getAccommodations().get(2));

        assertEquals(3,owner.getAccommodations().size());


    }

    @Test
    public void addAccommodation() {
        AccommodationOwner owner=new AccommodationOwner("petros","12345","Petros Papas","Aigaiou 81");

        Villa villa=new Villa("Panorama","Petros Papas","Villa1",234,213,true,true,true,true,true);
        Maisonette maisonette=new Maisonette("Lagyna","Petros Papas","Maisonette1",234,243,true,true,true,true);
        Apartment apartment=new Apartment("Panorama","Petros Papas","Apartment1",56,54,true,true,true,5);

        owner.addAccommodation(villa);
        owner.addAccommodation(maisonette);
        owner.addAccommodation(apartment);

        Apartment apartment1=new Apartment("Panorama","Petros Papas","Apartment2",32,414,true,false,false,4);
        owner.addAccommodation(apartment1);

        assertEquals(4,owner.getAccommodations().size());
    }

    @Test
    public void removeAccommodation() {

        AccommodationOwner accommodationOwner = new AccommodationOwner("thodoris_chronis", "tsoumakas1926", "Thodoris Chronis", "Aigaiou 26");

        Apartment apartment = new Apartment("Lagyna", "Thodoris Chronis", "Chronis Apartment", 230, 1000, true, true, true, 7);
        Villa villa = new Villa("Panorama", "Thodoris Chronis", "Chronis Villa", 450, 2000, true, true, true, true, false);
        Villa villa2 =new Villa("Panorama", "Thodoris Chronis", "Chronis Villa2", 500, 2100, true, true, true, true, false);

        accommodationOwner.addAccommodation(apartment);
        accommodationOwner.addAccommodation(villa);
        accommodationOwner.addAccommodation(villa2);

        Customer customer = new Customer("vaggelis", "skotos13", "Vaggelis Dimos", "Agiou Dimitriou 2");

        ArrayList<User> users = new ArrayList<>();

        users.add(accommodationOwner);
        users.add(customer);

        customer.makeReservation(new Date(12,5,2021),new Date(14,5,2021),apartment,users);

        accommodationOwner.removeAccommodation(apartment,users);

        assertEquals(2,accommodationOwner.getAccommodations().size());
        assertEquals(0,customer.getReservations().size());
        assertEquals(1,customer.getCancellations().size());

    }

}