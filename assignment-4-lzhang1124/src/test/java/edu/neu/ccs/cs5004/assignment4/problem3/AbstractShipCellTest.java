package edu.neu.ccs.cs5004.assignment4.problem3;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class AbstractShipCellTest {

  AbstractShipCell AbsShipCell;
  AbstractShipCell sameRefAbsCell;
  AbstractShipCell sameStateAbsCell;
  MarkSunk markSunk;
  Ship ship;

  @Before
  public void setUp() throws Exception {
    ship = new Submarine(2, 0);
    markSunk = new NotSunk();
    AbsShipCell = new SpecificShipCell(false, markSunk, ship);
    sameRefAbsCell = AbsShipCell;
    sameStateAbsCell = new SpecificShipCell(false, markSunk, ship);

  }


  @Test
  public void getMarkSunk() {
    assertEquals(markSunk, AbsShipCell.getMarkSunk());
  }


  @Test
  public void canPlacedShip() {
    assertFalse(AbsShipCell.canPlacedShip());
  }


  @Test
  public void testEquals() throws Exception {
    AbstractShip newship = new Destoryer(1, 0);
    MarkSunk sunk = new Sunk();
    AbstractShipCell nullAbsCell = null;
    AbstractShipCell yetAnotherAbsCell = new SpecificShipCell(false, markSunk, ship);
    AbstractShipCell diffAbsCell1 = new SpecificShipCell(true, markSunk, ship);
    AbstractShipCell diffAbsCell2 = new SpecificShipCell(false, sunk, ship);
    AbstractShipCell diffAbsCell3 = new SpecificShipCell(false, markSunk, newship);
    AbstractShipCell diffAbsCell4 = new SpecificShipCell(false, null, ship);
    AbstractShipCell diffAbsCell5 = new SpecificShipCell(false, null, ship);

    Assert.assertTrue(AbsShipCell.equals(AbsShipCell)); // reflexivity
    Assert.assertTrue(AbsShipCell.equals(sameRefAbsCell));
    assertTrue(AbsShipCell.equals(sameStateAbsCell));
    Assert.assertEquals(AbsShipCell.equals(sameStateAbsCell), sameStateAbsCell.equals(AbsShipCell)); //symmetry
    Assert.assertEquals(AbsShipCell.equals(sameStateAbsCell) &&
        sameStateAbsCell.equals(yetAnotherAbsCell), yetAnotherAbsCell.equals(AbsShipCell)); //transitivity
    Assert.assertFalse(AbsShipCell.equals(diffAbsCell1));
    Assert.assertFalse(AbsShipCell.equals(diffAbsCell2));
    Assert.assertFalse(AbsShipCell.equals(diffAbsCell3));
    Assert.assertFalse(AbsShipCell.equals(nullAbsCell));
    Assert.assertFalse(AbsShipCell.equals(new Integer(3)));
    assertFalse(diffAbsCell4.equals(AbsShipCell));
    assertTrue(diffAbsCell4.equals(diffAbsCell5));
  }

  @Test
  public void testHashCode() throws Exception {
    Assert.assertEquals(AbsShipCell.equals(sameRefAbsCell), AbsShipCell.hashCode() == sameRefAbsCell.hashCode()); //same objects have the same hashCode
    Assert.assertEquals(AbsShipCell.equals(sameStateAbsCell), AbsShipCell.hashCode() == sameStateAbsCell.hashCode()); //equal objects have the same hashCode
    AbstractShipCell diffAbsCell4 = new SpecificShipCell(false, null, ship);
    diffAbsCell4.hashCode();
  }
}