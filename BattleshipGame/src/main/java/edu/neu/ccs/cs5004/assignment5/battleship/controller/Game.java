package edu.neu.ccs.cs5004.assignment5.battleship.controller;


import edu.neu.ccs.cs5004.assignment5.battleship.viewer.Printer;

/**
 * Represent a game.
 */
public interface Game {

  /**
   * Getter for the human.
   *
   * @return the human player for the game.
   */
  Human getHuman();

  /**
   * Getter fot the computer.
   *
   * @return the computer player fot the game.
   */
  Computer getComputer();

  /**
   * Print the maps for the game.
   *
   * @param printer the printer tobe print the map.
   */
  void printMaps(Printer printer);

}
