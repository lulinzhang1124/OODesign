package edu.neu.ccs.cs5004.assignment5.battleship.controller;


import edu.neu.ccs.cs5004.assignment5.battleship.maps.BattleMap;
import edu.neu.ccs.cs5004.assignment5.battleship.maps.FleetMap;
import edu.neu.ccs.cs5004.assignment5.battleship.viewer.Printer;

/**
 * Represents the debug mode for the game.
 */
public class DebugGame extends AbstractGame implements Game {

  private ReadConsole reader = new ReadConsole();


  /**
   * Constructor for DebugGame.
   */
  public DebugGame() throws ReadConsole.UserInteruptException {
    debugMapConfig();
  }

  /**
   * Constructor for testing.
   */
  public DebugGame(ReadConsole reader) throws ReadConsole.UserInteruptException {
    this.reader = reader;
    debugMapConfig();
  }

  /**
   * Set the original ships number for debug mode.
   */
  private void debugMapConfig() throws ReadConsole.UserInteruptException {
    Printer.CONSOLE_PRINTER.printMessage("debugWelcome");

    Printer.CONSOLE_PRINTER.printMessage("inputBattleshipNum");
    final int battleshipNum = reader.inputNum(0, 3);

    Printer.CONSOLE_PRINTER.printMessage("inputCruiserNum");

    int cruiserNum = reader.inputNum(0, 3);

    Printer.CONSOLE_PRINTER.printMessage("inputSubmarineNum");

    int submarineNum = reader.inputNum(0, 3);

    Printer.CONSOLE_PRINTER.printMessage("inputDestroyerNum");

    int destroyerNum = reader.inputNum(0, 3);

    computer.ifleetMap = new FleetMap(battleshipNum, cruiserNum, submarineNum, destroyerNum);
    computer.ibattleMap = new BattleMap(battleshipNum, cruiserNum, submarineNum, destroyerNum);
    human.ifleetMap = new FleetMap(battleshipNum, cruiserNum, submarineNum, destroyerNum);
    human.ibattleMap = new BattleMap(battleshipNum, cruiserNum, submarineNum, destroyerNum);

  }

  /**
   * Print the maps for the game.
   *
   * @param printer the printer tobe print the map.
   */
  @Override
  public void printMaps(Printer printer) {
    printer.toConsole(this);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    if (!super.equals(obj)) {
      return false;
    }

    DebugGame debugGame = (DebugGame) obj;

    return reader != null ? reader.equals(debugGame.reader) : debugGame.reader == null;
  }

  @Override
  public int hashCode() {
    int result = super.hashCode();
    result = 31 * result + (reader != null ? reader.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "DebugGame{"
            +
            "reader="
            + reader
            +
            '}';
  }
}
