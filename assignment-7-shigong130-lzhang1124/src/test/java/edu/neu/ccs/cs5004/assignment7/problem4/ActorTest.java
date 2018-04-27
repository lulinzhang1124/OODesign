package edu.neu.ccs.cs5004.assignment7.problem4;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class ActorTest {

  private Name name1;
  private Name name2;
  private Actor actor;
  private Actor diffActor;
  private Actor sameRefActor;
  private Actor sameStateActor;
  private Actor yetAnotherActor;
  private Actor nullActor;

  @Before
  public void setUp() throws Exception {
    name1 = new Name("Angela","Baby");
    name2 = new Name("Mary","Baby");
    actor = new Actor(name1);
    sameRefActor = actor;
    sameStateActor = new Actor(name1);
    yetAnotherActor = new Actor(name1);
    diffActor = new Actor(name2);
    nullActor = null;
  }

  @Test
  public void getName() {
    Assert.assertEquals(name1,actor.getName());
  }

  @Test
  public void testEquals() {
    Assert.assertTrue(actor.equals(actor));
    Assert.assertTrue(actor.equals(sameRefActor));
    Assert.assertTrue(actor.equals(sameStateActor));
    Assert.assertTrue(sameStateActor.equals(actor));
    Assert.assertEquals(actor.equals(sameStateActor),sameStateActor.equals(actor));
    Assert.assertEquals(actor.equals(sameStateActor)&& sameStateActor.equals(yetAnotherActor),yetAnotherActor.equals(actor));
    Assert.assertFalse(actor.equals(diffActor));
    Assert.assertFalse(actor.equals(new Integer(1)));
    Assert.assertFalse(actor.equals(nullActor));
  }

  @Test
  public void testHashCode() {
    Assert.assertEquals(actor.equals(sameRefActor), actor.hashCode()==sameRefActor.hashCode());
    Assert.assertEquals(actor.equals(sameStateActor), actor.hashCode()==sameStateActor.hashCode());

  }

  @Test
  public void testToString() {
    String temp  = "Actor{" +
            "name=" + actor.getName() +
            '}';
    Assert.assertEquals(temp,actor.toString());

  }
}