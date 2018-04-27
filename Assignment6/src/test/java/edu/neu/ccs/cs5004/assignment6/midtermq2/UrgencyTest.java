package edu.neu.ccs.cs5004.assignment6.midtermq2;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class UrgencyTest {
  private Urgency urgency;
  private Urgency sameRefUrgency;
  private Urgency sameStateUrgency;
  private Urgency yetAnotherUrgency;
  private Urgency diffUrgency;
  private Urgency nullUrgency;

  @Before
  public void setUp() throws Exception {
    urgency = new Urgency(10);
    sameRefUrgency = urgency;
    sameStateUrgency = new Urgency(10);
    yetAnotherUrgency = new Urgency(10);
    diffUrgency = new Urgency(5);
    nullUrgency = null;

  }

  @Test
  public void compareTo() {
    Assert.assertEquals(1,urgency.compareTo(diffUrgency));
    Assert.assertEquals(0,urgency.compareTo(urgency));
    Assert.assertEquals(-1,diffUrgency.compareTo(urgency));
  }

  @Test
  public void testEquals() {
    Assert.assertTrue(urgency.equals(urgency));
    Assert.assertTrue(urgency.equals(sameRefUrgency));
    Assert.assertTrue(urgency.equals(sameStateUrgency));
    Assert.assertTrue(sameStateUrgency.equals(urgency));
    Assert.assertEquals(urgency.equals(sameStateUrgency),sameStateUrgency.equals(urgency));
    Assert.assertEquals(urgency.equals(sameStateUrgency)&& sameStateUrgency.equals(yetAnotherUrgency),yetAnotherUrgency.equals(urgency));
    Assert.assertFalse(urgency.equals(diffUrgency));
    Assert.assertFalse(urgency.equals(new Long(1)));
    Assert.assertFalse(urgency.equals(nullUrgency));

  }

  @Test
  public void testHashCode() {
    Assert.assertEquals(urgency.equals(sameRefUrgency), urgency.hashCode()==sameRefUrgency.hashCode());
    Assert.assertEquals(urgency.equals(sameStateUrgency), urgency.hashCode()==sameStateUrgency.hashCode());

  }

  @Test
  public void testToString() {
    String temp = "Urgency{" +
            "value=" + urgency.value +
            '}';
    Assert.assertEquals(temp,urgency.toString());
  }

}