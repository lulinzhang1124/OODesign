package edu.neu.ccs.cs5004.assignment5.battleship.controller;

import edu.neu.ccs.cs5004.assignment5.battleship.maps.IbattleMap;
import edu.neu.ccs.cs5004.assignment5.battleship.maps.IfleetMap;
import edu.neu.ccs.cs5004.assignment5.battleship.strategy.Strategy;

/**
 * Represent a player of the game.
 */
public interface Player {

  /**
   * Place ships on the map.
   */
  void placeShips() throws ReadConsole.UserInteruptException;

  /**
   * Get the battle map for the player.
   *
   * @return the battle map.
   */
  IbattleMap getIbattleMap();


  /**
   * Get the fleet map for the player.
   *
   * @return the fleet map.
   */
  IfleetMap getIfleetMap();

  /**
   * Setter for the strategy.
   *
   * @param strategy the strategy value to be set.
   */
  void setStrategy(Strategy strategy);


}
