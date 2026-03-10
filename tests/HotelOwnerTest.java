import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class HotelOwnerTest {
    HotelOwner owner;
    ArrayList<User> users;
    @Before
    public void setUp() throws Exception {
        owner=new HotelOwner("antonis","tony","Antonis Apostoloudis","georgiou 3");
        users=new ArrayList<>();
        users.add(owner);
    }

    @Test
    public void getHotels() {
        assertEquals(0,owner.getHotels().size());
        owner.addHotel(new Hotel("Thessaloniki","Imperial",true,true,true,true,true));
        assertEquals(1,owner.getHotels().size());
    }

    @Test
    public void addHotel() {
        assertEquals(0,owner.getHotels().size());
        owner.addHotel(new Hotel("Thessaloniki","Imperial",true,true,true,true,true));
        assertEquals(1,owner.getHotels().size());
        assertEquals("Imperial",owner.getHotels().get(0).getName());
        assertEquals("Thessaloniki",owner.getHotels().get(0).getLocation());

    }

    @Test
    public void removeHotel() {
        assertEquals(0,owner.getHotels().size());
        owner.addHotel(new Hotel("Thessaloniki","Imperial",true,true,true,true,true));
        assertEquals(1,owner.getHotels().size());
        owner.addHotel(new Hotel("Thessaloniki","Majesty",true,true,true,true,true));
        owner.addHotel(new Hotel("Thessaloniki","Royal",true,true,true,true,true));
        owner.removeHotel(owner.getHotels().get(2),users);
        assertEquals(2,owner.getHotels().size());
    }
}