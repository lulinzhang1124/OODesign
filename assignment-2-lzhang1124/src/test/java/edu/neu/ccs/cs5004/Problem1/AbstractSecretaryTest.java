package edu.neu.ccs.cs5004.Problem1;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AbstractSecretaryTest {

    private AbstractSecretary abstractSecretary1;

    @Before
    public void setUp() throws Exception {
        abstractSecretary1 = new GeneralSecretary(new Name("Jon", "Snow"), 40,
                40000, 14, "L166Y15", 3);
    }


    @Test
    public void uniqueBehavior() {
        Assert.assertEquals("Let's schedule meetings.",
                abstractSecretary1.uniqueBehavior());
    }

}