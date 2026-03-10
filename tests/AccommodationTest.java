import org.junit.Test;

import static org.junit.Assert.*;

public class AccommodationTest  {

    @Test
    public void setWifi() {
            Accommodation accommodation=new Accommodation("Thessaloniki","George Papas","newAccom",32,13,true,true,true);
            accommodation.setWifi(false);
            assertFalse(accommodation.getWifi());
    }

    @Test
    public void setParking() {
        Accommodation accommodation=new Accommodation("Thessaloniki","George Papas","newAccom",32,13,true,true,true);
        accommodation.setParking(false);
        assertFalse(accommodation.getParking());
    }

    @Test
    public void setAirConditioning() {
        Accommodation accommodation=new Accommodation("Thessaloniki","George Papas","newAccom",32,13,true,true,true);
        accommodation.setAirConditioning(false);
        assertFalse(accommodation.getAirConditioning());
    }

    @Test
    public void setLocation() {
        Accommodation accommodation=new Accommodation("Thessaloniki","George Papas","newAccom",32,13,true,true,true);
        accommodation.setLocation("Athens");
        assertEquals("Athens",accommodation.getLocation());
    }

    @Test
    public void getWifi() {
        Accommodation accommodation=new Accommodation("Thessaloniki","George Papas","newAccom",32,13,true,true,true);
        assertTrue(accommodation.getWifi());
    }

    @Test
    public void getParking() {
        Accommodation accommodation=new Accommodation("Thessaloniki","George Papas","newAccom",32,13,true,true,true);
        assertTrue(accommodation.getParking());
    }

    @Test
    public void getAirConditioning() {
        Accommodation accommodation=new Accommodation("Thessaloniki","George Papas","newAccom",32,13,true,true,true);
        assertTrue(accommodation.getAirConditioning());
    }

    @Test
    public void getLocation() {
        Accommodation accommodation=new Accommodation("Thessaloniki","George Papas","newAccom",32,13,true,true,true);
        assertEquals("Thessaloniki",accommodation.getLocation());
    }


}
