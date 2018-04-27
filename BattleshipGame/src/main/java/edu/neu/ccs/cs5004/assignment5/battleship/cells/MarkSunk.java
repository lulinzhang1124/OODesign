package edu.neu.ccs.cs5004.assignment5.battleship.cells;

/**
 * Represents a ship cell is sunk or not.
 */
public interface MarkSunk {
  /**
   * Get the result if the ship cell is sunk or not.
   *
   * @return a string that represents a ship cell sunk or not
   */
  String isSunk();
}
