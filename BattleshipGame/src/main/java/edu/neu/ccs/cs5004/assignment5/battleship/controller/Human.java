package edu.neu.ccs.cs5004.assignment5.battleship.controller;


import edu.neu.ccs.cs5004.assignment5.battleship.cells.EnemyShipCell;
import edu.neu.ccs.cs5004.assignment5.battleship.enums.Column;
import edu.neu.ccs.cs5004.assignment5.battleship.enums.Coordinate;
import edu.neu.ccs.cs5004.assignment5.battleship.enums.Direction;
import edu.neu.ccs.cs5004.assignment5.battleship.enums.Number;
import edu.neu.ccs.cs5004.assignment5.battleship.enums.Row;
import edu.neu.ccs.cs5004.assignment5.battleship.ships.Battleship;
import edu.neu.ccs.cs5004.assignment5.battleship.ships.Cruiser;
import edu.neu.ccs.cs5004.assignment5.battleship.ships.Destroyer;
import edu.neu.ccs.cs5004.assignment5.battleship.ships.Ship;
import edu.neu.ccs.cs5004.assignment5.battleship.ships.Submarine;
import edu.neu.ccs.cs5004.assignment5.battleship.viewer.ConsolePrinter;
import edu.neu.ccs.cs5004.assignment5.battleship.viewer.Printer;

/**
 * Represents a human player in the game.
 */
public class Human extends AbstractPlayer implements Player {

  public Human() {
    super();
  }


  /**
   * Place ships on the map (user/random).
   */
  @Override
  public void placeShips() throws ReadConsole.UserInteruptException {
    Printer.CONSOLE_PRINTER.printMessage("playerChooseModeToPlaceShip");

    ReadConsole reader = new ReadConsole();

    int num = reader.inputNum(1, 2);
    if (num ==  Number.ONE.getValue() ) {
      Printer.CONSOLE_PRINTER.printMessage("generateHumanRandomMap");
      ifleetMap.randomPlaceShip();
    } else {
      userPlaceAllShips(reader);
    }
  }

  /**
   * Place one ship on the map.
   *
   * @param reader bufferReader to get the input information.
   */
  public void userPlaceShip(ReadConsole reader) throws ReadConsole.UserInteruptException {

    // get ship type
    Ship ship = chooseShipType(reader);

    // get row and column
    while (true) {

      Printer.CONSOLE_PRINTER.printMessage("inputShipLocation");

      int[] location = reader.inputLocation();
      Row row = Row.values()[location[1]];
      Column col = Column.values()[location[0]];


      //get direction
      Printer.CONSOLE_PRINTER.printMessage("inputDirections");

      int direction = reader.inputNum(1, 2);
      Direction dir;

      if (direction ==  Number.ONE.getValue() ) {
        dir = Direction.HORIZONTAL;
      } else {
        dir = Direction.VERTICAL;
      }

      if (ifleetMap.canPlaceShip(ship, row, col, dir)) {

        ifleetMap.placeShip(ship, row, col, dir);
        ifleetMap.prettyPrint(new ConsolePrinter());
        return;
      } else {
        Printer.CONSOLE_PRINTER.printMessage("wrongCoordination");
      }
    }
  }

  /**
   * Get the ship type which to be put on the map.
   *
   * @param reader bufferReader to gain the input.
   * @return the ship to be placed on the map.
   */
  Ship chooseShipType(ReadConsole reader) throws ReadConsole.UserInteruptException {

    Printer.CONSOLE_PRINTER.printMessage("chooseShipType");

    int num = reader.inputNum(1, 4);
    Ship ship;

    switch (num) {
      case 1:
        ship = new Battleship(4, 0);
        if (ifleetMap.getCountBattleship() == ifleetMap.getBattleshipNum()) {
          Printer.CONSOLE_PRINTER.printMessage("enoughBattleship");
          return chooseShipType(reader);
        }
        break;
      case 2:
        ship = new Cruiser(3, 0);
        if (ifleetMap.getCountCruiser() == ifleetMap.getCruiserNum()) {
          Printer.CONSOLE_PRINTER.printMessage("enoughCruisers");
          return chooseShipType(reader);
        }
        break;
      case 3:
        ship = new Submarine(2, 0);
        if (ifleetMap.getCountSubmarine() == ifleetMap.getSubmarineNum()) {
          Printer.CONSOLE_PRINTER.printMessage("enoughSubmarine");
          return chooseShipType(reader);
        }
        break;
      default:
        ship = new Destroyer(1, 0);
        if (ifleetMap.getCountDestroyer() == ifleetMap.getDestroyerNum()) {
          Printer.CONSOLE_PRINTER.printMessage("enoughDestroyer");
          return chooseShipType(reader);
        }
    }
    return ship;
  }

  /**
   * Place all the ships on the map.
   *
   * @param reader bufferReader to gain the input.
   */
  void userPlaceAllShips(ReadConsole reader) throws ReadConsole.UserInteruptException {

    while (ifleetMap.getCountBattleship() != ifleetMap.getBattleshipNum()
            || ifleetMap.getCountCruiser() != ifleetMap.getCruiserNum()
            || ifleetMap.getCountSubmarine() != ifleetMap.getSubmarineNum()
            || ifleetMap.getCountDestroyer() != ifleetMap.getDestroyerNum()) {

      userPlaceShip(reader);
    }
    Printer.CONSOLE_PRINTER.printMessage("finishFleetMap");
    return;
  }

  /**
   * Human's turn to attack.
   *
   * @param computer       the computer player
   * @param sunkShipNum    the current sunk ship number.
   * @param previousResult PlayerAttackResult fot previous time.
   * @return the PlayerAttackResult for this attack.
   */
  public PlayerAttackResult humanTurn(Computer computer, Integer sunkShipNum,
                                      PlayerAttackResult previousResult)
          throws ReadConsole.UserInteruptException {
    Printer.CONSOLE_PRINTER.printMessage("playerTurn");

    Coordinate coordinate = getStrategy().generateAttackCoordinate(previousResult.isHitShip(),
            previousResult.isShipSunk());
    System.out.println("Player choose to attack " + (char) (coordinate.getColumn().ordinal() + 65)
            + (coordinate.getRow().ordinal() + 1));
    int sunkCount = computer.getIfleetMap().attack(coordinate.getRow(), coordinate.getColumn(),
            sunkShipNum);
    this.getIbattleMap().attack(computer, coordinate.getRow(), coordinate.getColumn());

    boolean isHit = this.getIbattleMap().getMap(coordinate.getRow(),
            coordinate.getColumn()) instanceof EnemyShipCell;
    boolean isSunk = sunkCount - sunkShipNum ==  Number.ONE.getValue() ;

    return new PlayerAttackResult(coordinate, isHit, isSunk, sunkCount);

  }

  /**
   * Represent an exception is the cell is hit again by the user.
   */
  public static class CellHasBeenHitByUserException extends Exception {
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
    return 49;
  }

  @Override
  public String toString() {
    return "Human{"
            +
            "ifleetMap="
            + ifleetMap
            +
            ", ibattleMap="
            + ibattleMap
            +
            '}';
  }
}
