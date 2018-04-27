package edu.neu.ccs.cs5004.assignment5.battleship.maps;

import edu.neu.ccs.cs5004.assignment5.battleship.cells.Cell;
import edu.neu.ccs.cs5004.assignment5.battleship.cells.EnemyShipCell;
import edu.neu.ccs.cs5004.assignment5.battleship.cells.NotSunk;
import edu.neu.ccs.cs5004.assignment5.battleship.cells.OpenSeaCell;
import edu.neu.ccs.cs5004.assignment5.battleship.cells.SpecificShipCell;
import edu.neu.ccs.cs5004.assignment5.battleship.cells.Sunk;
import edu.neu.ccs.cs5004.assignment5.battleship.controller.Player;
import edu.neu.ccs.cs5004.assignment5.battleship.enums.Column;
import edu.neu.ccs.cs5004.assignment5.battleship.enums.Row;

/**
 * Represent a battle map for a player.
 */
public class BattleMap extends AbstractMap implements IbattleMap {


  /**
   * Constructor of a battle map.
   */
  public BattleMap() {
    super();

  }

  /**
   * Constructor of battle map.
   *
   * @param battleshipNum the battleship number
   * @param cruiserNum    the cruiser number
   * @param submarineNum  the submarine number
   * @param destroyerNum  the destroyer number
   */
  public BattleMap(int battleshipNum, int cruiserNum, int submarineNum, int destroyerNum) {
    super(battleshipNum, cruiserNum, submarineNum, destroyerNum);

  }

  /**
   * Attack a cell on the map.
   *
   * @param player your enemy player.
   * @param row    - the row.
   * @param col    - the col.
   */
  @Override
  public void attack(Player player, Row row, Column col) {
    Cell cell = player.getIfleetMap().getMap(row, col);
    Cell battleMapCell;

    switch (cell.attackResult().toString()) {
      case "Hit":
        battleMapCell = new EnemyShipCell(true, new NotSunk(), false);
        setMap(row, col, battleMapCell);
        ((SpecificShipCell) cell).getShip().registerObserver(getMap(row, col));
        break;
      case "Sunk":
        battleMapCell = new EnemyShipCell(true, new Sunk(), true);
        setMap(row, col, battleMapCell);
        ((SpecificShipCell) cell).getShip().notifyObservers();
        break;
      default:
        battleMapCell = new OpenSeaCell(true);

    }
    setMap(row, col, battleMapCell);
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == null) {
      return false;
    }

    if (this == obj) {
      return true;
    }
    if (!super.equals(obj)) {
      return false;
    }

    return this.getClass() == obj.getClass();
  }


  @Override
  public int hashCode() {
    return 97;
  }

  @Override
  public String toString() {
    return "BattleMap{}";
  }
}
