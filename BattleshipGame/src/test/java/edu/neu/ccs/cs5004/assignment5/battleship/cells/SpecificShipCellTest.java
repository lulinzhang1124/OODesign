package edu.neu.ccs.cs5004.assignment5.battleship.cells;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import edu.neu.ccs.cs5004.assignment5.battleship.ships.AbstractShip;
import edu.neu.ccs.cs5004.assignment5.battleship.ships.Battleship;
import edu.neu.ccs.cs5004.assignment5.battleship.ships.Destroyer;
import edu.neu.ccs.cs5004.assignment5.battleship.ships.Ship;
import edu.neu.ccs.cs5004.assignment5.battleship.viewer.ConsolePrinter;
import edu.neu.ccs.cs5004.assignment5.battleship.viewer.Printer;

import static org.junit.Assert.*;

public class SpecificShipCellTest {

  SpecificShipCell specificShipCell;
  SpecificShipCell sameRefAbsCell;
  SpecificShipCell sameStateAbsCell;
  SpecificShipCell diffCell;
  Ship ship;
  Ship ship2;
  MarkSunk markSunk;
  Printer printer;

  @Before
  public void setUp() throws Exception {
    ship = new Battleship(4, 2);
    ship2 = new Battleship(4,4);
    markSunk = new NotSunk();
    specificShipCell = new SpecificShipCell(false, markSunk, ship);
    sameRefAbsCell = specificShipCell;
    sameStateAbsCell = new SpecificShipCell(false, markSunk, ship);
    diffCell = new SpecificShipCell(true, markSunk, ship2);
    printer = new ConsolePrinter();

  }

  @Test
  public void getMarkSunk() {

    Assert.assertEquals(markSunk,specificShipCell.getMarkSunk());
    Assert.assertEquals(new Sunk(),diffCell.getMarkSunk());


  }

  @Test
  public void prettyPrint() {
    specificShipCell.prettyPrint(printer);
  }

  @Test
  public void getShip() {
    assertEquals(ship, specificShipCell.getShip());
  }

  @Test
  public void attackResult() {
    assertEquals(new Hit(), specificShipCell.attackResult());
    Ship newship = new Battleship(4, 4);
    SpecificShipCell temp = new SpecificShipCell(true, new Sunk(), newship);

    assertEquals(new ResultSunk(), temp.attackResult());

}

  @Test
  public void attack() {
    AbstractShip afterAttackShip = new Battleship(4, 3);
    Cell afterAttackCell = new SpecificShipCell(true, markSunk, afterAttackShip);
    assertEquals(afterAttackCell, specificShipCell.attack());

  }

  @Test
  public void testEquals() {
    AbstractShip newship = new Destroyer(1, 0);
    MarkSunk sunk = new Sunk();
    SpecificShipCell nullAbsCell = null;
    SpecificShipCell yetAnotherAbsCell = new SpecificShipCell(false, markSunk, ship);
    SpecificShipCell diffAbsCell1 = new SpecificShipCell(true, markSunk, ship);
    SpecificShipCell diffAbsCell2 = new SpecificShipCell(false, sunk, ship);
    SpecificShipCell diffAbsCell3 = new SpecificShipCell(false, markSunk, newship);
    SpecificShipCell diffAbsCell4 = new SpecificShipCell(false, markSunk, null);
    SpecificShipCell diffAbsCell5 = new SpecificShipCell(false, markSunk, null);

    Assert.assertTrue(specificShipCell.equals(specificShipCell)); // reflexivity
    Assert.assertTrue(specificShipCell.equals(sameRefAbsCell));// trivial condition both reference the same object
    Assert.assertTrue(specificShipCell.equals(sameStateAbsCell));
    assertEquals(specificShipCell.equals(sameStateAbsCell), sameStateAbsCell.equals(specificShipCell)); //symmetry
    assertEquals(specificShipCell.equals(sameStateAbsCell) &&
            sameStateAbsCell.equals(yetAnotherAbsCell), yetAnotherAbsCell.equals(specificShipCell)); //transitivity
    Assert.assertFalse(specificShipCell.equals(diffAbsCell1));
    Assert.assertFalse(specificShipCell.equals(diffAbsCell2));
    Assert.assertFalse(specificShipCell.equals(diffAbsCell3));
    Assert.assertFalse(specificShipCell.equals(nullAbsCell));
    Assert.assertFalse(specificShipCell.equals(new Integer(1)));
    Assert.assertFalse(diffAbsCell4.equals(specificShipCell));
    Assert.assertTrue(diffAbsCell4.equals(diffAbsCell5));

  }

  @Test
  public void testHashCode() {
    assertEquals(specificShipCell.equals(sameRefAbsCell), specificShipCell.hashCode() == sameRefAbsCell.hashCode()); //same objects have the same hashCode
    assertEquals(specificShipCell.equals(sameStateAbsCell), specificShipCell.hashCode() == sameStateAbsCell.hashCode()); //equal objects have the same hashCode
    SpecificShipCell diffAbsCell5 = new SpecificShipCell(false, markSunk, null);
    diffAbsCell5.hashCode();
  }

  @Test
  public void testToString() {
    String temp = "SpecificShipCell{" +
            "ship=" + specificShipCell.getShip() +
            ", markSunk=" + markSunk +
            ", isHitShip=" + specificShipCell.getIsHit() +
            '}';
    assertEquals(temp, specificShipCell.toString());

  }
}