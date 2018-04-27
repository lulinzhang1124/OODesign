

import org.junit.Assert;

import static org.junit.Assert.*;

public class RunnerTest {

    private Runner James;
    private Runner Ross;

    @org.junit.Before
    public void setUp() throws Exception {
        this.James = new Runner("James", new Time(10,30,0),
                new Time(3,25,59));
        this.Ross = new Runner("Ross", new Time(20,55,20),
                new Time(5,25,45));
    }

    @org.junit.Test
    public void getName() {
        assertEquals("James",this.James.getName());
    }

    @org.junit.Test
    public void getStartTime() {
        assertEquals(new Integer(10), this.James.getStartTime().getHours());
        assertEquals(new Integer(30), this.James.getStartTime().getMinutes());
        assertEquals(new Integer(0), this.James.getStartTime().getSeconds());
    }

    @org.junit.Test
    public void getDuration() {
        assertEquals(new Integer(3), this.James.getDuration().getHours());
        assertEquals(new Integer(25), this.James.getDuration().getMinutes());
        assertEquals(new Integer(59), this.James.getDuration().getSeconds());
    }

    @org.junit.Test
    public void getEndTime() {
        assertEquals(new Integer(13), this.James.getEndTime().getHours());
        assertEquals(new Integer(55), this.James.getEndTime().getMinutes());
        assertEquals(new Integer(59), this.James.getEndTime().getSeconds());

        assertEquals(new Integer(2), this.Ross.getEndTime().getHours());
        assertEquals(new Integer(21), this.Ross.getEndTime().getMinutes());
        assertEquals(new Integer(5), this.Ross.getEndTime().getSeconds());

    }
}