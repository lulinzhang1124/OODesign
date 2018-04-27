package edu.neu.ccs.cs5004.assignment4.problem3;

import java.util.Objects;

/**
 * Represents an abstract ship.
 */
public abstract class AbstractShip implements Ship {

  protected Integer size;
  protected Integer numberHitCells;

  public AbstractShip(Integer size, Integer numberHitCells) {
    this.size = size;
    this.numberHitCells = numberHitCells;
  }

  /**
   * Getter.
   *
   * @return value of size.
   */
  public Integer getSize() {
    return size;
  }

  /**
   * Getter.
   *
   * @return the number of cells hit.
   */
  public Integer getNumberHitCells() {
    return numberHitCells;
  }

  @Override
  public Boolean isSunk() {
    return this.numberHitCells.equals(this.size);
  }

  @Override
  public Ship hitShip() {
    this.numberHitCells++;
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
    AbstractShip that = (AbstractShip) obj;
    return Objects.equals(size, that.size)
        && Objects.equals(numberHitCells, that.numberHitCells);
  }

  @Override
  public int hashCode() {

    return Objects.hash(size, numberHitCells);
  }
}
