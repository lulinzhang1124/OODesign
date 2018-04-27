package edu.neu.ccs.cs5004.assignment5.battleship.cells;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import edu.neu.ccs.cs5004.assignment5.battleship.ships.AbstractShip;
import edu.neu.ccs.cs5004.assignment5.battleship.ships.Destroyer;
import edu.neu.ccs.cs5004.assignment5.battleship.ships.Ship;
import edu.neu.ccs.cs5004.assignment5.battleship.ships.Submarine;
import edu.neu.ccs.cs5004.assignment5.battleship.viewer.ConsolePrinter;
import edu.neu.ccs.cs5004.assignment5.battleship.viewer.Printer;

import static org.junit.Assert.*;

public class EnemyShipCellTest {
  EnemyShipCell enemyShipCell;
  EnemyShipCell sameRefAbsCell;
  EnemyShipCell sameStateAbsCell;
  MarkSunk markSunk;
  Printer printer;
  Ship ship;

  @Before
  public void setUp() throws Exception {
    markSunk = new Sunk();
    enemyShipCell = new EnemyShipCell(true, markSunk, true);
    sameRefAbsCell = enemyShipCell;
    sameStateAbsCell = new EnemyShipCell(true, markSunk, true);
    printer = new ConsolePrinter();
    ship = new Submarine(2,0);

  }

  @Test
  public void getSunkShip() {
    assertTrue(enemyShipCell.getSunkShip());
  }

  @Test
  public void update() {
    enemyShipCell.update(ship);

  }

  @Test
  public void prettyPrint() {
    enemyShipCell.prettyPrint(printer);
  }

  @Test
  public void attackResult() {
    assertEquals(new Miss(), enemyShipCell.attackResult());
  }

  @Test
  public void testEquals() {
    AbstractShip newship = new Destroyer(1, 0);
    MarkSunk sunk = new NotSunk();
    EnemyShipCell nullAbsCell = null;
    EnemyShipCell yetAnotherAbsCell = new EnemyShipCell(true, markSunk, true);
    EnemyShipCell diffAbsCell1 = new EnemyShipCell(false, markSunk, true);
    EnemyShipCell diffAbsCell2 = new EnemyShipCell(true, new NotSunk(), null);
    EnemyShipCell diffAbsCell3 = new EnemyShipCell(true, new NotSunk(), null);

    Assert.assertTrue(enemyShipCell.equals(enemyShipCell)); // reflexivity
    Assert.assertTrue(enemyShipCell.equals(sameRefAbsCell)); // trivial condition both reference the same object
    Assert.assertEquals(enemyShipCell.equals(sameStateAbsCell), sameStateAbsCell.equals(enemyShipCell)); //symmetry
    Assert.assertEquals(enemyShipCell.equals(sameStateAbsCell) &&
            sameStateAbsCell.equals(yetAnotherAbsCell), yetAnotherAbsCell.equals(enemyShipCell)); //transitivity
    Assert.assertFalse(enemyShipCell.equals(diffAbsCell1));
    Assert.assertFalse(enemyShipCell.equals(diffAbsCell2));
    Assert.assertFalse(enemyShipCell.equals(nullAbsCell));
    assertFalse(enemyShipCell.equals(new Integer(3)));
    Assert.assertTrue(enemyShipCell.equals(sameStateAbsCell));
    assertFalse(diffAbsCell3.equals(enemyShipCell));
    assertTrue(diffAbsCell2.equals(diffAbsCell3));
  }

  @Test
  public void testHashCode() {
    Assert.assertEquals(enemyShipCell.equals(sameRefAbsCell), enemyShipCell.hashCode() == sameRefAbsCell.hashCode()); //same objects have the same hashCode
    Assert.assertEquals(enemyShipCell.equals(sameStateAbsCell), enemyShipCell.hashCode() == sameStateAbsCell.hashCode()); //equal objects have the same hashCode
    EnemyShipCell diffAbsCell3 = new EnemyShipCell(true, null, null);
    assertFalse(enemyShipCell.hashCode() == diffAbsCell3.hashCode());
  }

  @Test
  public void testToString() {
    String temp = "EnemyShipCell{" +
            "sunkShip=" + enemyShipCell.getSunkShip() +
            ", markSunk=" + markSunk +
            ", isHitShip=" + enemyShipCell.getIsHit() +
            '}';
    assertEquals(temp, enemyShipCell.toString());
  }
}