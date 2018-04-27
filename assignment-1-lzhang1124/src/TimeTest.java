import org.junit.Assert;

import static org.junit.Assert.*;

public class TimeTest {
    private Time time;

    @org.junit.Before
    public void setUp() throws Exception {
        this.time = new Time(8,18,8);
    }

    @org.junit.After
    public void tearDown() throws Exception {
    }

    @org.junit.Test
    public void getHours() {
        Assert.assertEquals(new Integer(8), this.time.getHours());
    }

    @org.junit.Test
    public void getMinutes() {
        Assert.assertEquals(new Integer(18), this.time.getMinutes());
    }

    @org.junit.Test
    public void getSeconds() {
        Assert.assertEquals(new Integer(8), this.time.getSeconds());
    }
}