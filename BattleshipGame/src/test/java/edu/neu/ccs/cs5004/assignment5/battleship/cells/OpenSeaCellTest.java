package edu.neu.ccs.cs5004.assignment5.battleship.cells;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class OpenSeaCellTest {

  edu.neu.ccs.cs5004.assignment5.battleship.cells.OpenSeaCell openSeaCell;
  private OpenSeaCell sameRefCell;
  private OpenSeaCell sameStateCell;
  private OpenSeaCell anotherCell;
  private OpenSeaCell diffCell;
  private OpenSeaCell nullCell;

  @Before
  public void setUp() throws Exception {
    openSeaCell = new OpenSeaCell(true);
    sameRefCell = openSeaCell;
    sameStateCell = new OpenSeaCell(true);
    anotherCell = new OpenSeaCell(true);
    diffCell = new OpenSeaCell(false);
    nullCell = null;
  }

  @Test
  public void canPlacedShip() {
    assertTrue(openSeaCell.canPlacedShip());
  }

  @Test
  public void testEquals() {
    Assert.assertTrue(openSeaCell.equals(openSeaCell));
    Assert.assertTrue(openSeaCell.equals(sameRefCell));
    Assert.assertTrue(openSeaCell.equals(sameStateCell));
    Assert.assertTrue(sameStateCell.equals(openSeaCell));
    Assert.assertEquals(openSeaCell.equals(sameStateCell), sameStateCell.equals(openSeaCell));
    Assert.assertEquals(openSeaCell.equals(sameStateCell)&& sameStateCell.equals(anotherCell), anotherCell.equals(openSeaCell));
    Assert.assertFalse(openSeaCell.equals(diffCell));
    Assert.assertFalse(openSeaCell.equals(new Integer(1)));
    Assert.assertFalse(openSeaCell.equals(nullCell));
  }

  @Test
  public void testHashCode() {
    Assert.assertEquals(openSeaCell.equals(sameRefCell), openSeaCell.hashCode()== sameRefCell.hashCode());
    Assert.assertEquals(openSeaCell.equals(sameStateCell), openSeaCell.hashCode()== sameStateCell.hashCode());
  }



  @Test
  public void toStringTest() {
    String temp = "OpenSeaCell{" +
            "isHitShip=" + openSeaCell.getIsHit() +
            '}';
    assertEquals(temp, openSeaCell.toString());
  }
}