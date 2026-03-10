import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class CustomerTest {
    Customer m;
    Date d1,d2;
    AccommodationOwner owner;
    Apartment house;
    ArrayList<User> users;

    @Before
    public void setUp() throws Exception {
       m=new Customer("antonis","tony","Antonis Apostoloudis","georgiou 4");
       d1=new Date(15,6,2022);
       d2=new Date(18,6,2022);
       owner=new AccommodationOwner("Thodoris","thodoris","Thodoris Chronis","perikleos 5");
       house=new Apartment("Thessaloniki","Thodoris","Thodoris Apartment",100,2000,true,true,true,5);
       owner.addAccommodation(house);
       users=new ArrayList<>();
       users.add(m);
       users.add(owner);

    }

    @Test
    public void setAndGetAddress() {
        assertEquals("georgiou 4",m.getAddress());
        m.setAddress("georgiou 35");
        assertEquals("georgiou 35",m.getAddress());
    }

    @Test
    public void getReservations() {
        assertEquals(0,m.getReservations().size());
        m.makeReservation(d1,d2,house,users);
        assertEquals(1,m.getReservations().size());
    }

    @Test
    public void getCancellations() {
        assertEquals(0,m.getCancellations().size());
        m.makeReservation(d1,d2,house,users);
        m.makeCancellation(users,0);
        assertEquals(1,m.getCancellations().size());
    }



    @Test
    public void getInbox() {
        assertEquals(0,m.getInbox().size());
        m.addMessage(new Message("You are dumb"));
        assertEquals(1,m.getInbox().size());
        for(int i=0;i<49;i++){
            m.addMessage(new Message("You are dumb"));
        }
        assertEquals(50,m.getInbox().size());

    }

    @Test
    public void addMessage() {
        assertEquals(0,m.getInbox().size());
        Message message=new Message("eisai traxanas");
        m.addMessage(message);
        assertEquals("eisai traxanas",m.getInbox().get(0).getText());
        assertEquals(1,m.getInbox().size());
    }

    @Test
    public void makeReservation() {
        assertEquals(0,m.getReservations().size());
        m.makeReservation(d1,d2,house,users);
        assertEquals(1,m.getReservations().size());
        assertEquals("Antonis Apostoloudis",m.getReservations().get(0).getCustomerName());
    }

    @Test
    public void makeCancellation() {
        assertEquals(0,m.getCancellations().size());
        m.makeReservation(d1,d2,house,users);
        m.makeCancellation(users,0);
        assertEquals(1,m.getCancellations().size());
    }
}