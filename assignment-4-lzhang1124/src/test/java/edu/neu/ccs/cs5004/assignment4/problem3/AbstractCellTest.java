package edu.neu.ccs.cs5004.assignment4.problem3;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class AbstractCellTest {
  AbstractCell AbsCell;
  AbstractCell sameRefAbsCell;
  AbstractCell sameStateAbsCell;
  Boolean isHit;

  @Before
  public void setUp() throws Exception {
    isHit = false;
    AbsCell = new OpenSeaCell(isHit);
    sameRefAbsCell = AbsCell;
    sameStateAbsCell = new OpenSeaCell(isHit);

  }

  @Test
  public void getIsHit() {
    Assert.assertFalse(AbsCell.getIsHit());
  }

  @Test
  public void attack() {
    AbstractCell temp = new OpenSeaCell(true);
    Assert.assertEquals(temp, AbsCell.attack());
  }

  @Test
  public void testEquals() throws Exception {
    AbstractCell nullAbsCell = null;
    AbstractCell yetAnotherAbsCell = new OpenSeaCell(isHit);
    AbstractCell diffAbsCell1 = new OpenSeaCell(true);
    AbstractCell diffAbsCell2 = new OpenSeaCell(null);
    AbstractCell diffAbsCell3 = new OpenSeaCell(null);

    Assert.assertTrue(AbsCell.equals(AbsCell)); // reflexivity
    Assert.assertTrue(AbsCell.equals(sameRefAbsCell)); // trivial condition both reference the same object
    Assert.assertEquals(AbsCell.equals(sameStateAbsCell), sameStateAbsCell.equals(AbsCell)); //symmetry
    Assert.assertEquals(AbsCell.equals(sameStateAbsCell) &&
        sameStateAbsCell.equals(yetAnotherAbsCell), yetAnotherAbsCell.equals(AbsCell)); //transitivity
    Assert.assertFalse(AbsCell.equals(diffAbsCell1));
    Assert.assertFalse(AbsCell.equals(nullAbsCell));
    Assert.assertFalse(AbsCell.equals(new Integer(3)));
    Assert.assertTrue(AbsCell.equals(sameStateAbsCell));
    Assert.assertFalse(diffAbsCell2.equals(diffAbsCell1));
    Assert.assertTrue(diffAbsCell2.equals(diffAbsCell3));

  }

  @Test
  public void testHashCode() throws Exception {
    Assert.assertEquals(AbsCell.equals(sameRefAbsCell), AbsCell.hashCode() == sameRefAbsCell.hashCode()); //same objects have the same hashCode
    Assert.assertEquals(AbsCell.equals(sameStateAbsCell), AbsCell.hashCode() == sameStateAbsCell.hashCode()); //equal objects have the same hashCode
    AbstractCell diffAbsCell2 = new OpenSeaCell(null);
    Assert.assertFalse(diffAbsCell2.hashCode() == AbsCell.hashCode());
  }


}