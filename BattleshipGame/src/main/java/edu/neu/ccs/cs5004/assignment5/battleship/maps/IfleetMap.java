package edu.neu.ccs.cs5004.assignment5.battleship.maps;

import edu.neu.ccs.cs5004.assignment5.battleship.enums.Column;
import edu.neu.ccs.cs5004.assignment5.battleship.enums.Direction;
import edu.neu.ccs.cs5004.assignment5.battleship.enums.Row;
import edu.neu.ccs.cs5004.assignment5.battleship.ships.Ship;

/**
 * Represents a Ifleetmap of a player.
 */
public interface IfleetMap extends Map {


  /**
   * Place a ship in given location and direction.
   */
  void placeShip(Ship ship, Row row, Column col, Direction direction);

  /**
   * Indicate if the ship can be placed in given location.
   *
   * @param ship the ship need to place.
   * @param row the row.
   * @param col the col.
   * @param direction the direction to put the ship.
   * @return true if the ship can be placed in given location ,false otherwise.
   */
  boolean canPlaceShip(Ship ship, Row row, Column col, Direction direction);

  /**
   * Random generate a complete fleet map.
   */
  void randomPlaceShip();

  /**
   * Get the current battleship on the map.
   *
   * @return the current battleship number.
   */
  int getCountBattleship();

  /**
   * Get the current cruiser on the map.
   *
   * @return the current cruiser number.
   */
  int getCountCruiser();

  /**
   * Get the current submarine on the map.
   *
   * @return the current submarine number.
   */
  int getCountSubmarine();

  /**
   * Get the current destroyer on the map.
   *
   * @return the current destroyer number.
   */
  int getCountDestroyer();

  /**
   * Attack a cell on the map.
   *
   * @param row the row.
   * @param col the col.
   * @param sunkShipNum current sunk ship number.
   * @return the updated sunk ship number after the attacks.
   */
  Integer attack(Row row, Column col, Integer sunkShipNum);
}
