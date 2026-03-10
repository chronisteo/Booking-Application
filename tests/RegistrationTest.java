import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class RegistrationTest {
    ArrayList<User> users;

    @Before
    public void setUp() throws Exception {
        users=new ArrayList<>();
    }

    @Test
    public void addUser() {
        assertEquals(0,users.size());
        AccommodationOwner owner1=new AccommodationOwner("tonyloudis","tamtiriri","Antonis Apostoloudis","28 oktovriou");
        users.add(owner1);
        Customer customer=new Customer("vaggelis","skotos13","Vaggelis Dimos","25 martiou");
        users.add(customer);
        assertEquals(2,users.size());
        assertEquals("tamtiriri",users.get(0).getPassword());
        assertEquals("Vaggelis Dimos",users.get(1).getFull_name());
        assertEquals("tonyloudis",users.get(0).getUsername());
    }
}