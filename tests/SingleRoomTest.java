import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SingleRoomTest {
    SingleRoom room;
    @Before
    public void setUp() throws Exception {
        room=new SingleRoom("Antonis","Imperial",40,300,true,true,true);
    }

    @Test
    public void setAndGet(){
        assertEquals("Antonis",room.getProviderName());
        assertEquals("Imperial",room.getName());
        assertEquals(40,room.getM2());
        assertEquals(300,room.getPrice());
        assertTrue(room.getTv());
        assertTrue(room.getBalcony());
        assertTrue(room.getNonSmoking());
        assertEquals(0,room.getNumber());
        room.setNumber(5);
        assertEquals(5,room.getNumber());
        room.setName("Majesty");
        room.setM2(80);
        room.setPrice(600);
        assertEquals(80,room.getM2());
        assertEquals(600,room.getPrice());
        assertEquals("Majesty",room.getName());
    }
}