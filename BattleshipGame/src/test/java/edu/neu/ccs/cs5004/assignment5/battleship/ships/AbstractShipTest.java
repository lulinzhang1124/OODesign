package edu.neu.ccs.cs5004.assignment5.battleship.ships;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


import edu.neu.ccs.cs5004.assignment5.battleship.cells.Cell;
import edu.neu.ccs.cs5004.assignment5.battleship.cells.NotSunk;
import edu.neu.ccs.cs5004.assignment5.battleship.cells.SpecificShipCell;

import static org.junit.Assert.*;

public class AbstractShipTest {

  AbstractShip absShip;
  AbstractShip sameRefAbsCell;
  AbstractShip sameStateAbsCell;
  Cell observer;
  Ship ship;

  @Before
  public void setUp() throws Exception {
    absShip = new Battleship(4, 1);
    sameRefAbsCell = absShip;
    sameStateAbsCell = new Battleship(4, 1);
    ship = new Battleship(4,3);
    observer = new SpecificShipCell(true,new NotSunk(),ship);
  }

  @Test
  public void registerObserver() {
    absShip.registerObserver(observer);

  }

  @Test
  public void notifyObservers() {
    absShip.notifyObservers();
  }

  @Test
  public void removeObserver() {
    absShip.registerObserver(observer);
  }

  @Test
  public void size() {
    assertEquals(new Integer(4), absShip.getSize());
  }

  @Test
  public void getSize() {
    assertEquals(new Integer(4), absShip.getSize());
  }

  @Test
  public void getNumberHitCells() {
    assertEquals(new Integer(1), absShip.getNumberHitCells());

  }

  @Test
  public void isSunk() {
    assertFalse(absShip.isSunk());
  }

  @Test
  public void hitShip() {
    Ship updateShip = new Battleship(4, 2);
    assertEquals(updateShip, absShip.hitShip());
  }

  @Test
  public void testEquals() {
    AbstractShip nullAbsCell = null;
    AbstractShip yetAnotherAbsCell = new Battleship(4, 1);
    AbstractShip diffAbsCell1 = new Submarine(2, 1);
    AbstractShip diffAbsCell2 = new Battleship(4, 0);

    Assert.assertTrue(absShip.equals(absShip)); // reflexivity
    Assert.assertTrue(absShip.equals(sameRefAbsCell)); // trivial condition both reference the same object
    Assert.assertEquals(absShip.equals(sameStateAbsCell), sameStateAbsCell.equals(absShip)); //symmetry
    Assert.assertEquals(absShip.equals(sameStateAbsCell) &&
            sameStateAbsCell.equals(yetAnotherAbsCell), yetAnotherAbsCell.equals(absShip)); //transitivity
    Assert.assertFalse(absShip.equals(diffAbsCell1));
    Assert.assertFalse(absShip.equals(diffAbsCell2));
    Assert.assertFalse(absShip.equals(new Integer(1)));
    Assert.assertFalse(absShip.equals(nullAbsCell));

  }

  @Test
  public void testHashCode() {
    Assert.assertEquals(absShip.equals(sameRefAbsCell), absShip.hashCode() == sameRefAbsCell.hashCode()); //same objects have the same hashCode
    Assert.assertEquals(absShip.equals(sameStateAbsCell), absShip.hashCode() == sameStateAbsCell.hashCode()); //equal objects have the same hashCode

  }
}