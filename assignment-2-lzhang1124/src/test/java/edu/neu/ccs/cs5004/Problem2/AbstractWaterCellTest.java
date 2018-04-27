package edu.neu.ccs.cs5004.Problem2;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AbstractWaterCellTest {

    AbstractWaterCell AbsWaterCell;
    AbstractWaterCell sameRefAbsCell;
    AbstractWaterCell sameStateAbsCell;
    Boolean isHit;
    Boolean hasShip;

    @Before
    public void setUp() throws Exception {
        isHit = false;
        hasShip = false;
        AbsWaterCell = new OpenSeaCell(isHit, hasShip, false);
        sameRefAbsCell = AbsWaterCell;
        sameStateAbsCell = new OpenSeaCell(isHit, hasShip, false);

    }

    @Test
    public void getHasAdjacentCell() {
        Assert.assertFalse(AbsWaterCell.hasAdjacentCell);
    }

    @Test
    public void canPlacedShip() {
        Assert.assertTrue(AbsWaterCell.canPlacedShip());
    }

    @Test
    public void attackResult() {
        Assert.assertEquals("Miss", AbsWaterCell.attackResult());
    }

    @Test
    public void testEquals() throws Exception {
        //the variables below are requried only for this test, hence NO need to set it as a field.
        AbstractWaterCell nullAbsCell = null;
        AbstractWaterCell yetAnotherAbsCell = new OpenSeaCell(false, false, false);
        AbstractWaterCell diffAbsCell1 = new OpenSeaCell(true, false, false);

        Assert.assertTrue(AbsWaterCell.equals(AbsWaterCell)); // reflexivity
        Assert.assertTrue(AbsWaterCell.equals(sameRefAbsCell)); // trivial condition both reference the same object
        Assert.assertEquals(AbsWaterCell.equals(sameStateAbsCell), sameStateAbsCell.equals(AbsWaterCell)); //symmetry
        Assert.assertEquals(AbsWaterCell.equals(sameStateAbsCell) &&
                sameStateAbsCell.equals(yetAnotherAbsCell), yetAnotherAbsCell.equals(AbsWaterCell)); //transitivity
        Assert.assertFalse(AbsWaterCell.equals(diffAbsCell1));
        Assert.assertFalse(AbsWaterCell.equals(nullAbsCell));
    }

    @Test
    public void testHashCode() throws Exception {
        Assert.assertEquals(AbsWaterCell.equals(sameRefAbsCell), AbsWaterCell.hashCode() == sameRefAbsCell.hashCode()); //same objects have the same hashCode
        Assert.assertEquals(AbsWaterCell.equals(sameStateAbsCell), AbsWaterCell.hashCode() == sameStateAbsCell.hashCode()); //equal objects have the same hashCode

    }

}