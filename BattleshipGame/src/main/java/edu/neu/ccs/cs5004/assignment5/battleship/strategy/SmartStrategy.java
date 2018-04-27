package edu.neu.ccs.cs5004.assignment5.battleship.strategy;


import edu.neu.ccs.cs5004.assignment5.battleship.cells.EnemyShipCell;
import edu.neu.ccs.cs5004.assignment5.battleship.enums.Column;
import edu.neu.ccs.cs5004.assignment5.battleship.enums.Coordinate;
import edu.neu.ccs.cs5004.assignment5.battleship.enums.Number;
import edu.neu.ccs.cs5004.assignment5.battleship.enums.Row;
import edu.neu.ccs.cs5004.assignment5.battleship.enums.StrategyDirection;
import edu.neu.ccs.cs5004.assignment5.battleship.maps.IbattleMap;

import java.util.Random;


/**
 * Represents the smart strategy in the game.
 *
 * <p>For the SmartStrategy, we define two mode
 * Mode1 : random hit
 * The program starts random hit mode when (1)first hits in all game, (2)a enemy ship is sunk
 * in previous attempt.
 * The program quits random hit mode once it hits any cells in random mode.
 * When in random hit mode, it randomly hit a cell that is not a gap cell.
 *
 * <p>Mode2:  smart hit
 * Once it successfully random hit a cell, the program goes into smart hit mode. It records the cell
 * that it previous random hit. Then start hit it's neighbor cells in the order of left, up, right
 * and down. It will skip a direction if it reaches the edge. Once it hit something in one
 * direction, it will continue hit in the same direction in next attempt until it reaches edge or
 * it hits a water cell, then it changes a direction for the next attempt.
 */
public class SmartStrategy implements Strategy {

  private boolean isPreviousModeRandomHit;

  private Coordinate previousRandomHitCoordinate;

  private Coordinate previousHitCoordinate;

  private StrategyDirection previousDirection;


  private IbattleMap myBattleMap;

  /**
   * Constructor of smart strategy.
   *
   * @param myBattleMap - current battle map.
   */

  public SmartStrategy(IbattleMap myBattleMap) {
    isPreviousModeRandomHit = true;
    previousRandomHitCoordinate = null;
    previousHitCoordinate = null;
    previousDirection = null;
    this.myBattleMap = myBattleMap;
  }

  /**
   * Connstructor for testing
   * @param myBattleMap  battleMap.
   * @param isPreviousModeRandomHit if previous is random hit mode.
   * @param previousRandomHitCoordinate previous randomly hit coordinate.
   * @param previousHitCoordinate previously hit coordinate.
   * @param previousDirection previously hit direction.
   */
  public SmartStrategy(IbattleMap myBattleMap, boolean isPreviousModeRandomHit,
                       Coordinate previousRandomHitCoordinate,
                       Coordinate previousHitCoordinate,
                       StrategyDirection previousDirection) {
    this.isPreviousModeRandomHit = isPreviousModeRandomHit;
    this.previousRandomHitCoordinate = previousRandomHitCoordinate;
    this.previousHitCoordinate = previousHitCoordinate;
    this.previousDirection = previousDirection;
    this.myBattleMap = myBattleMap;
  }


  /**
   * Check if current location is not edge.
   *
   * @param row - row of the location.
   * @param col - column of the location.
   * @return - true if the location doesn't reach the edge, false otherwise.
   */

  private boolean isNotEdge(int row, int col) {
    if (row < Number.ZERO.getValue() || row > Number.NINE.getValue()) {
      return false;
    }
    if (col < Number.ZERO.getValue() || col > Number.NINE.getValue()) {
      return false;
    }
    return true;

  }


