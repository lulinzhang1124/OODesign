package edu.neu.ccs.cs5004.assignment5.battleship.maps;

import edu.neu.ccs.cs5004.assignment5.battleship.controller.Player;
import edu.neu.ccs.cs5004.assignment5.battleship.enums.Column;
import edu.neu.ccs.cs5004.assignment5.battleship.enums.Row;

/**
 * Represents a battle map interface.
 */
public interface IbattleMap extends Map {


  /**
   * Attack a cell on the map.
   *
   * @param player your enemy player.
   * @param row    the row.
   * @param col    the col.
   */
  void attack(Player player, Row row, Column col);
}
