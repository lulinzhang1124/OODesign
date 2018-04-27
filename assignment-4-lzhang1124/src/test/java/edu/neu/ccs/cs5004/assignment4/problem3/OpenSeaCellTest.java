package edu.neu.ccs.cs5004.assignment4.problem3;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class OpenSeaCellTest {

  OpenSeaCell OpenSeaCell;

  @Before
  public void setUp() throws Exception {
    OpenSeaCell = new OpenSeaCell(false);
  }

  @Test
  public void canPlacedShip() {
    assertTrue(OpenSeaCell.canPlacedShip());
  }


  @Test
  public void toStringTest() {
    String temp = "OpenSeaCell{" +
        "isHit=" + OpenSeaCell.isHit +
        '}';
    assertEquals(temp, OpenSeaCell.toString());
  }
}