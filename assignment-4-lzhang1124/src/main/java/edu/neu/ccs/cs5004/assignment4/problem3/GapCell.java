package edu.neu.ccs.cs5004.assignment4.problem3;

/**
 * Represents a gap cell.
 */

public class GapCell extends AbstractWaterCell {

  public GapCell(Boolean isHit) {
    super(isHit);
  }

  @Override
  public Boolean canPlacedShip() {
    return false;
  }


  @Override
  public String toString() {
    return "GapCell{" + "isHit=" + isHit + '}';
  }
}
