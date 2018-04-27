package edu.neu.ccs.cs5004.Problem2;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class AbstractCellTest {
    AbstractCell AbsCell;
    AbstractCell sameRefAbsCell;
    AbstractCell sameStateAbsCell;
    Boolean isHit;
    Boolean hasShip;

    @Before
    public void setUp() throws Exception {
        isHit = false;
        hasShip = false;
        AbsCell = new OpenSeaCell(isHit, hasShip, false);
        sameRefAbsCell = AbsCell;
        sameStateAbsCell = new OpenSeaCell(isHit, hasShip, false);

    }

    @Test
    public void getIsHit() {
        Assert.assertFalse(AbsCell.getIsHit());
    }

    @Test
    public void getHasShip() {
        Assert.assertFalse(AbsCell.getHasShip());
    }

    @Test
    public void attack() {
        AbstractCell temp = new OpenSeaCell(true, false, false);
        Assert.assertEquals(temp, AbsCell.attack());
    }

    @Test
    public void testEquals() throws Exception {
        //the variables below are requried only for this test, hence NO need to set it as a field.
        AbstractCell nullAbsCell = null;
        AbstractCell yetAnotherAbsCell = new OpenSeaCell(false, false, false);
        AbstractCell diffAbsCell1 = new OpenSeaCell(true, false, false);

        Assert.assertTrue(AbsCell.equals(AbsCell)); // reflexivity
        Assert.assertTrue(AbsCell.equals(sameRefAbsCell)); // trivial condition both reference the same object
        Assert.assertEquals(AbsCell.equals(sameStateAbsCell), sameStateAbsCell.equals(AbsCell)); //symmetry
        Assert.assertEquals(AbsCell.equals(sameStateAbsCell) &&
                sameStateAbsCell.equals(yetAnotherAbsCell), yetAnotherAbsCell.equals(AbsCell)); //transitivity
        Assert.assertFalse(AbsCell.equals(diffAbsCell1));
        Assert.assertFalse(AbsCell.equals(nullAbsCell));
    }

    @Test
    public void testHashCode() throws Exception {
        Assert.assertEquals(AbsCell.equals(sameRefAbsCell), AbsCell.hashCode() == sameRefAbsCell.hashCode()); //same objects have the same hashCode
        Assert.assertEquals(AbsCell.equals(sameStateAbsCell), AbsCell.hashCode() == sameStateAbsCell.hashCode()); //equal objects have the same hashCode

    }


}