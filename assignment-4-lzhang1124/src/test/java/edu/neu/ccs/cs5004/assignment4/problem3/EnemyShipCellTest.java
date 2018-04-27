package edu.neu.ccs.cs5004.assignment4.problem3;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class EnemyShipCellTest {

  EnemyShipCell enemyShipCell;
  EnemyShipCell sameRefAbsCell;
  EnemyShipCell sameStateAbsCell;
  MarkSunk markSunk;

  @Before
  public void setUp() throws Exception {
    markSunk = new Sunk();
    enemyShipCell = new EnemyShipCell(true, markSunk, true);
    sameRefAbsCell = enemyShipCell;
    sameStateAbsCell = new EnemyShipCell(true, markSunk, true);

  }

  @Test
  public void getSunkShip() {
    assertTrue(enemyShipCell.getSunkShip());
  }

  @Test
  public void attackResult() {
    assertEquals(new Miss(), enemyShipCell.attackResult());
  }

  @Test
  public void attack() {
    AbstractShip afterAttackShip = new Submarine(2, 1);
    Cell afterAttackCell = new EnemyShipCell(true, markSunk, true);
    assertEquals(afterAttackCell, enemyShipCell.attack());
  }

  @Test
  public void testEquals() throws Exception {
    AbstractShip newship = new Destoryer(1, 0);
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
  public void testHashCode() throws Exception {
    Assert.assertEquals(enemyShipCell.equals(sameRefAbsCell), enemyShipCell.hashCode() == sameRefAbsCell.hashCode()); //same objects have the same hashCode
    Assert.assertEquals(enemyShipCell.equals(sameStateAbsCell), enemyShipCell.hashCode() == sameStateAbsCell.hashCode()); //equal objects have the same hashCode
    EnemyShipCell diffAbsCell3 = new EnemyShipCell(true, null, null);
    assertFalse(enemyShipCell.hashCode() == diffAbsCell3.hashCode());
  }

  @Test
  public void toStringTest() {
    String temp = "EnemyShipCell{" +
        "sunkShip=" + enemyShipCell.getSunkShip() +
        ", markSunk=" + markSunk +
        ", isHit=" + enemyShipCell.isHit +
        '}';
    assertEquals(temp, enemyShipCell.toString());
  }
}