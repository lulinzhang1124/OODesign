package edu.neu.ccs.cs5004.assignment4.problem3;

/**
 * Represents an open sea cell.
 */
public class OpenSeaCell extends AbstractWaterCell {

  public OpenSeaCell(Boolean isHit) {
    super(isHit);
  }

  @Override
  public Boolean canPlacedShip() {
    return true;
  }

  @Override
  public String toString() {
    return "OpenSeaCell{" + "isHit=" + isHit
        + '}';
  }
}
