package edu.neu.ccs.cs5004.assignment5.battleship.cells;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import edu.neu.ccs.cs5004.assignment5.battleship.viewer.ConsolePrinter;
import edu.neu.ccs.cs5004.assignment5.battleship.viewer.Printer;

public class AbstractWaterCellTest {

  AbstractWaterCell absWaterCell;
  AbstractWaterCell sameRefAbsCell;
  AbstractWaterCell sameStateAbsCell;
  AbstractWaterCell yetAnotherAbsCell;
  AbstractWaterCell diffCell;
  AbstractWaterCell nullCell;
  Boolean isHit;
  Printer printer;


  @Before
  public void setUp() throws Exception {
    isHit = false;
    absWaterCell = new OpenSeaCell(isHit);
    sameRefAbsCell = absWaterCell;
    sameStateAbsCell = new OpenSeaCell(isHit);
    yetAnotherAbsCell = new OpenSeaCell(isHit);
    diffCell = new GapCell(isHit);
    nullCell = null;
    printer = new ConsolePrinter();
  }

  @Test
  public void attackResult() {
    Assert.assertEquals(new Miss(), absWaterCell.attackResult());
  }

  @Test
  public void prettyPrint() {
    absWaterCell.prettyPrint(printer);
  }

  @Test
  public void testEquals() {
    Assert.assertTrue(absWaterCell.equals(absWaterCell)); // reflexivity
    Assert.assertTrue(absWaterCell.equals(sameRefAbsCell));
    Assert.assertTrue(absWaterCell.equals(sameStateAbsCell));
    Assert.assertEquals(absWaterCell.equals(sameStateAbsCell), sameStateAbsCell.equals(absWaterCell)); //symmetry
    Assert.assertEquals(absWaterCell.equals(sameStateAbsCell) &&
            sameStateAbsCell.equals(yetAnotherAbsCell), yetAnotherAbsCell.equals(absWaterCell)); //transitivity
    Assert.assertFalse(absWaterCell.equals(diffCell));
    Assert.assertFalse(absWaterCell.equals(nullCell));
    Assert.assertFalse(absWaterCell.equals(new Integer(3)));
  }

  @Test
  public void testHashCode() {

    Assert.assertEquals(absWaterCell.equals(sameRefAbsCell), absWaterCell.hashCode() == sameRefAbsCell.hashCode()); //same objects have the same hashCode
    Assert.assertEquals(absWaterCell.equals(sameStateAbsCell), absWaterCell.hashCode() == sameStateAbsCell.hashCode()); //equal objects have the same hashCode

  }
}