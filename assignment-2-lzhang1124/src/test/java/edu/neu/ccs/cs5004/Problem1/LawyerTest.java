package edu.neu.ccs.cs5004.Problem1;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LawyerTest {
    private Lawyer lawyer1;

    @Before
    public void setUp() throws Exception {
        lawyer1 = new Lawyer(new Name("Jon", "Snow"), 40, 40000, 14,
                "L166Y15", 3);
    }

    @Test
    public void uniqueBehaviorTest() {
        Assert.assertEquals("Let's sue!", lawyer1.uniqueBehavior());
    }

    @Test
    public void toStringTest() {
        String temp = "Lawyer{" +
                "name=" + lawyer1.name +
                ", workload=" + lawyer1.workload +
                ", salary=" + lawyer1.salary +
                ", paidVacation=" + lawyer1.paidVacation +
                ", employeeID='" + lawyer1.employeeID + '\'' +
                ", servedYear=" + lawyer1.servedYear +
                '}';
        Assert.assertEquals(temp, lawyer1.toString());
    }
}