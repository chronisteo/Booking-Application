import org.junit.Test;

import static org.junit.Assert.*;

public class UserTest {


    @Test
    public void setUsername() {
        User user=new User("petros","12345p","Petros Papas");
        assertEquals("petros",user.getUsername());
        user.setUsername("petros12");
        assertEquals("petros12",user.getUsername());
    }

    @Test
    public void setFull_name() {
        User user=new User("petros","12345p","Petros Papas");
        assertEquals("Petros Papas",user.getFull_name());
        user.setFull_name("Petros Papadopoulos");
        assertEquals("Petros Papadopoulos",user.getFull_name());
    }

    @Test
    public void setPassword() {
        User user=new User("petros","12345p","Petros Papas");
        assertEquals("12345p",user.getPassword());
        user.setPassword("12345");
        assertEquals("12345",user.getPassword());
    }

    @Test
    public void getUsername() {
        User user=new User("petros","12345p","Petros Papas");
        assertEquals("petros",user.getUsername());
        user.setUsername("petros15");
        assertEquals("petros15",user.getUsername());
    }

    @Test
    public void getFull_name() {
        User user=new User("petros","12345p","Petros Papas");
        assertEquals("Petros Papas",user.getFull_name());
        user.setFull_name("Petros Papadopoulos");
        assertEquals("Petros Papadopoulos",user.getFull_name());
    }

    @Test
    public void getPassword() {
        User user=new User("petros","12345p","Petros Papas");
        assertEquals("12345p",user.getPassword());
        user.setPassword("12345");
        assertEquals("12345",user.getPassword());
    }

}