import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ReservationTest {
    Reservation reservation;
    String name;
    Date d1,d2;
    Apartment house;
    @Before
    public void setUp() throws Exception {
        name="antonis";
        d1=new Date(15,6,2022);
        d2=new Date(18,6,2022);
        house=new Apartment("Thessaloniki","Antonis","Antonis Apartment",45,400,true,true,true,3);
        reservation=new Reservation(name,d1,d2,house);
    }

    @Test
    public void getCustomerName() {
        assertEquals("antonis",reservation.getCustomerName());
    }

    @Test
    public void getCheckIn() {
        assertEquals(d1,reservation.getCheckIn());
    }

    @Test
    public void getBuilding() {
        assertEquals(house,reservation.getBuilding());
    }

    @Test
    public void getCheckOut() {
        assertEquals(d2,reservation.getCheckOut());
    }
}