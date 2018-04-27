package edu.neu.ccs.cs5004.assignment5.battleship.viewer;

import edu.neu.ccs.cs5004.assignment5.battleship.cells.Cell;
import edu.neu.ccs.cs5004.assignment5.battleship.cells.EnemyShipCell;
import edu.neu.ccs.cs5004.assignment5.battleship.cells.SpecificShipCell;
import edu.neu.ccs.cs5004.assignment5.battleship.cells.WaterCell;
import edu.neu.ccs.cs5004.assignment5.battleship.controller.DebugGame;
import edu.neu.ccs.cs5004.assignment5.battleship.controller.RealGame;
import edu.neu.ccs.cs5004.assignment5.battleship.maps.Map;

/**
 * Represents a printer.
 */

public interface Printer {

  String ANSI_RESET = "\u001B[0m";
  String ANSI_RED = "\u001B[31m";
  Printer CONSOLE_PRINTER = new ConsolePrinter();

  /**
   * Print the cell map.
   *
   * @param map the map to be printed.
   */
  void toConsole(Map map);

  /**
   * Send the given object data to the printer.
   *
   * @param cell the cell to be sent.
   */
  void toConsole(Cell cell);

  /**
   * Print the waterCell.
   *
   * @param waterCell the waterCell to be printed.
   */
  void toConsole(WaterCell waterCell);

  /**
   * Print the enemyShipCell.
   *
   * @param enemyShipCell the cell to be printed.
   */
  void toConsole(EnemyShipCell enemyShipCell);

  /**
   * Print the the specificShipCell.
   *
   * @param specificShipCell the cell to be printed.
   */
  void toConsole(SpecificShipCell specificShipCell);

  /**
   * Print the debug game maps.
   *
   * @param debugGame the debugGame to be printed.
   */
  void toConsole(DebugGame debugGame);

  /**
   * Print the real game maps.
   *
   * @param realGame the realgame to be printed.
   */
  void toConsole(RealGame realGame);

  /**
   * Print messages for the game.
   *
   * @param string the corresponding string need to print.
   */
  void printMessage(String string);

}
