package edu.neu.ccs.cs5004.assignment7.problem4;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DirectorTest {
  private Name name1;
  private Name name2;
  private Director director;
  private Director diffDirector;
  private Director sameRefDirector;
  private Director sameStateDirector;
  private Director yetAnotherDirector;
  private Director nullDirector;

  @Before
  public void setUp() throws Exception {
    name1 = new Name("Angela","Baby");
    name2 = new Name("Mary","Baby");
    director = new Director(name1);
    sameRefDirector = director;
    sameStateDirector = new Director(name1);
    yetAnotherDirector = new Director(name1);
    diffDirector = new Director(name2);
    nullDirector = null;
  }

  @Test
  public void getName() {
    Assert.assertEquals(name1,director.getName());
  }

  @Test
  public void equals() {
    Assert.assertTrue(director.equals(director));
    Assert.assertTrue(director.equals(sameRefDirector));
    Assert.assertTrue(director.equals(sameStateDirector));
    Assert.assertTrue(sameStateDirector.equals(director));
    Assert.assertEquals(director.equals(sameStateDirector),sameStateDirector.equals(director));
    Assert.assertEquals(director.equals(sameStateDirector)&& sameStateDirector.equals(yetAnotherDirector),yetAnotherDirector.equals(director));
    Assert.assertFalse(director.equals(diffDirector));
    Assert.assertFalse(director.equals(new Integer(1)));
    Assert.assertFalse(director.equals(nullDirector));
  }

  @Test
  public void testHashCode() {
    Assert.assertEquals(director.equals(sameRefDirector), director.hashCode()==sameRefDirector.hashCode());
    Assert.assertEquals(director.equals(sameStateDirector), director.hashCode()==sameStateDirector.hashCode());

  }

  @Test
  public void testToString() {
    String temp =  "Director{" +
            "name=" + director.getName() +
            '}';

    Assert.assertEquals(temp,director.toString());
  }
}