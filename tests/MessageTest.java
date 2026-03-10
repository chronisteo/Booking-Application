import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MessageTest {
    Message m;
    @Before
    public void setUp() throws Exception {
        m=new Message("You are a dumb user");
    }

    @Test
    public void setAndGetText() {
        assertEquals("You are a dumb user",m.getText());
        m.setText("Hallelujah");
        assertEquals("Hallelujah",m.getText());
    }


}