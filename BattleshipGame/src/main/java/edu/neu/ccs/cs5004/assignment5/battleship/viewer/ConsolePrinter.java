package edu.neu.ccs.cs5004.assignment5.battleship.viewer;

import edu.neu.ccs.cs5004.assignment5.battleship.cells.Cell;
import edu.neu.ccs.cs5004.assignment5.battleship.cells.EnemyShipCell;
import edu.neu.ccs.cs5004.assignment5.battleship.cells.SpecificShipCell;
import edu.neu.ccs.cs5004.assignment5.battleship.cells.WaterCell;
import edu.neu.ccs.cs5004.assignment5.battleship.controller.DebugGame;
import edu.neu.ccs.cs5004.assignment5.battleship.controller.RealGame;
import edu.neu.ccs.cs5004.assignment5.battleship.enums.Column;
import edu.neu.ccs.cs5004.assignment5.battleship.enums.Row;
import edu.neu.ccs.cs5004.assignment5.battleship.maps.Map;

/**
 * Represents a console printer.
 */

public class ConsolePrinter implements Printer {

  /**
   * Send the given object data to the printer.
   *
   * @param cell the cell to be sent.
   */
  @Override
  public void toConsole(Cell cell) {
    cell.prettyPrint(new ConsolePrinter());
  }


  /**
   * Print the waterCell.
   *
   * @param waterCell the waterCell to be printed.
   */
  @Override
  public void toConsole(WaterCell waterCell) {

    if (waterCell.getIsHit() == true) {
      System.out.print(" ~ ");
    } else {
      System.out.print("   ");
    }
  }

  /**
   * Print the enemyShipCell.
   *
   * @param enemyShipCell the cell to be printed.
   */
  @Override
  public void toConsole(EnemyShipCell enemyShipCell) {
    if (enemyShipCell.getSunkShip() == true) {
      System.out.print(" / ");
    } else {
      System.out.print(" X ");
    }
  }

  /**
   * Print the the specificShipCell.
   *
   * @param specificShipCell the cell to be printed.
   */
  @Override
  public void toConsole(SpecificShipCell specificShipCell) {
    if (specificShipCell.getShip().isSunk()) {
      System.out.print(" / ");
    } else if (specificShipCell.getIsHit()) {
      System.out.print(" X ");
    } else {
      System.out.print(" O ");
    }
  }

  /**
   * Print the debug game maps.
   *
   * @param debugGame the debugGame to be printed.
   */
  @Override
  public void toConsole(DebugGame debugGame) {
    printMessage("playerMap");
    debugGame.getHuman().getIfleetMap().prettyPrint(this);
    printMessage("playerBattleMap");
    debugGame.getHuman().getIbattleMap().prettyPrint(this);

    printMessage("computerMap");
    debugGame.getComputer().getIfleetMap().prettyPrint(this);
    //print computer's battle map here
    printMessage("computerBattleMap");
    debugGame.getComputer().getIbattleMap().prettyPrint(this);
  }

  /**
   * Print the real game maps.
   *
   * @param realGame the realgame to be printed.
   */
  @Override
  public void toConsole(RealGame realGame) {
    printMessage("playerMap");
    realGame.getHuman().getIfleetMap().prettyPrint(this);
    printMessage("playerBattleMap");
    realGame.getHuman().getIbattleMap().prettyPrint(this);
  }

  /**
   * Print the map.
   *
   * @param map the map to be printed.
   */
  @Override
  public void toConsole(Map map) {

    System.out.println();
    System.out.println("    A   B   C   D   E   F   G   H   I   J"); //alphabetic notation
    System.out.println(" ###########################################");
    for (int i = 0; i < Map.ROW; i++) { //rows
      System.out.print(" #|");
      for (int j = 0; j < Map.COLUMN; j++) { //columns

        this.toConsole(map.getMap(Row.values()[i], Column.values()[j]));
        System.out.print("|");
      }
      System.out.println("# " + (i + 1)); //next row
      if (i != Map.ROW - 1) {
        System.out.println(" #|---------------------------------------|#");//linebreak between rows
      } else {
        System.out.println(" ###########################################");
      }
    }

    System.out.println("    A   B   C   D   E   F   G   H   I   J");//alphabetic notation
    System.out.println();

  }

