package edu.neu.ccs.cs5004.assignment5.battleship.ships;

import edu.neu.ccs.cs5004.assignment5.battleship.enums.Number;

/**
 * Represents a destoryer.
 */
public class Destroyer extends AbstractShip {

  /**
   * Constructor for a destroyer.
   *
   * @param size - getSize of a destroyer.
   * @param numberHitCells - number of cells has been hit in the destroyer.
   */
  public Destroyer(Integer size, Integer numberHitCells) {
    super(size, numberHitCells);
    this.size =  Number.ONE.getValue() ;
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
    return 13;
  }

  @Override
  public String toString() {
    return "Destroyer{"
            + "getSize="
            + size
            + ", numberHitCells="
            + numberHitCells
            + '}';
  }
}
