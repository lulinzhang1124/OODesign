package edu.neu.ccs.cs5004.assignment5.battleship.maps;

import edu.neu.ccs.cs5004.assignment5.battleship.cells.Cell;
import edu.neu.ccs.cs5004.assignment5.battleship.enums.Column;
import edu.neu.ccs.cs5004.assignment5.battleship.enums.Row;
import edu.neu.ccs.cs5004.assignment5.battleship.viewer.Printer;

/**
 * Represents a map for the game.
 */
public interface Map {

  /**
   * Constants for the map.
   */
  int ROW = 10;
  int COLUMN = 10;
  int BATTLESHIP_NUM = 1;
  int CRUISER_NUM = 2;
  int SUBMARINE_NUM = 3;
  int DESTROYER_NUM = 4;



  /**
   * Print the map.
   *
   * @param printer the printer who can print the map
   */
  void prettyPrint(Printer printer);


  /**
   * Getter for map.
   *
   * @param row the row of the cell
   * @param col the column of th cell
   * @return the cell in the specific position
   */
  Cell getMap(Row row, Column col);

  /**
   * Setter for map.
   *
   * @param row  the row of the cell
   * @param col  the column of the cell
   * @param cell the value to be set
   */
  void setMap(Row row, Column col, Cell cell);


  /**
   * Get the battleship number on the ship.
   *
   * @return the battleship number.
   */
  int getBattleshipNum();

  /**
   * Get the cruiser number on the ship.
   *
   * @return the cruiser number.
   */
  int getCruiserNum();

  /**
   * Get the submarine number on the ship.
   *
   * @return the submarine number.
   */
  int getSubmarineNum();

  /**
   * Get the destroyer number on the ship.
   *
   * @return the destroyer number.
   */
  int getDestroyerNum();


}
