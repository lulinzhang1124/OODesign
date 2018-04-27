import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AmountTest {
    private Amount amt = new Amount(3,99);

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void getDollars() {
        assertEquals(new Integer(3), this.amt.getDollars());
    }

    @Test
    public void getCents() {
        assertEquals(new Integer(99), this.amt.getCents());
    }
}