package edu.neu.ccs.cs5004.Problem1;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class NameTest {

    private Name Name;
    private Name sameRefName;
    private Name sameStateAsName;
    private Name yetAnotherName;
    private Name diffName;
    private Name nullName = null;


    @Before
    public void setUp() throws Exception {
        Name = new Name("Steven", "Jones");
        sameRefName = Name;
        sameStateAsName = new Name("Steven", "Jones");
        yetAnotherName = new Name("Steven", "Jones");
        diffName = new Name("Julie", "West");

    }

    @org.junit.Test
    public void getFirst() {
    }

    @org.junit.Test
    public void getLast() {
    }

    @Test
    public void testEquals() throws Exception {
        Assert.assertTrue(Name.equals(Name)); // reflexivity
        Assert.assertTrue(Name.equals(sameRefName)); // trivial condition both reference the same object
        Assert.assertTrue(Name.equals(sameStateAsName)); // both objects should have the same state
        Assert.assertTrue(sameStateAsName.equals(Name)); //symmetry
        Assert.assertEquals(Name.equals(sameStateAsName) && sameStateAsName.equals(yetAnotherName), yetAnotherName.equals(Name)); //transitivity
        Assert.assertFalse(Name.equals(diffName)); //objects have different state
        Assert.assertFalse(Name.equals(nullName)); // Name is NOT null

    }

    @Test
    public void testHashCode() throws Exception {
        Assert.assertEquals(Name.equals(sameRefName), Name.hashCode() == sameRefName.hashCode()); //same objects have the same hashCode
        Assert.assertEquals(Name.equals(sameStateAsName), Name.hashCode() == sameStateAsName.hashCode()); //equal objects have the same hashCode


    }

    @Test
    public void testToString() throws Exception {
        String tempRes = "Name{" + Name.getFirst() + " " + Name.getLast() + '}';

        Assert.assertEquals(tempRes, Name.toString());


    }
}