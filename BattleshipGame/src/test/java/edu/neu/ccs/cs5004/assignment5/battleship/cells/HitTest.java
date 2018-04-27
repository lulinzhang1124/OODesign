package edu.neu.ccs.cs5004.assignment5.battleship.cells;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HitTest {
  AttackResult hit;
  AttackResult sameRefhit;
  AttackResult sameStatehit;

  @Before
  public void setUp() throws Exception {

    hit = new Hit();
    sameRefhit = hit;
    sameStatehit = new Hit();
  }


  @Test
  public void attackResult() {
    assertEquals("Hit", hit.attackResult());
  }

  @Test
  public void testEquals() throws Exception {
    AttackResult nullhit = null;
    AttackResult yetAnotherhit = new Hit();
    ;
    AttackResult diffhit1 = new Miss();

    Assert.assertTrue(hit.equals(hit)); // reflexivity
    Assert.assertTrue(hit.equals(sameRefhit)); // trivial condition both reference the same object
    Assert.assertEquals(hit.equals(sameStatehit), sameStatehit.equals(hit)); //symmetry
    Assert.assertEquals(hit.equals(sameStatehit) &&
            sameStatehit.equals(yetAnotherhit), yetAnotherhit.equals(hit)); //transitivity
    Assert.assertFalse(hit.equals(diffhit1));
    Assert.assertFalse(hit.equals(nullhit));
  }

  @Test
  public void testHashCode() throws Exception {
    Assert.assertEquals(hit.equals(sameRefhit), hit.hashCode() == sameRefhit.hashCode()); //same objects have the same hashCode
    Assert.assertEquals(hit.equals(sameStatehit), hit.hashCode() == sameStatehit.hashCode()); //equal objects have the same hashCode

  }

  @Test
  public void testToString(){
    String temp ="Hit";
    Assert.assertEquals(temp,hit.toString());
  }
}