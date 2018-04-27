package edu.neu.ccs.cs5004.assignment6.midtermq2;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class NameTest {
  private Name name;
  private Name sameRefName;
  private Name sameStateName;
  private Name yetAnotherName;
  private Name diffName;
  private Name nullName;


  @Before
  public void setUp() throws Exception {
    name = new Name("John","Doe");
    sameRefName = name;
    sameStateName = new Name("John","Doe");
    yetAnotherName =  new Name("John","Doe");
    diffName = new Name("Mary","Jane");
    nullName = null;
  }

  @Test
  public void testEquals() {
    Assert.assertTrue(name.equals(name));
    Assert.assertTrue(name.equals(sameRefName));
    Assert.assertTrue(name.equals(sameStateName));
    Assert.assertTrue(sameStateName.equals(name));
    Assert.assertEquals(name.equals(sameStateName),sameStateName.equals(name));
    Assert.assertEquals(name.equals(sameStateName)&& sameStateName.equals(yetAnotherName),yetAnotherName.equals(name));
    Assert.assertFalse(name.equals(diffName));
    Assert.assertFalse(name.equals(new Integer(1)));
    Assert.assertFalse(name.equals(nullName));
  }

  @Test
  public void testHashCode() {
    Assert.assertEquals(name.equals(sameRefName), name.hashCode()==sameRefName.hashCode());
    Assert.assertEquals(name.equals(sameStateName), name.hashCode()==sameStateName.hashCode());
  }

  @Test
  public void testToString() {
    String temp =  "Name{"
            +
            "first='"
            + name.first
            + '\''
            +
            ", last='"
            + name.last
            + '\''
            +
            '}';;

            Assert.assertEquals(temp,name.toString());
  }
}