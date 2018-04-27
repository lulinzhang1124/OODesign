package edu.neu.ccs.cs5004.assignment4.problem3;

import java.util.Arrays;

/**
 * Represents a cell map.
 */
public class Map {
  static final int ROW = 10;
  static final int COLUMN = 10;
  protected Cell[][] mapcell;

  /**
   * Constructor of map.
   */
  public Map() {
    this.mapcell = new Cell[ROW][COLUMN];
    for (int i = 0; i < ROW; i++) {
      for (int j = 0; j < COLUMN; j++) {
        mapcell[i][j] = new OpenSeaCell(false);
      }
    }
  }

  /**
   * Setter for map.
   *
   * @param row  the row of the cell
   * @param col  the column of the cell
   * @param cell the value to be set
   */
  public void setMap(Row row, Column col, Cell cell) {
    mapcell[row.ordinal()][col.ordinal()] = cell;
  }

  /**
   * Getter for map.
   *
   * @param row the row of the cell
   * @param col the column of th cell
   * @return the cell in the specific position
   */
  public Cell getMap(Row row, Column col) {
    return mapcell[row.ordinal()][col.ordinal()];
  }

  /**
   * Print the map.
   *
   * @param printer the printer who can print the map
   */
  void prettyPrint(ConsolePrinter printer) {
    printer.prettyPrint(this);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    Map map1 = (Map) obj;
    for (int i = 0; i < ROW; i++) {
      for (int j = 0; j < COLUMN; j++) {
        if (map1.mapcell[i][j].getClass() != mapcell[i][j].getClass()) {
          return false;
        }
      }
    }
    return true;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    for (int i = 0; i < ROW; i++) {
      for (int j = 0; j < COLUMN; j++) {

        if (mapcell[i][j].getClass() == OpenSeaCell.class) {
          hash += i + 31 * j;
        } else if (mapcell[i][j].getClass() == GapCell.class) {
          hash += (i + 31 * j) * 31;
        } else if (mapcell[i][j].getClass() == SpecificShipCell.class) {
          hash += (i + 31 * j) * 31 * 31;
        } else {
          hash += (i + 31 * j) * 31 * 31 * 31;
        }

      }
    }
    return hash;
  }

  @Override
  public String toString() {
    return "Map{" + "map=" + Arrays.toString(mapcell) + '}';
  }
}
