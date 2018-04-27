package edu.neu.ccs.cs5004.assignment5.battleship.ships;


import edu.neu.ccs.cs5004.assignment5.battleship.enums.Number;

/**
 * Represents a cruiser.
 */
public class Cruiser extends AbstractShip {

  /**
   * Constructor for a cruiser.
   *
   * @param size - getSize of a cruiser.
   * @param numberHitCells - number of cells has been hit in the cruiser.
   */
  public Cruiser(Integer size, Integer numberHitCells) {
    super(size, numberHitCells);
    this.size = Number.THREE.getValue() ;
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
    return 11;
  }

  @Override
  public String toString() {
    return "Cruiser{"
            + "getSize="
            + size
            + ", numberHitCells="
            + numberHitCells
            + '}';
  }
}


