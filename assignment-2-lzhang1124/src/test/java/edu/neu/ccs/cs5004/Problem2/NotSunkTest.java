package edu.neu.ccs.cs5004.Problem2;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class NotSunkTest {

    markSunk sunk;
    markSunk sameRefSunk;
    markSunk sameStateSunk;

    @Before
    public void setUp() throws Exception {

        sunk = new NotSunk();
        sameRefSunk = sunk;
        sameStateSunk = new NotSunk();
    }

    @Test
    public void isSunk() {
        assertEquals("Not Sunk",sunk.isSunk());
    }

    @Test
    public void testEquals() throws Exception {
        markSunk nullSunk = null;
        markSunk yetAnotherSunk = new NotSunk();;
        markSunk diffSunk1 = new Sunk();

        Assert.assertTrue(sunk.equals(sunk)); // reflexivity
        Assert.assertTrue(sunk.equals(sameRefSunk)); // trivial condition both reference the same object
        Assert.assertEquals(sunk.equals(sameStateSunk), sameStateSunk.equals(sunk)); //symmetry
        Assert.assertEquals(sunk.equals(sameStateSunk) &&
                sameStateSunk.equals(yetAnotherSunk), yetAnotherSunk.equals(sunk)); //transitivity
        Assert.assertFalse(sunk.equals(diffSunk1));
        Assert.assertFalse(sunk.equals(nullSunk));
    }

    @Test
    public void testHashCode() throws Exception {
        Assert.assertEquals(sunk.equals(sameRefSunk), sunk.hashCode() == sameRefSunk.hashCode()); //same objects have the same hashCode
        Assert.assertEquals(sunk.equals(sameStateSunk), sunk.hashCode() == sameStateSunk.hashCode()); //equal objects have the same hashCode

    }

}