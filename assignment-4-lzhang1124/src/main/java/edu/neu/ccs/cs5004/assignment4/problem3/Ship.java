package edu.neu.ccs.cs5004.assignment4.problem3;

/**
 * Represetns a ship of the game.
 */
public interface Ship {
  /**
   * Indicate if the ship is hit or not.
   *
   * @return the updated ship after it was hit
   */
  Ship hitShip();

  /**
   * Indicates a ship is sunk or not.
   *
   * @return true if the ship is sunk, false otherwise
   */
  Boolean isSunk();
}
