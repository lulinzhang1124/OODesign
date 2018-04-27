package edu.neu.ccs.cs5004.assignment5.battleship.maps;

import edu.neu.ccs.cs5004.assignment5.battleship.cells.Cell;
import edu.neu.ccs.cs5004.assignment5.battleship.cells.GapCell;
import edu.neu.ccs.cs5004.assignment5.battleship.cells.NotSunk;
import edu.neu.ccs.cs5004.assignment5.battleship.cells.OpenSeaCell;
import edu.neu.ccs.cs5004.assignment5.battleship.cells.SpecificShipCell;
import edu.neu.ccs.cs5004.assignment5.battleship.enums.Column;
import edu.neu.ccs.cs5004.assignment5.battleship.enums.Direction;
import edu.neu.ccs.cs5004.assignment5.battleship.enums.Row;
import edu.neu.ccs.cs5004.assignment5.battleship.ships.Battleship;
import edu.neu.ccs.cs5004.assignment5.battleship.ships.Cruiser;
import edu.neu.ccs.cs5004.assignment5.battleship.ships.Destroyer;
import edu.neu.ccs.cs5004.assignment5.battleship.ships.Ship;
import edu.neu.ccs.cs5004.assignment5.battleship.ships.Submarine;
import edu.neu.ccs.cs5004.assignment5.battleship.viewer.Printer;

import java.util.Arrays;
import java.util.Random;


/**
 * Represents a fleet map.
 */
public class FleetMap extends AbstractMap implements IfleetMap {
  static final int ROW = 10;
  static final int COLUMN = 10;


  /**
   * Constructor of fleet map.
   */
  public FleetMap() {
    super();
  }

  /**
   * Constructor of fleet map.
   *
   * @param battleshipNum the battleship number
   * @param cruiserNum    the cruiser number
   * @param submarineNum  the submarine number
   * @param destroyerNum  the destroyer number
   */
  public FleetMap(int battleshipNum, int cruiserNum, int submarineNum, int destroyerNum) {
    super(battleshipNum, cruiserNum, submarineNum, destroyerNum);

  }

  /**
   * Get the current battleship on the map.
   *
   * @return the current battleship number.
   */
  @Override
  public int getCountBattleship() {
    return countBattleship;
  }


  /**
   * Get the current cruiser on the map.
   *
   * @return the current cruiser number.
   */
  @Override
  public int getCountCruiser() {
    return countCruiser;
  }

  /**
   * Get the current submarine on the map.
   *
   * @return the current submarine number.
   */
  @Override
  public int getCountSubmarine() {
    return countSubmarine;
  }

  /**
   * Get the current destroyer on the map.
   *
   * @return the current destroyer number.
   */
  @Override
  public int getCountDestroyer() {
    return countDestroyer;
  }

  /**
   * Indicate if the ship can be placed in given location.
   *
   * @param ship      the ship need to place.
   * @param row       the row.
   * @param col       the col.
   * @param direction the direction to put the ship.
   * @return true if the ship can be placed in given location ,false otherwise.
   */
  @Override
  public boolean canPlaceShip(Ship ship, Row row, Column col, Direction direction) {
    for (int i = 0; i < ship.getSize(); i++) {
      if (direction.equals(Direction.VERTICAL)) {
        if (row.ordinal() + i >= ROW
                || !getMap(Row.values()[row.ordinal() + i], col).getClass().equals(
                        OpenSeaCell.class)) {
          return false;
        }
      } else { //if(direction.equals(Direction.HORIZONTAL))
        if (col.ordinal() + i >= COLUMN || !getMap(row,
                Column.values()[col.ordinal() + i]).getClass().equals(OpenSeaCell.class)) {
          return false;
        }
      }
    }
    return true;
  }