  /**
   * Print messages for the game.
   *
   * @param string the corresponding string needs to print.
   */
  @Override
  public void printMessage(String string) {
    switch (string) {
      case "welcome":
        System.out.println("-----------------------------------------");
        System.out.println("Welcome to Battleship Game.");
        System.out.println("Enter q anytime if you want to exit the Game.");
        System.out.println("-----------------------------------------");
        break;
      case "debugWelcome":
        System.out.println("-------------------------------");
        System.out.println("Debug Mode for Battleship Game.");
        break;
      case "mapSetUp":
        System.out.println("Finish fleet maps set up. Let's start!");
        System.out.println("----------------------------------------");
        break;
      case "chooseGameMode":
        System.out.println("Which mode do you want to play?");
        System.out.println("1. Game Mode\n2. Debug Mode");
        break;
      case "humanAttackStrategy":
        System.out.println("Please choose attack strategy for human player.");
        System.out.println("1. User Attack\n2. Random Attack\n3. Smart strategy");
        break;
      case "computerAttackStrategy":
        System.out.println("Please choose attack strategy for computer player.");
        System.out.println("1. Random Attack\n2. Smart strategy");
        break;
      case "winnerHuman":
        System.out.println("Game over, the winner is the Player.");
        break;
      case "winnerComputer":
        System.out.println("Game over, the winner is the Computer.");
        break;
      case "playerMap":
        System.out.println("---------------Player's Map------------------");
        break;
      case "playerBattleMap":
        System.out.println("------------Player's Battle Map---------------");
        break;
      case "computerMap":
        System.out.println("---------------Computer's Map-----------------");
        break;
      case "computerBattleMap":
        System.out.println("------------Computer's Battle Map-------------");
        break;
      case "exit":
        System.out.println("Exit!");
        return;
      case "wrongInput":
        System.out.println(Printer.ANSI_RED + "Incorrect input! Please enter again!"
                + Printer.ANSI_RESET);
        return;
      case "generateMapForComputer":
        System.out.println("Generate random fleet map for Computer.");
        return;
      case "computerTurn":
        System.out.println("Computer's turn:");
        return;

      case "playerTurn":
        System.out.println("Player's turn:");
        return;

      case "inputBattleshipNum":
        System.out.println("Please input the number of battleship you want in your fleet map. ");
        return;
      case "inputCruiserNum":
        System.out.println("Please input the number of cruiser you want in your fleet map. ");
        return;
      case "inputSubmarineNum":
        System.out.println("Please input the number of submarine you want in your fleet map. ");
        return;
      case "inputDestroyerNum":
        System.out.println("Please input the number of destroyer you want in your fleet map. ");
        return;

      case "playerChooseModeToPlaceShip":
        System.out.println("==== Setting up fleet map for Player  ====");
        System.out.println("Please choose the ways to place the ships");
        System.out.print("1. RANDOM placement\n2. USER placement\n");
        return;

      case "generateHumanRandomMap":
        System.out.println("Generate random fleet map for Player now.");
        return;

      case "finishGenerateRandomMap":
        System.out.print("Finish generate random fleet map.\n\n");
        return;

      case "inputShipLocation":
        System.out.println("Please input location you want to placed ship: \n");
        return;

      case "inputDirections":
        System.out.println("Please input direction you want to placed ship: ");
        System.out.print("1. Horizontal\n2. Vertical\n");
        return;

      case "wrongCoordination":
        System.out.println(Printer.ANSI_RED + "Can't placed ship -- Wrong coordinate. Please "
                + "input again."
                + Printer.ANSI_RESET);
        return;

      case "chooseShipType":
        System.out.println("Please input ship type you want to placed: ");
        System.out.print("1. Battleship\n2. Cruiser\n3. Submarine\n4. Destroyer\n");
        return;

      case "enoughBattleship":
        System.out.println(
                Printer.ANSI_RED + "Map already has enough Battleships. Please input again."
                        + Printer.ANSI_RESET);
        return;

      case "enoughCruiser":
        System.out.println(
                Printer.ANSI_RED + "Map already has enough Cruisers. Please input again."
                        + Printer.ANSI_RESET);
        return;

      case "enoughSubmarine":
        System.out.println(
                Printer.ANSI_RED + "Map already has enough Submarines. Please input again."
                        + Printer.ANSI_RESET);
        return;

      case "enoughDestroyer":
        System.out.println(
                Printer.ANSI_RED + "Map already has enough Destroyers. Please input again."
                        + Printer.ANSI_RESET);
        return;

      case "finishFleetMap":
        System.out.println("Finish set up fleet map.");
        return;

      case "gameMode":
        System.out.println("-------------------------------");
        System.out.println("Game Mode for Battleship Game.");
        return;

      case "inputAttackLocation":
        System.out.println("Please enter the location you want to attack:");
        return;

      case "duplicateAttack":
        System.out.println("You attacked this cell before, please choose a different one");
        return;

      default:
        return;
    }

  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    return true;
  }

  @Override
  public int hashCode() {
    return 31;
  }

  @Override
  public String toString() {
    return "ConsolePrinter{}";
  }
}
