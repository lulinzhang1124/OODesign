package edu.neu.ccs.cs5004.assignment5.battleship.cells;

/**
 * Represents an open sea cell.
 */
public class OpenSeaCell extends AbstractWaterCell implements WaterCell {

  /**
   * Creates an open sea cell.
   *
   * @param isHit - indicates if the cell has been hit.
   */
  public OpenSeaCell(Boolean isHit) {
    super(isHit);
  }

  /**
   * Indicate a ship can be placed on this cell or not.
   *
   * @return true if a ship can place on this cell, false otherwise
   */
  @Override
  public Boolean canPlacedShip() {
    return true;
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
    return "OpenSeaCell{" + "isHitShip=" + isHit
            + '}';
  }
}
