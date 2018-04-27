package edu.neu.ccs.cs5004.Problem1;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class HRManagerTest {

    private HRManager HRManager1;


    @Before
    public void setUp() throws Exception {
        HRManager1 = new HRManager(new Name("Jon", "Snow"), 40, 40000, 14,
                "L166Y15", 3, 10);
    }

    @Test
    public void uniqueBehaviorTest() {
        Assert.assertEquals("Let's hunt talents!", HRManager1.uniqueBehavior());
    }

    @Test
    public void getRecruitedTest() {
        Assert.assertEquals(new Integer(10), HRManager1.getRecruited());
    }


    @Test
    public void toStringTest() {
        String temp = "HRManager{" +
                "recruited=" + HRManager1.getRecruited() +
                ", name=" + HRManager1.name +
                ", workload=" + HRManager1.workload +
                ", salary=" + HRManager1.salary +
                ", paidVacation=" + HRManager1.paidVacation +
                ", employeeID='" + HRManager1.employeeID + '\'' +
                ", servedYear=" + HRManager1.servedYear +
                '}';
        Assert.assertEquals(temp, HRManager1.toString());
    }
}