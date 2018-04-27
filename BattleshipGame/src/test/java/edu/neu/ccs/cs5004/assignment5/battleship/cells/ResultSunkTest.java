package edu.neu.ccs.cs5004.assignment5.battleship.cells;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ResultSunkTest {

  AttackResult sunk;
  AttackResult sameRefsunk;
  AttackResult sameStatesunk;

  @Before
  public void setUp() throws Exception {

    sunk = new ResultSunk();
    sameRefsunk = sunk;
    sameStatesunk = new ResultSunk();
  }


  @Test
  public void AttackResult() {
    assertEquals("Sunk", sunk.attackResult());
  }

  @Test
  public void testEquals() throws Exception {
    AttackResult nullsunk = null;
    AttackResult yetAnothersunk = new Hit();
    ;
    AttackResult diffsunk1 = new Hit();

    Assert.assertTrue(sunk.equals(sunk)); // reflexivity
    Assert.assertTrue(sunk.equals(sameRefsunk)); // trivial condition both reference the same object
    Assert.assertEquals(sunk.equals(sameStatesunk), sameStatesunk.equals(sunk)); //symmetry
    Assert.assertEquals(sunk.equals(sameStatesunk) &&
            sameStatesunk.equals(yetAnothersunk), yetAnothersunk.equals(sunk)); //transitivity
    Assert.assertFalse(sunk.equals(diffsunk1));
    Assert.assertFalse(sunk.equals(nullsunk));
  }

  @Test
  public void testHashCode() throws Exception {
    Assert.assertEquals(sunk.equals(sameRefsunk), sunk.hashCode() == sameRefsunk.hashCode()); //same objects have the same hashCode
    Assert.assertEquals(sunk.equals(sameStatesunk), sunk.hashCode() == sameStatesunk.hashCode()); //equal objects have the same hashCode

  }
  @Test
  public void testToString(){
    String temp ="Sunk";
    Assert.assertEquals(temp,sunk.toString());
  }

}