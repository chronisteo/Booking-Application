import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HotelTest {
    Hotel hotel;
    HotelRoom room;
    @Before
    public void setUp() throws Exception {
        hotel=new Hotel("Thessaloniki","Imperial",true,true,true,true,true);

    }

    @Test
    public void setAndGet() {
        assertEquals("Thessaloniki",hotel.getLocation());
        assertEquals("Imperial",hotel.getName());
        assertTrue(hotel.getBreakfast());
        assertTrue(hotel.getPool());
        assertTrue(hotel.getParking());
        assertTrue(hotel.getWifi());
        assertTrue(hotel.getAirConditioning());
        hotel.setLocation("Chania");
        hotel.setName("Majesty");
        assertEquals("Chania",hotel.getLocation());
        assertEquals("Majesty",hotel.getName());
        hotel.setParking(false);
        hotel.setWifi(false);
        assertFalse(hotel.getParking());
        assertFalse(hotel.getWifi());
        assertTrue(hotel.getAirConditioning());
        assertTrue(hotel.getBreakfast());
        assertTrue(hotel.getPool());
    }



    @Test
    public void getHotelRooms() {
        assertEquals(0,hotel.getHotelRooms().size());
        room=new SingleRoom("Antonis","Majesty",40,300,true,true,true);
        hotel.addHotelRoom(room);
        assertEquals(1,hotel.getHotelRooms().size());
        for(int i=0;i<49;i++){
            hotel.addHotelRoom(new DoubleRoom("Antonis","Majesty",40,300,true,true,true));
        }
        assertEquals(50,hotel.getHotelRooms().size());
    }

    @Test
    public void addHotelRoom() {
        assertEquals(0,hotel.getHotelRooms().size());
        room=new SingleRoom("Antonis","Majesty",40,300,true,true,true);
        hotel.addHotelRoom(room);
        assertEquals(1,hotel.getHotelRooms().size());
        assertEquals("Antonis",hotel.getHotelRooms().get(0).getProviderName());
        assertEquals("Majesty",hotel.getHotelRooms().get(0).getName());
        assertEquals(40,hotel.getHotelRooms().get(0).getM2());
        assertEquals(300,hotel.getHotelRooms().get(0).getPrice());
        assertTrue(hotel.getHotelRooms().get(0).getNonSmoking());
        assertTrue(hotel.getHotelRooms().get(0).getBalcony());
        assertTrue(hotel.getHotelRooms().get(0).getTv());
    }
}