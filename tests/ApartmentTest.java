import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ApartmentTest {
    Apartment apartment;

    @Before
    public void setUp() throws Exception {
        apartment=new Apartment("Thessaloniki","Antonis","Antonis Apartment",45,400,true,true,true,3);
    }

    @Test
    public void setAndGetFloor() {
        assertEquals(3,apartment.getFloor());
        apartment.setFloor(5);
        assertEquals(5,apartment.getFloor());
    }


}