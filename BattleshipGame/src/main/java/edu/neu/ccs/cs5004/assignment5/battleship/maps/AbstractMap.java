package edu.neu.ccs.cs5004.assignment5.battleship.maps;

import edu.neu.ccs.cs5004.assignment5.battleship.cells.Cell;
import edu.neu.ccs.cs5004.assignment5.battleship.cells.OpenSeaCell;
import edu.neu.ccs.cs5004.assignment5.battleship.enums.Column;
import edu.neu.ccs.cs5004.assignment5.battleship.enums.Row;
import edu.neu.ccs.cs5004.assignment5.battleship.viewer.Printer;

import java.util.Arrays;

/**
 * Represents an abstract map.
 */
public abstract class AbstractMap implements Map {

  protected Cell[][] mapcell;
  protected int battleshipNum;
  protected int cruiserNum;
  protected int submarineNum;
  protected int destroyerNum;
  protected int countBattleship;
  protected int countCruiser;
  protected int countSubmarine;
  protected int countDestroyer;

  /**
   * Constructor of abstract map.
   */
  AbstractMap() {
    this.mapcell = new Cell[ROW][COLUMN];
    for (int i = 0; i < ROW; i++) {
      for (int j = 0; j < COLUMN; j++) {
        mapcell[i][j] = new OpenSeaCell(false);
      }
    }
    this.battleshipNum = Map.BATTLESHIP_NUM;
    this.cruiserNum = Map.CRUISER_NUM;
    this.submarineNum = Map.SUBMARINE_NUM;
    this.destroyerNum = Map.DESTROYER_NUM;
    this.countBattleship = 0;
    this.countCruiser = 0;
    this.countSubmarine = 0;
    this.countDestroyer = 0;
  }

  /**
   * Constructor of abstract map.
   *
   * @param battleshipNum the battleship number
   * @param cruiserNum    the cruiser number
   * @param submarineNum  the submarine number
   * @param destroyerNum  the destroyer number
   */
  AbstractMap(int battleshipNum, int cruiserNum, int submarineNum, int destroyerNum) {
    this.mapcell = new Cell[ROW][COLUMN];
    for (int i = 0; i < ROW; i++) {
      for (int j = 0; j < COLUMN; j++) {
        mapcell[i][j] = new OpenSeaCell(false);
      }
    }
    this.battleshipNum = battleshipNum;
    this.cruiserNum = cruiserNum;
    this.submarineNum = submarineNum;
    this.destroyerNum = destroyerNum;
    this.countBattleship = 0;
    this.countCruiser = 0;
    this.countSubmarine = 0;
    this.countDestroyer = 0;
  }

  /**
   * Getter.
   *
   * @return the value for 'BattleshipNum'.
   */
  @Override
  public int getBattleshipNum() {
    return battleshipNum;
  }

  /**
   * Get the cruiser number on the ship.
   *
   * @return the cruiser number.
   */
  @Override
  public int getCruiserNum() {
    return cruiserNum;
  }

  /**
   * Get the submarine number on the ship.
   *
   * @return the submarine number.
   */
  @Override
  public int getSubmarineNum() {
    return submarineNum;
  }

  /**
   * Get the destroyer number on the ship.
   *
   * @return the destroyer number.
   */
  @Override
  public int getDestroyerNum() {
    return destroyerNum;
  }

  @Override
  public void prettyPrint(Printer printer) {
    printer.toConsole(this);
  }

  @Override
  public Cell getMap(Row row, Column col) {
    return mapcell[row.ordinal()][col.ordinal()];
  }

  @Override
  public void setMap(Row row, Column col, Cell cell) {
    mapcell[row.ordinal()][col.ordinal()] = cell;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }

    AbstractMap that = (AbstractMap) obj;

    if (getBattleshipNum() != that.getBattleshipNum()) {
      return false;
    }
    if (getCruiserNum() != that.getCruiserNum()) {
      return false;
    }
    if (getSubmarineNum() != that.getSubmarineNum()) {
      return false;
    }
    if (getDestroyerNum() != that.getDestroyerNum()) {
      return false;
    }
    if (countBattleship != that.countBattleship) {
      return false;
    }
    if (countCruiser != that.countCruiser) {
      return false;
    }
    if (countSubmarine != that.countSubmarine) {
      return false;
    }
    if (countDestroyer != that.countDestroyer) {
      return false;
    }
    return Arrays.deepEquals(mapcell, that.mapcell);
  }

  @Override
  public int hashCode() {
    int result = Arrays.deepHashCode(mapcell);
    result = 31 * result + getBattleshipNum();
    result = 31 * result + getCruiserNum();
    result = 31 * result + getSubmarineNum();
    result = 31 * result + getDestroyerNum();
    result = 31 * result + countBattleship;
    result = 31 * result + countCruiser;
    result = 31 * result + countSubmarine;
    result = 31 * result + countDestroyer;
    return result;
  }
}
