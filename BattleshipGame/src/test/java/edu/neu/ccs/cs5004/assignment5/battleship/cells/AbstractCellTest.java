package edu.neu.ccs.cs5004.assignment5.battleship.cells;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import edu.neu.ccs.cs5004.assignment5.battleship.ships.Submarine;

public class AbstractCellTest {

  private AbstractCell AbsCell;
  private AbstractCell sameRefAbsCell;
  private AbstractCell sameStateAbsCell;
  private Boolean isHit;

  @Before
  public void setUp() throws Exception {
    isHit = false;
    AbsCell = new OpenSeaCell(isHit);
    sameRefAbsCell = AbsCell;
    sameStateAbsCell = new OpenSeaCell(isHit);
  }

  @Test
  public void update() {
    AbsCell.update(new Submarine(3,2));
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
  public void testEquals() {
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
  public void testHashCode() {

    Assert.assertEquals(AbsCell.equals(sameRefAbsCell), AbsCell.hashCode() == sameRefAbsCell.hashCode()); //same objects have the same hashCode
    Assert.assertEquals(AbsCell.equals(sameStateAbsCell), AbsCell.hashCode() == sameStateAbsCell.hashCode()); //equal objects have the same hashCode

  }
}