  /**
   * Set the cells surrounding by the given ship to GapCell.
   *
   * @param ship      the ship to be placed
   * @param row       the row
   * @param col       the col
   * @param direction the direction to place the ship
   */
  void setGapCell(Ship ship, Row row, Column col, Direction direction) {

    if (direction.equals(Direction.VERTICAL)) {
      for (int i = 0; i < ship.getSize(); i++) {
        if (col.ordinal() != 0) {
          setMap(Row.values()[row.ordinal() + i], Column.values()[col.ordinal() - 1],
                  new GapCell(false));
        }
        if (col.ordinal() != 9) {
          setMap(Row.values()[row.ordinal() + i], Column.values()[col.ordinal() + 1],
                  new GapCell(false));
        }
      }
      if (row.ordinal() != 0) {
        setMap(Row.values()[row.ordinal() - 1], col, new GapCell(false));
      }
      if (row.ordinal() != 0 && col.ordinal() != 0) {
        setMap(Row.values()[row.ordinal() - 1], Column.values()[col.ordinal() - 1],
                new GapCell(false));
      }
      if (row.ordinal() != 0 && col.ordinal() != 9) {
        setMap(Row.values()[row.ordinal() - 1], Column.values()[col.ordinal() + 1],
                new GapCell(false));
      }
      if (row.ordinal() + ship.getSize() - 1 != 9) {
        setMap(Row.values()[row.ordinal() + ship.getSize()], col, new GapCell(false));
      }
      if (row.ordinal() + ship.getSize() - 1 != 9 && col.ordinal() != 0) {
        setMap(Row.values()[row.ordinal() + ship.getSize()], Column.values()[col.ordinal() - 1],
                new GapCell(false));
      }
      if (row.ordinal() + ship.getSize() - 1 != 9 && col.ordinal() != 9) {
        setMap(Row.values()[row.ordinal() + ship.getSize()], Column.values()[col.ordinal() + 1],
                new GapCell(false));
      }

    } else {
      for (int i = 0; i < ship.getSize(); i++) {
        if (row.ordinal() != 0) {
          setMap(Row.values()[row.ordinal() - 1], Column.values()[col.ordinal() + i],
                  new GapCell(false));
        }
        if (row.ordinal() != 9) {
          setMap(Row.values()[row.ordinal() + 1], Column.values()[col.ordinal() + i],
                  new GapCell(false));
        }
      }
      if (row.ordinal() != 0 && col.ordinal() != 0) {
        setMap(Row.values()[row.ordinal() - 1], Column.values()[col.ordinal() - 1],
                new GapCell(false));
      }
      if (row.ordinal() != 9 && col.ordinal() != 0) {
        setMap(Row.values()[row.ordinal() + 1], Column.values()[col.ordinal() - 1],
                new GapCell(false));
      }
      if (col.ordinal() != 0) {
        setMap(row, Column.values()[col.ordinal() - 1], new GapCell(false));
      }
      if (col.ordinal() + ship.getSize() - 1 != 9) {
        setMap(row, Column.values()[col.ordinal() + ship.getSize()], new GapCell(false));
      }
      if (col.ordinal() + ship.getSize() - 1 != 9 && row.ordinal() != 0) {
        setMap(Row.values()[row.ordinal() - 1], Column.values()[col.ordinal() + ship.getSize()],
                new GapCell(false));
      }
      if (col.ordinal() + ship.getSize() - 1 != 9 && row.ordinal() != 9) {
        setMap(Row.values()[row.ordinal() + 1], Column.values()[col.ordinal() + ship.getSize()],
                new GapCell(false));
      }
    }

  }


  /**
   * Place a ship in given location and direction.
   */
  @Override
  public void placeShip(Ship ship, Row row, Column col, Direction direction) {

    //set ship cell one by one
    if (direction.equals(Direction.VERTICAL)) {
      for (int i = 0; i < ship.getSize(); i++) {
        SpecificShipCell cell = new SpecificShipCell(false, new NotSunk(), ship);
        this.setMap(Row.values()[row.ordinal() + i], col, cell);

      }
    } else {
      for (int i = 0; i < ship.getSize(); i++) {
        SpecificShipCell cell = new SpecificShipCell(false, new NotSunk(), ship);
        this.setMap(row, Column.values()[col.ordinal() + i], cell);

      }
    }

    //set the surrounding cells to gap cell.
    setGapCell(ship, row, col, direction);

    // num of current ship type increase by 1
    if (ship.getClass().equals(Battleship.class)) {
      this.countBattleship++;
    } else if (ship.getClass().equals(Cruiser.class)) {
      this.countCruiser++;
    } else if (ship.getClass().equals(Submarine.class)) {
      this.countSubmarine++;
    } else {
      this.countDestroyer++;
    }

  }


  /**
   * Random generate a complete fleet map.
   */
  @Override
  public void randomPlaceShip() {

    Ship ship;
    Row row;
    Column col;
    Direction dir;
    Random rand = new Random();

    int count = 0;
    int shipNum = getBattleshipNum() + getCruiserNum() + getSubmarineNum() + getDestroyerNum();

    while (count < shipNum) {
      if (countBattleship < getBattleshipNum()) {
        ship = new Battleship(4, 0);
      } else if (countCruiser < getCruiserNum()) {
        ship = new Cruiser(3, 0);
      } else if (countSubmarine < getSubmarineNum()) {
        ship = new Submarine(2, 0);
      } else {
        ship = new Destroyer(1, 0);
      }

      row = Row.values()[rand.nextInt(10)];
      col = Column.values()[rand.nextInt(10)];
      dir = rand.nextInt(2) == 0 ? Direction.VERTICAL : Direction.HORIZONTAL;

      if (!canPlaceShip(ship, row, col, dir)) {
        continue;
      } else {
        placeShip(ship, row, col, dir);
        count++;
      }
    }
    Printer.CONSOLE_PRINTER.printMessage("finishGenerateRandomMap");

  }

  /**
   * Attack a cell on the map.
   *
   * @param row         the row.
   * @param col         the col.
   * @param sunkShipNum current sunk ship number.
   * @return the updated sunk ship number after the attacks.
   */
  @Override
  public Integer attack(Row row, Column col, Integer sunkShipNum) {
    Cell attackCell = getMap(row, col).attack();

    if (attackCell.attackResult().toString().equals("Sunk")) {
      sunkShipNum++;
    }
    return sunkShipNum;
  }


  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    FleetMap fleetMap1 = (FleetMap) obj;
    for (int i = 0; i < ROW; i++) {
      for (int j = 0; j < COLUMN; j++) {
        if (fleetMap1.mapcell[i][j].getClass() != mapcell[i][j].getClass()) {
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
    return "FleetMap{"
            + "map="
            + Arrays.toString(mapcell)
            + '}';
  }
}