  /*
   * This should only be called in random hit mode
   */
  private boolean isGapCell(Row row, Column col) {
    int rowIndex = row.ordinal();
    int colIndex = col.ordinal();

    //check left
    if (isNotEdge(rowIndex - 1, colIndex)
            &&
            this.myBattleMap.getMap(Row.values()[rowIndex - 1], col) instanceof EnemyShipCell) {
      return true;
    }
    //check right
    if (isNotEdge(rowIndex + 1, colIndex)
            &&
            this.myBattleMap.getMap(Row.values()[rowIndex + 1], col) instanceof EnemyShipCell) {
      return true;
    }
    //check up
    if (isNotEdge(rowIndex, colIndex - 1)
            &&
            this.myBattleMap.getMap(row, Column.values()[colIndex - 1]) instanceof EnemyShipCell) {
      return true;
    }
    //check down
    if (isNotEdge(rowIndex, colIndex + 1)
            &&
            this.myBattleMap.getMap(row, Column.values()[colIndex + 1]) instanceof EnemyShipCell) {
      return true;
    }
    //check left top
    if (isNotEdge(rowIndex - 1, colIndex - 1)
            &&
            this.myBattleMap.getMap(Row.values()[rowIndex - 1],
                    Column.values()[colIndex - 1]) instanceof EnemyShipCell) {
      return true;
    }
    //check right top
    if (isNotEdge(rowIndex + 1, colIndex - 1)
            &&
            this.myBattleMap.getMap(Row.values()[rowIndex + 1],
                    Column.values()[colIndex - 1]) instanceof EnemyShipCell) {
      return true;
    }

    //check left down
    if (isNotEdge(rowIndex - 1, colIndex + 1)
            &&
            this.myBattleMap.getMap(Row.values()[rowIndex - 1],
                    Column.values()[colIndex + 1]) instanceof EnemyShipCell) {
      return true;
    }

    //check right down
    if (isNotEdge(rowIndex + 1, colIndex + 1)
            &&
            this.myBattleMap.getMap(Row.values()[rowIndex + 1],
                    Column.values()[colIndex + 1]) instanceof EnemyShipCell) {
      return true;
    }

    return false;
  }

  private Coordinate randomHitMode() {
    boolean flag = true;
    Row row = null;
    Column col = null;
    while (flag) {
      Random rand = new Random();
      row = Row.values()[rand.nextInt(10)];
      col = Column.values()[rand.nextInt(10)];


      //Uncomment for testing with user input
      //System.out.println("Debug random mode: ");
      //int location[] = new ReadConsole().inputLocation();
      //row = Row.values()[location[1]];
      //col = Column.values()[location[0]];
      //

      if (!this.isGapCell(row, col) && !myBattleMap.getMap(row, col).getIsHit()) {
        flag = false;
      }
    }
    return new Coordinate(col, row);
  }

  private Coordinate smartHitMode(boolean isPreviousHit,
                                  boolean isPreviousHitSunk, boolean forseChangeDirection) {

    if (isPreviousModeRandomHit || !isPreviousHit || forseChangeDirection) {
      // if previous hit is random hit, we starts from left cell.
      // if previous hit is not random hit, but we pick a wrong direction and miss,
      // we try in order of left, up, right and down.
      boolean flag = true;
      while (flag) {
        StrategyDirection nextDirection = this.findNextDirection(this.previousDirection);
        Coordinate coordinate = findNextCoordinate(this.previousRandomHitCoordinate, nextDirection);
        this.previousDirection = nextDirection;
        if (coordinate != null
                &&
                !myBattleMap.getMap(coordinate.getRow(), coordinate.getColumn()).getIsHit()) {
          return coordinate;
        }
      }
    } else {
      // since we Hit in previous attempt, we pick the right direction,
      // we continue with this direction
      Coordinate coordinate = this.findNextCoordinate(this.previousHitCoordinate,
              this.previousDirection);
      if (coordinate != null
              &&
              !myBattleMap.getMap(coordinate.getRow(), coordinate.getColumn()).getIsHit()) {
        return coordinate;
      } else {
        //If we need to continue hit in previous direction,
        // but we hit edge, we force to change direction.
        return this.smartHitMode(isPreviousHit, isPreviousHitSunk, true);
      }
    }
    return null;
  }

