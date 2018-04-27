package edu.neu.ccs.cs5004.Problem2;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EnemyShipCellTest {

    EnemyShipCell enemyShipCell;
    EnemyShipCell sameRefAbsCell;
    EnemyShipCell sameStateAbsCell;
    Ship ship;
    markSunk markSunk;

    @Before
    public void setUp() throws Exception {
        ship = new Submarine(2, 2);
        markSunk = new Sunk();
        enemyShipCell = new EnemyShipCell(true, true, ship, markSunk, true);
        sameRefAbsCell = enemyShipCell;
        sameStateAbsCell = new EnemyShipCell(true, true, ship, markSunk, true);

    }

    @Test
    public void getSunkShip() {
    }

    @Test
    public void testEquals() throws Exception {
        AbstractShip newship = new Destoryer(1, 0);
        markSunk sunk = new NotSunk();
        EnemyShipCell nullAbsCell = null;
        EnemyShipCell yetAnotherAbsCell = new EnemyShipCell(true, true, ship, markSunk, true);
        EnemyShipCell diffAbsCell1 = new EnemyShipCell(false, true, ship, sunk, false);
        ;
        EnemyShipCell diffAbsCell2 = new EnemyShipCell(true, false, newship, sunk, false);

        Assert.assertTrue(enemyShipCell.equals(enemyShipCell)); // reflexivity
        Assert.assertTrue(enemyShipCell.equals(sameRefAbsCell)); // trivial condition both reference the same object
        Assert.assertEquals(enemyShipCell.equals(sameStateAbsCell), sameStateAbsCell.equals(enemyShipCell)); //symmetry
        Assert.assertEquals(enemyShipCell.equals(sameStateAbsCell) &&
                sameStateAbsCell.equals(yetAnotherAbsCell), yetAnotherAbsCell.equals(enemyShipCell)); //transitivity
        Assert.assertFalse(enemyShipCell.equals(diffAbsCell1));
        Assert.assertFalse(enemyShipCell.equals(diffAbsCell2));
        Assert.assertFalse(enemyShipCell.equals(nullAbsCell));
    }

    @Test
    public void testHashCode() throws Exception {
        Assert.assertEquals(enemyShipCell.equals(sameRefAbsCell), enemyShipCell.hashCode() == sameRefAbsCell.hashCode()); //same objects have the same hashCode
        Assert.assertEquals(enemyShipCell.equals(sameStateAbsCell), enemyShipCell.hashCode() == sameStateAbsCell.hashCode()); //equal objects have the same hashCode

    }

    @Test
    public void toStringTest() {
        String temp = "EnemyShipCell{" +
                "sunkShip=" + enemyShipCell.getSunkShip() +
                ", ship=" + enemyShipCell.ship +
                ", markSunk=" + enemyShipCell.markSunk +
                ", isHit=" + enemyShipCell.isHit +
                ", hasShip=" + enemyShipCell.hasShip +
                '}';
        assertEquals(temp, enemyShipCell.toString());
    }
}