package edu.neu.ccs.cs5004.Problem2;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class AbstractShipTest {

    AbstractShip absShip;
    AbstractShip sameRefAbsCell;
    AbstractShip sameStateAbsCell;

    @Before
    public void setUp() throws Exception {

        absShip = new Battleship(4, 1);
        sameRefAbsCell = absShip;
        sameStateAbsCell = new Battleship(4, 1);

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
    public void testEquals() throws Exception {
        //the variables below are requried only for this test, hence NO need to set it as a field.
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
        Assert.assertFalse(absShip.equals(nullAbsCell));
    }

    @Test
    public void testHashCode() throws Exception {
        Assert.assertEquals(absShip.equals(sameRefAbsCell), absShip.hashCode() == sameRefAbsCell.hashCode()); //same objects have the same hashCode
        Assert.assertEquals(absShip.equals(sameStateAbsCell), absShip.hashCode() == sameStateAbsCell.hashCode()); //equal objects have the same hashCode

    }
}