package edu.neu.ccs.cs5004.Problem1;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GeneralSecretaryTest {

    private GeneralSecretary gs1;

    @Before
    public void setUp() throws Exception {
        gs1 = new GeneralSecretary(new Name("Jon", "Snow"), 40, 40000, 14,
                "L166Y15", 3);
    }

    @Test
    public void extraVacation() {
        Assert.assertEquals(new Integer(0), gs1.extraVacation(gs1.servedYear));
    }

    @Test
    public void promoteTest() {
        LegalSecretary ls = new LegalSecretary(new Name("Jon", "Snow"), 40, 40000, 14,
                "L166Y15", 3);
        Assert.assertEquals(ls, gs1.promote(gs1));

    }

    @Test
    public void toStringTest() {
        String temp = "GeneralSecretary{" +
                "name=" + gs1.name +
                ", workload=" + gs1.workload +
                ", salary=" + gs1.salary +
                ", paidVacation=" + gs1.paidVacation +
                ", employeeID='" + gs1.employeeID + '\'' +
                ", servedYear=" + gs1.servedYear +
                '}';
        Assert.assertEquals(temp, gs1.toString());
    }
}