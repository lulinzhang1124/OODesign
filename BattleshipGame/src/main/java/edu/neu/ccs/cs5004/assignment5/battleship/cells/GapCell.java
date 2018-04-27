package edu.neu.ccs.cs5004.assignment5.battleship.cells;

/**
 * Represents a gap cell.
 */

public class GapCell extends AbstractWaterCell implements WaterCell {

  /**
   * Creates a gap cell.
   *
   * @param isHit - indicate if the cell has been hit.
   */
  public GapCell(Boolean isHit) {
    super(isHit);
  }

  /**
   * Indicate a ship can be placed on this cell or not.
   *
   * @return true if a ship can place on this cell, false otherwise
   */
  @Override
  public Boolean canPlacedShip() {
    return false;
  }

  @Override
  public boolean equals(Object other) {
    if (!super.equals(other)) {
      return false;
    }

    return this.getClass() == other.getClass();
  }


  @Override
  public int hashCode() {
    return super.hashCode();
  }


  @Override
  public String toString() {
    return "GapCell{" + "isHitShip=" + isHit + '}';
  }
}
