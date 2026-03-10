import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DetachedHouseTest {
    DetachedHouse house;

    @Before
    public void setUp() throws Exception {
        house=new DetachedHouse("Thessaloniki","Antonis","Antonis House",120,5000,true,true,true,true);
    }

    @Test
    public void setAndGetGarden() {
        assertTrue(house.getGarden());
        house.setGarden(false);
        assertFalse(house.getGarden());
    }


}