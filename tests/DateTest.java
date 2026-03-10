import org.junit.Test;

import static org.junit.Assert.*;

public class DateTest {


    @Test
    public void getDay() {
        Date date=new Date(2,3,1999);
        assertEquals(2,date.getDay());
    }

    @Test
    public void getMonth() {
        Date date=new Date(2,3,1999);
        assertEquals(3,date.getMonth());
    }

    @Test
    public void getYear() {
        Date date=new Date(2,3,1999);
        assertEquals(1999,date.getYear());
    }


    @Test
    public void isEquals() {
        Date date=new Date(2,3,1999);
        assertTrue(date.isEquals(new Date(2,3,1999)));
        assertFalse(date.isEquals(new Date(4,5,2002)));
    }

    @Test
    public void lessThan() {
        Date date=new Date(2,3,1999);
        assertTrue(date.lessThan(new Date(2,3,2002)));
        assertFalse(date.lessThan(new Date(4,5,1998)));
        assertFalse(date.lessThan(new Date(2,3,1999)));
    }

    @Test
    public void moreThan() {
        Date date=new Date(2,3,1999);
        assertTrue(date.moreThan(new Date(2,3,1998)));
        assertFalse(date.moreThan(new Date(4,5,2002)));
    }

}