package edu.neu.ccs.cs5004.assignment5.battleship.cells;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class GapCellTest {

  private GapCell gapCell;
  private GapCell sameRefCell;
  private GapCell sameStateCell;
  private GapCell yetAnotherCell;
  private GapCell diffCell;
  private GapCell nullCell;

  @Before
  public void setUp() throws Exception {
    gapCell = new GapCell(true);
    sameRefCell = gapCell;
    sameStateCell = new GapCell(true);
    yetAnotherCell = new GapCell(true);
    diffCell = new GapCell(false);
    nullCell = null;
  }

  @Test
  public void canPlacedShip() {
    assertFalse(gapCell.canPlacedShip());
  }


  @Test
  public void testEquals() {
    Assert.assertTrue(gapCell.equals(gapCell));
    Assert.assertTrue(gapCell.equals(sameRefCell));
    Assert.assertTrue(gapCell.equals(sameStateCell));
    Assert.assertTrue(sameStateCell.equals(gapCell));
    Assert.assertEquals(gapCell.equals(sameStateCell), sameStateCell.equals(gapCell));
    Assert.assertEquals(gapCell.equals(sameStateCell)&& sameStateCell.equals(yetAnotherCell), yetAnotherCell.equals(gapCell));
    Assert.assertFalse(gapCell.equals(diffCell));
    Assert.assertFalse(gapCell.equals(new Integer(1)));
    Assert.assertFalse(gapCell.equals(nullCell));}

  @Test
  public void testHashCode() {
    Assert.assertEquals(gapCell.equals(sameRefCell), gapCell.hashCode()== sameRefCell.hashCode());
    Assert.assertEquals(gapCell.equals(sameStateCell), gapCell.hashCode()== sameStateCell.hashCode());
  }

  @Test
  public void toStringTest() {
    String temp = "GapCell{" +
        "isHitShip=" + gapCell.getIsHit() +
        '}';
    assertEquals(temp, gapCell.toString());
  }
}