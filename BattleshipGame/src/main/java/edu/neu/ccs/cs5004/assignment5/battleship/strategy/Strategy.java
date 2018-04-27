package edu.neu.ccs.cs5004.assignment5.battleship.strategy;

import edu.neu.ccs.cs5004.assignment5.battleship.controller.ReadConsole;
import edu.neu.ccs.cs5004.assignment5.battleship.enums.Coordinate;

/**
 * Represents the strategy interface.
 */
public interface Strategy {

  /**
   * Gets the coordinate of attack for this time.
   *
   * @param isPreviousHit - indicate if the coordinate has been previously hit.
   * @param isPreviousHitSunk - indicate if previous hit result in a sunk ship.
   * @return - the coordinate of attack for this time.
   */
  Coordinate generateAttackCoordinate(boolean isPreviousHit, boolean isPreviousHitSunk)
          throws ReadConsole.UserInteruptException;

}
