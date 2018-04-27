import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AccountTest {
    private Account acc;
    private Amount amt1;
    private Amount amt2;

    @Before
    public void setUp() throws Exception {
        this.acc = new Account(new Name("Alex","Green"), new Amount(7000,20));
        this.amt1 = new Amount(5100,66);
        this.amt2 = new Amount(50,99);
    }

    @Test
    public void getName() {
        assertEquals("Alex Green",this.acc.getName());
    }

    @Test
    public void getBalance() {
        assertEquals(new Integer(7000), this.acc.getBalance().getDollars());
        assertEquals(new Integer(20), this.acc.getBalance().getCents());
    }

    @Test
    public void deposit() {
        assertEquals(new Integer(7051), this.acc.deposit(acc,amt2).getBalance().getDollars());
        assertEquals(new Integer(19), this.acc.deposit(acc,amt2).getBalance().getCents());
    }

    @Test
    public void withdraw() {
        assertEquals(new Integer(1899), this.acc.withdraw(acc,amt1).getBalance().getDollars());
        assertEquals(new Integer(54), this.acc.withdraw(acc,amt1).getBalance().getCents());
    }
}