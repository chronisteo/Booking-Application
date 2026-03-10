import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class ProviderTest {

    @Test
    public void setAddress() {
         Provider provider=new Provider("petros","12345p","Petros Kostopoulos","Aigaiou 88");
         provider.setAddress("Aigaiou 90");
         assertEquals("Aigaiou 90",provider.getAddress());
    }

    @Test
    public void getProviderCancellations() {

        AccommodationOwner owner=new AccommodationOwner("petros","12345","Petros Papas","Aigaiou 81");

        Villa villa=new Villa("Panorama","Petros Papas","Villa1",234,213,true,true,true,true,true);
        Maisonette maisonette=new Maisonette("Lagyna","Petros Papas","Maisonette1",234,243,true,true,true,true);
        Apartment apartment=new Apartment("Panorama","Petros Papaps","Apartment1",56,54,true,true,true,5);

        owner.addAccommodation(villa);
        owner.addAccommodation(maisonette);
        owner.addAccommodation(apartment);

        Customer customer=new Customer("kostas","1234","Kostas Nikolaou","Tsimiski 5");

        ArrayList<User> users=new ArrayList<>();
        users.add(owner);
        users.add(customer);

        customer.makeReservation(new Date(1,1,2021),new Date(3,4,2021),villa,users);
        assertEquals(0,owner.getProviderCancellations().size());

        customer.makeCancellation(users,0);
        assertEquals(1,owner.getProviderCancellations().size());
    }

    @Test
    public void getProviderReservations() {
        AccommodationOwner owner=new AccommodationOwner("petros","12345","Petros Papas","Aigaiou 81");

        Villa villa=new Villa("Panorama","Petros Papas","Villa1",234,213,true,true,true,true,true);
        Maisonette maisonette=new Maisonette("Lagyna","Petros Papas","Maisonette1",234,243,true,true,true,true);
        Apartment apartment=new Apartment("Panorama","Petros Papaps","Apartment1",56,54,true,true,true,5);

        owner.addAccommodation(villa);
        owner.addAccommodation(maisonette);
        owner.addAccommodation(apartment);

        Customer customer=new Customer("kostas","1234","Kostas Nikolaou","Tsimiski 5");

        ArrayList<User> users=new ArrayList<>();
        users.add(owner);
        users.add(customer);

        assertEquals(0,owner.getProviderReservations().size());

        customer.makeReservation(new Date(1,1,2021),new Date(3,4,2021),villa,users);
        assertEquals(1,owner.getProviderReservations().size());

        customer.makeCancellation(users,0);
        assertEquals(0,owner.getProviderReservations().size());

    }

    @Test
    public void getInbox() {
        Provider provider=new Provider("petros","12345p","Petros Kostopoulos","Aigaiou 88");
        assertEquals(0,provider.getInbox().size());
        provider.addMessage(new Message("Hello!"));
        assertEquals(1,provider.getInbox().size());
    }

    @Test
    public void getAddress() {
        Provider provider=new Provider("petros","12345p","Petros Kostopoulos","Aigaiou 88");
        assertEquals("Aigaiou 88",provider.getAddress());
    }

    @Test
    public void addReservation() {
        AccommodationOwner owner=new AccommodationOwner("petros","12345","Petros Papas","Aigaiou 81");

        Villa villa=new Villa("Panorama","Petros Papas","Villa1",234,213,true,true,true,true,true);
        Maisonette maisonette=new Maisonette("Lagyna","Petros Papas","Maisonette1",234,243,true,true,true,true);
        Apartment apartment=new Apartment("Panorama","Petros Papas","Apartment1",56,54,true,true,true,5);

        owner.addAccommodation(villa);
        owner.addAccommodation(maisonette);
        owner.addAccommodation(apartment);

        Customer customer=new Customer("kostas","1234","Kostas Nikolaou","Tsimiski 5");

        ArrayList<User> users=new ArrayList<>();
        users.add(owner);
        users.add(customer);

        assertEquals(0,owner.getProviderReservations().size());

        customer.makeReservation(new Date(1,1,2021),new Date(3,4,2021),villa,users);
        assertEquals(1,owner.getProviderReservations().size());

        customer.makeReservation(new Date(1,1,2021),new Date(3,4,2021),apartment,users);
        assertEquals(2,owner.getProviderReservations().size());
    }

    @Test
    public void addCancellation() {
        AccommodationOwner owner=new AccommodationOwner("petros","12345","Petros Papas","Aigaiou 81");

        Villa villa=new Villa("Panorama","Petros Papas","Villa1",234,213,true,true,true,true,true);
        Maisonette maisonette=new Maisonette("Lagyna","Petros Papas","Maisonette1",234,243,true,true,true,true);
        Apartment apartment=new Apartment("Panorama","Petros Papas","Apartment1",56,54,true,true,true,5);

        owner.addAccommodation(villa);
        owner.addAccommodation(maisonette);
        owner.addAccommodation(apartment);

        Customer customer=new Customer("kostas","1234","Kostas Nikolaou","Tsimiski 5");

        ArrayList<User> users=new ArrayList<>();
        users.add(owner);
        users.add(customer);

        customer.makeReservation(new Date(1,1,2021),new Date(3,4,2021),apartment,users);
        customer.makeReservation(new Date(1,1,2021),new Date(3,4,2021),villa,users);
        assertEquals(0,owner.getProviderCancellations().size());

        customer.makeCancellation(users,0);
        customer.makeCancellation(users,0);
        assertEquals(2,owner.getProviderCancellations().size());
    }

    @Test
    public void addMessage() {
        Provider provider=new Provider("petros","12345p","Petros Kostopoulos","Aigaiou 88");
        provider.addMessage(new Message("EISAI BOUFOS!"));
        assertEquals("EISAI BOUFOS!",provider.getInbox().get(0).getText());
        assertEquals(1, provider.getInbox().size());
    }
}