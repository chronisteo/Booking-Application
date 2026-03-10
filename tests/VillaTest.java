import org.junit.Test;

import static org.junit.Assert.*;

public class VillaTest {

    @Test
    public void setPool() {
        Villa villa=new Villa("Panorama","Kostas Papas","Villa2",323,3245,true,true,true,true,true);
        villa.setPool(false);
        assertFalse(villa.getPool());
    }

    @Test
    public void getPool() {
        Villa villa=new Villa("Panorama","Kostas Papas","Villa2",323,3245,true,true,true,true,true);
        assertTrue(villa.getPool());
        villa.setPool(false);
        assertFalse(villa.getPool());

    }

}