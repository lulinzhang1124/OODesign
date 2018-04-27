package edu.neu.ccs.cs5004.assignment4.problem3;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class GapCellTest {

  GapCell gapCell;

  @Before
  public void setUp() throws Exception {
    gapCell = new GapCell(true);
  }

  @Test
  public void canPlacedShip() {
    assertFalse(gapCell.canPlacedShip());
  }

  @Test
  public void toStringTest() {
    String temp = "GapCell{" +
        "isHit=" + gapCell.isHit +
        '}';
    assertEquals(temp, gapCell.toString());
  }
}