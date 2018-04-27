package edu.neu.ccs.cs5004.assignment4.problem3;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AbstractWaterCellTest {

  AbstractWaterCell AbsWaterCell;
  AbstractWaterCell sameRefAbsCell;
  AbstractWaterCell sameStateAbsCell;
  Boolean isHit;

  @Before
  public void setUp() throws Exception {
    isHit = false;
    AbsWaterCell = new OpenSeaCell(isHit);
    sameRefAbsCell = AbsWaterCell;
    sameStateAbsCell = new OpenSeaCell(isHit);

  }


  @Test
  public void attackResult() {
    Assert.assertEquals(new Miss(), AbsWaterCell.attackResult());
  }

}