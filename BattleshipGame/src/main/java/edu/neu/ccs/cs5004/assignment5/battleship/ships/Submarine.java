package edu.neu.ccs.cs5004.assignment5.battleship.ships;

import edu.neu.ccs.cs5004.assignment5.battleship.enums.Number;

/**
 * Represents a submarine.
 */
public class Submarine extends AbstractShip {

  /**
   * Constructor for a submarine.
   *
   * @param size - getSize of a submarine.
   * @param numberHitCells - number of cells has been hit in the submarine.
   */
  public Submarine(Integer size, Integer numberHitCells) {
    super(size, numberHitCells);
    this.size = Number.TWO.getValue() ;
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
    return 19;
  }

  @Override
  public String toString() {
    return "Submarine{"
            + "getSize="
            + size
            + ", numberHitCells="
            + numberHitCells
            + '}';
  }
}
