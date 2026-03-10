import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AdminTest {
    Admin m;
    @Before
    public void setUp() throws Exception {
        m=new Admin("tonyloudis","starcraft4life","Antonis Apostoloudis","Apostolou Paulou 100");
    }

    @Test
    public void setAndGet() {
        assertEquals("tonyloudis",m.getUsername());
        assertEquals("starcraft4life",m.getPassword());
        assertEquals("Antonis Apostoloudis",m.getFull_name());
        assertEquals("Apostolou Paulou 100",m.getAddress());
        m.setUsername("mrgeek");
        m.setFull_name("Nerdarded");
        m.setPassword("lol123");
        m.setAddress("Georgiou 3");
        assertEquals("mrgeek",m.getUsername());
        assertEquals("lol123",m.getPassword());
        assertEquals("Nerdarded",m.getFull_name());
        assertEquals("Georgiou 3",m.getAddress());

    }
}