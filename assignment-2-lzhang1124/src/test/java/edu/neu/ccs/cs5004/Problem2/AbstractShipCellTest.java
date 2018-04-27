package edu.neu.ccs.cs5004.Problem2;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class AbstractShipCellTest {

    AbstractShipCell AbsShipCell;
    AbstractShipCell sameRefAbsCell;
    AbstractShipCell sameStateAbsCell;
    Ship ship;
    markSunk markSunk;

    @Before
    public void setUp() throws Exception {
        ship = new Submarine(2, 0);
        markSunk = new NotSunk();
        AbsShipCell = new SpecificShipCell(false, true, ship, markSunk);
        sameRefAbsCell = AbsShipCell;
        sameStateAbsCell = new SpecificShipCell(false, true, ship, markSunk);

    }

    @Test
    public void getShip() {
        assertEquals(ship, AbsShipCell.getShip());
    }

    @Test
    public void getMarkSunk() {
        assertEquals(markSunk, AbsShipCell.getMarkSunk());
    }

    @Test
    public void attackResult() {
        assertEquals("Hit", AbsShipCell.attackResult());
    }

    @Test
    public void canPlacedShip() {
        assertFalse(AbsShipCell.canPlacedShip());
    }

    @Test
    public void attack() {
        AbstractShip afterAttackShip = new Submarine(2, 1);
        Cell afterAttackCell = new SpecificShipCell(true, true, afterAttackShip, markSunk);
        assertEquals(afterAttackCell, AbsShipCell.attack());
    }

    @Test
    public void testEquals() throws Exception {
        AbstractShip newship = new Destoryer(1, 0);
        markSunk sunk = new Sunk();
        AbstractShipCell nullAbsCell = null;
        AbstractShipCell yetAnotherAbsCell = new SpecificShipCell(false, true, ship, markSunk);
        AbstractShipCell diffAbsCell1 = new SpecificShipCell(true, true, ship, markSunk);
        AbstractShipCell diffAbsCell2 = new SpecificShipCell(false, true, newship, markSunk);
        AbstractShipCell diffAbsCell3 = new SpecificShipCell(false, true, ship, sunk);

        Assert.assertTrue(AbsShipCell.equals(AbsShipCell)); // reflexivity
        Assert.assertTrue(AbsShipCell.equals(sameRefAbsCell)); // trivial condition both reference the same object
        Assert.assertEquals(AbsShipCell.equals(sameStateAbsCell), sameStateAbsCell.equals(AbsShipCell)); //symmetry
        Assert.assertEquals(AbsShipCell.equals(sameStateAbsCell) &&
                sameStateAbsCell.equals(yetAnotherAbsCell), yetAnotherAbsCell.equals(AbsShipCell)); //transitivity
        Assert.assertFalse(AbsShipCell.equals(diffAbsCell1));
        Assert.assertFalse(AbsShipCell.equals(diffAbsCell2));
        Assert.assertFalse(AbsShipCell.equals(diffAbsCell3));
        Assert.assertFalse(AbsShipCell.equals(nullAbsCell));
    }

    @Test
    public void testHashCode() throws Exception {
        Assert.assertEquals(AbsShipCell.equals(sameRefAbsCell), AbsShipCell.hashCode() == sameRefAbsCell.hashCode()); //same objects have the same hashCode
        Assert.assertEquals(AbsShipCell.equals(sameStateAbsCell), AbsShipCell.hashCode() == sameStateAbsCell.hashCode()); //equal objects have the same hashCode

    }
}