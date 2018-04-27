package edu.neu.ccs.cs5004.assignment5.battleship.ships;

import edu.neu.ccs.cs5004.assignment5.battleship.enums.Number;

/**
 * Represent a battleship for the game program.
 */

public class Battleship extends AbstractShip {

  /**
   * Constructor for a battleship.
   *
   * @param size - getSize of a battleship.
   * @param numberHitCells - number of cells has been hit in the battleship.
   */
  public Battleship(Integer size, Integer numberHitCells) {
    super(size, numberHitCells);
    this.size = Number.FOUR.getValue();
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
    return 17;
  }

  @Override
  public String toString() {
    return "Battleship{"
            + "getSize="
            + size
            + ", numberHitCells="
            + numberHitCells
            + '}';
  }

}
