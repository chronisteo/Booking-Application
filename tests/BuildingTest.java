import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class BuildingTest {


    @Test
    public void setName() {
        Accommodation accommodation=new Accommodation("Thessaloniki","George Papas","newAccom",32,13,true,true,true);
        accommodation.setName("newAccom2");
        assertEquals("newAccom2",accommodation.getName());
    }

    @Test
    public void setM2() {
        Accommodation accommodation=new Accommodation("Thessaloniki","George Papas","newAccom",32,13,true,true,true);
        accommodation.setM2(324);
        assertEquals(324,accommodation.getM2());
    }

    @Test
    public void setPrice() {
        Accommodation accommodation=new Accommodation("Thessaloniki","George Papas","newAccom",32,13,true,true,true);
        accommodation.setPrice(32);
        assertEquals(32,accommodation.getPrice());
    }

    @Test
    public void getName() {
        Accommodation accommodation=new Accommodation("Thessaloniki","George Papas","newAccom",32,13,true,true,true);
        assertEquals("newAccom",accommodation.getName());
    }

    @Test
    public void getM2() {
        Accommodation accommodation=new Accommodation("Thessaloniki","George Papas","newAccom",32,13,true,true,true);
        assertEquals(32,accommodation.getM2());
    }

    @Test
    public void getPrice() {
        Accommodation accommodation=new Accommodation("Thessaloniki","George Papas","newAccom",32,13,true,true,true);
        assertEquals(13,accommodation.getPrice());
    }

    @Test
    public void getReservationDates() {
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
        assertEquals(2,accommodationOwner.getAccommodations().get(0).getReservationDates().size());

        customer.makeCancellation(users,0);
        assertEquals(0,accommodationOwner.getAccommodations().get(0).getReservationDates().size());

    }

    @Test
    public void getProviderName() {
        Accommodation accommodation=new Accommodation("Thessaloniki","George Papas","newAccom",32,13,true,true,true);
        assertEquals("George Papas",accommodation.getProviderName());
    }

    @Test
    public void isReserved() {

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
        assertTrue(accommodationOwner.getAccommodations().get(0).isReserved(new Date(12,5,2021),new Date(14,5,2021)));
        customer.makeCancellation(users,0);
        assertFalse(accommodationOwner.getAccommodations().get(0).isReserved(new Date(12,5,2021),new Date(14,5,2021)));

    }

}