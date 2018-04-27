package edu.neu.ccs.cs5004.assignment5.battleship.cells;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MissTest {

  AttackResult miss;
  AttackResult sameRefmiss;
  AttackResult sameStatemiss;

  @Before
  public void setUp() throws Exception {

    miss = new Miss();
    sameRefmiss = miss;
    sameStatemiss = new Miss();
  }


  @Test
  public void attackResult() {
    assertEquals("Miss", miss.attackResult());
  }

  @Test
  public void testEquals() throws Exception {
    AttackResult nullmiss = null;
    AttackResult yetAnothermiss = new Miss();
    ;
    AttackResult diffmiss1 = new Hit();

    Assert.assertTrue(miss.equals(miss)); // reflexivity
    Assert.assertTrue(miss.equals(sameRefmiss)); // trivial condition both reference the same object
    Assert.assertEquals(miss.equals(sameStatemiss), sameStatemiss.equals(miss)); //symmetry
    Assert.assertEquals(miss.equals(sameStatemiss) &&
            sameStatemiss.equals(yetAnothermiss), yetAnothermiss.equals(miss)); //transitivity
    Assert.assertFalse(miss.equals(diffmiss1));
    Assert.assertFalse(miss.equals(nullmiss));
  }

  @Test
  public void testHashCode() throws Exception {
    Assert.assertEquals(miss.equals(sameRefmiss), miss.hashCode() == sameRefmiss.hashCode()); //same objects have the same hashCode
    Assert.assertEquals(miss.equals(sameStatemiss), miss.hashCode() == sameStatemiss.hashCode()); //equal objects have the same hashCode

  }

  @Test
  public void testToString(){
    String temp ="Miss";
    Assert.assertEquals(temp,miss.toString());
  }
}