package edu.neu.ccs.cs5004.assignment5.battleship.cells;

import edu.neu.ccs.cs5004.assignment5.battleship.ships.Ship;

/**
 * Represents an abstract cell.
 */

public abstract class AbstractCell implements Cell {

  protected Boolean isHit;

  /**
   * Creates a abstract cell.
   *
   * @param isHit - true if the cell is hit, false otherwise.
   */
  public AbstractCell(Boolean isHit) {
    this.isHit = isHit;
  }

  /**
   * Updates the cells which belong to the ship using observer pattern.
   *
   * @param observable - a ship serves as the observable in observer pattern.
   */
  @Override
  public void update(Ship observable) {
    return;
  }

  /**
   * Getter for property 'isHitShip'.
   *
   * @return true if the cell is hit, false otherwise
   */
  public Boolean getIsHit() {
    return isHit;
  }


  /**
   * Attacks the cell.
   *
   * @return the same cell but with the filed isHitShip marked as true.
   */
  @Override
  public Cell attack() {
    this.isHit = true;
    return this;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }

    AbstractCell that = (AbstractCell) obj;

    return isHit != null ? isHit.equals(that.isHit) : that.isHit == null;
  }

  @Override
  public int hashCode() {
    return isHit != null ? isHit.hashCode() : 0;
  }
}
