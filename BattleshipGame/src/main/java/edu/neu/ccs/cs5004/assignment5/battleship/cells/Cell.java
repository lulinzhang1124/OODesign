package edu.neu.ccs.cs5004.assignment5.battleship.cells;

import edu.neu.ccs.cs5004.assignment5.battleship.ships.Ship;
import edu.neu.ccs.cs5004.assignment5.battleship.viewer.Printer;

/**
 * Represents a cell.
 */
public interface Cell {
  /**
   * Get the attack result for a cell.
   *
   * @return a attack result
   */
  AttackResult attackResult();

  /**
   * Indicate a ship can be placed on this cell or not.
   *
   * @return true if a ship can place on this cell, false otherwise
   */
  Boolean canPlacedShip();

  /**
   * Attack the cell.
   *
   * @return the updated cell after the attack
   */
  Cell attack();

  /**
   * Print the cell.
   *
   * @param printer - a printer which is the instance of the ConsolePrinter class.
   */
  void prettyPrint(Printer printer);

  /**
   * Get the result to see if a cell was hit.
   *
   * @return true if it was hit, false otherwise.
   */
  Boolean getIsHit();

  /**
   * Updates the cells which belong to the ship using observer pattern.
   *
   * @param observable - a ship serves as the observable in observer pattern.
   */
  void update(Ship observable);


}
