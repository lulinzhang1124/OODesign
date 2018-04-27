package edu.neu.ccs.cs5004.assignment5.battleship.strategy;

import edu.neu.ccs.cs5004.assignment5.battleship.controller.ReadConsole;
import edu.neu.ccs.cs5004.assignment5.battleship.enums.Column;
import edu.neu.ccs.cs5004.assignment5.battleship.enums.Coordinate;
import edu.neu.ccs.cs5004.assignment5.battleship.enums.Row;
import edu.neu.ccs.cs5004.assignment5.battleship.maps.IbattleMap;
import edu.neu.ccs.cs5004.assignment5.battleship.viewer.Printer;

/**
 * Represents user strategy of the game.
 */
public class UserStrategy implements Strategy {

  private ReadConsole reader;
  private IbattleMap myBattleMap;

  /**
   * Constructor for user strategy.
   *
   * @param reader      - a reader that can accept user's input.
   * @param myBattleMap - a battle map.
   */
  public UserStrategy(ReadConsole reader, IbattleMap myBattleMap) {
    this.reader = reader;
    this.myBattleMap = myBattleMap;
  }

  /**
   * An exception that indicate cell has been previously hit.
   */
  public static class CellHasBeenHitByUserException extends Exception {
  }

  /**
   * Gets the coordinate of attack for this time.
   *
   * @param isPreviousHit     - indicate if the coordinate has been previously hit.
   * @param isPreviousHitSunk - indicate if previous hit result in a sunk ship.
   * @return - the coordinate of attack for this time.
   */
  @Override
  public Coordinate generateAttackCoordinate(boolean isPreviousHit, boolean isPreviousHitSunk)
          throws ReadConsole.UserInteruptException {
    Printer.CONSOLE_PRINTER.printMessage("inputAttackLocation");
    boolean flag = true;
    Row row = null;
    Column col = null;
    while (flag) {
      try {
        int[] location = reader.inputLocation();
        row = Row.values()[location[1]];
        col = Column.values()[location[0]];
        boolean isCellHitBefore = myBattleMap.getMap(row, col).getIsHit();
        if (isCellHitBefore) {
          throw new CellHasBeenHitByUserException();
        }
        flag = false;
      } catch (CellHasBeenHitByUserException e) {
        Printer.CONSOLE_PRINTER.printMessage("duplicateAttack");
      }

    }
    return new Coordinate(col, row);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }

    UserStrategy that = (UserStrategy) obj;

    if (reader != null ? !reader.equals(that.reader) : that.reader != null) {
      return false;
    }
    return myBattleMap != null ? myBattleMap.equals(that.myBattleMap) : that.myBattleMap == null;
  }

  @Override
  public int hashCode() {
    int result = reader != null ? reader.hashCode() : 0;
    result = 31 * result + (myBattleMap != null ? myBattleMap.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "UserStrategy{"
            + "reader="
            + reader
            + ", myBattleMap="
            + myBattleMap
            +
            '}';
  }
}