  private Coordinate findNextCoordinate(Coordinate curr, StrategyDirection nextDir) {
    int rowIndex = curr.getRow().ordinal();
    int colIndex = curr.getColumn().ordinal();
    if (nextDir == StrategyDirection.LEFT) {
      colIndex = curr.getColumn().ordinal() - 1;
    } else if (nextDir == StrategyDirection.RIGHT) {
      colIndex = curr.getColumn().ordinal() + 1;
    } else if (nextDir == StrategyDirection.UP) {
      rowIndex = curr.getRow().ordinal() - 1;
    } else {
      rowIndex = curr.getRow().ordinal() + 1;
    }
    if (this.isNotEdge(rowIndex, colIndex)) {
      return new Coordinate(Column.values()[colIndex], Row.values()[rowIndex]);
    }
    return null;
  }

  private StrategyDirection findNextDirection(StrategyDirection dir) {
    if (dir == null) {
      return StrategyDirection.LEFT;
    }
    if (dir == StrategyDirection.LEFT) {
      return StrategyDirection.UP;
    }
    if (dir == StrategyDirection.UP) {
      return StrategyDirection.RIGHT;
    }
    if (dir == StrategyDirection.RIGHT) {
      return StrategyDirection.DOWN;
    }
    return null;
  }



  @Override
  public Coordinate generateAttackCoordinate(boolean isPreviousHit, boolean isPreviousHitSunk) {
    boolean isCurrentModeRandomHit;
    if (isPreviousHitSunk || (isPreviousModeRandomHit && !isPreviousHit)) {
      isCurrentModeRandomHit = true;
      this.previousDirection = null; //reset the direction to null;
    } else {
      isCurrentModeRandomHit = false;
    }

    Coordinate result = null;
    if (isCurrentModeRandomHit) {
      result = this.randomHitMode();
      this.previousRandomHitCoordinate = result;
    } else {
      result = this.smartHitMode(isPreviousHit, isPreviousHitSunk, false);
    }

    this.isPreviousModeRandomHit = isCurrentModeRandomHit;
    this.previousHitCoordinate = result;
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }

    SmartStrategy that = (SmartStrategy) obj;

    if (isPreviousModeRandomHit != that.isPreviousModeRandomHit) {
      return false;
    }
    if (previousRandomHitCoordinate != null ? !previousRandomHitCoordinate.equals(
            that.previousRandomHitCoordinate) : that.previousRandomHitCoordinate != null) {
      return false;
    }
    if (previousHitCoordinate != null ? !previousHitCoordinate.equals(that.previousHitCoordinate)
            : that.previousHitCoordinate != null) {
      return false;
    }
    if (previousDirection != that.previousDirection) {
      return false;
    }
    return myBattleMap != null ? myBattleMap.equals(that.myBattleMap) : that.myBattleMap == null;
  }

  @Override
  public int hashCode() {
    int result = (isPreviousModeRandomHit ? 1 : 0);
    result = 31 * result
            + (previousRandomHitCoordinate != null
            ? previousRandomHitCoordinate.hashCode() : 0);
    result = 31 * result
            + (previousHitCoordinate != null ? previousHitCoordinate.hashCode() : 0);
    result = 31 * result
            + (previousDirection != null ? previousDirection.hashCode() : 0);
    result = 31 * result
            + (myBattleMap != null ? myBattleMap.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "SmartStrategy{"
            +
            "isPreviousModeRandomHit="
            + isPreviousModeRandomHit
            +
            ", previousRandomHitCoordinate="
            + previousRandomHitCoordinate
            +
            ", previousHitCoordinate="
            + previousHitCoordinate
            +
            ", previousDirection="
            + previousDirection
            +
            ", myBattleMap="
            + myBattleMap
            +
            '}';
  }
}
