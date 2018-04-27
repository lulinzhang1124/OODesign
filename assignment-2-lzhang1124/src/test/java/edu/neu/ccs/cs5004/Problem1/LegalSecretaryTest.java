package edu.neu.ccs.cs5004.Problem1;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LegalSecretaryTest {

    private LegalSecretary ls1;

    @Before
    public void setUp() throws Exception {
        ls1 = new LegalSecretary(new Name("Jon", "Snow"), 40, 40000, 14,
                "L166Y15", 3);
    }

    @Test
    public void promoteTest() {
        GeneralSecretary gs1 = new GeneralSecretary(new Name("Jon", "Snow"), 40, 40000, 14,
                "L166Y15", 3);
        Assert.assertEquals(ls1, gs1.promote(gs1));
    }

    @Test
    public void uniqueBehavior() {
        String temp = "Let's schedule meetings. Let's prepare legal documents!";
        Assert.assertEquals(temp, ls1.uniqueBehavior());
    }

    @Test
    public void toStringTest() {
        String temp = "LegalSecretary{" +
                "name=" + ls1.name +
                ", workload=" + ls1.workload +
                ", salary=" + ls1.salary +
                ", paidVacation=" + ls1.paidVacation +
                ", employeeID='" + ls1.employeeID + '\'' +
                ", servedYear=" + ls1.servedYear +
                '}';
    }
}