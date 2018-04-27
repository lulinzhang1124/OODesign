package edu.neu.ccs.cs5004.assignment5.battleship.cells;

/**
 * Represents a ship cell is not sunk.
 */
public class NotSunk implements MarkSunk {

  /**
   * Get the result if the ship cell is sunk or not.
   *
   * @return a string that represents a ship cell sunk or not.
   */
  @Override
  public String isSunk() {
    return "Not Sunk";
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    return true;
  }

  @Override
  public int hashCode() {
    return 47;
  }

  @Override
  public String toString() {
    return "NotSunk";
  }
}
