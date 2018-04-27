package edu.neu.ccs.cs5004.assignment5.battleship.controller;

import edu.neu.ccs.cs5004.assignment5.battleship.cells.EnemyShipCell;
import edu.neu.ccs.cs5004.assignment5.battleship.enums.Coordinate;
import edu.neu.ccs.cs5004.assignment5.battleship.enums.Number;
import edu.neu.ccs.cs5004.assignment5.battleship.viewer.Printer;

/**
 * Represents a computer player of the game.
 */
public class Computer extends AbstractPlayer implements Player {
  /**
   * Constructor for the computer.
   */
  public Computer() {
    super();

  }


  /**
   * Place ships on the map.
   */
  @Override
  public void placeShips() {
    Printer.CONSOLE_PRINTER.printMessage("generateMapForComputer");
    ifleetMap.randomPlaceShip();
  }

  /**
   * Computer's turn to attack.
   *
   * @param human          the human player.
   * @param sunkShipNum    the current sunk ship number.
   * @param previousResult PlayerAttackResult fot previous time.
   * @return the PlayerAttackResult for this attack.
   */
  public PlayerAttackResult computerTurn(Human human,
                                         Integer sunkShipNum, PlayerAttackResult previousResult)
          throws ReadConsole.UserInteruptException {
    Printer.CONSOLE_PRINTER.printMessage("computerTurn");
    Coordinate coordinate = getStrategy().generateAttackCoordinate(previousResult.isHitShip(),
            previousResult.isShipSunk());
    System.out.println("Computer choose to attack " + (char) (coordinate.getColumn().ordinal() + 65)
            + (coordinate.getRow().ordinal() + 1));
    int sunkCount = human.getIfleetMap().attack(coordinate.getRow(), coordinate.getColumn(),
            sunkShipNum);
    this.getIbattleMap().attack(human, coordinate.getRow(), coordinate.getColumn());

    boolean isHit = this.getIbattleMap().getMap(coordinate.getRow(),
            coordinate.getColumn()) instanceof EnemyShipCell;
    boolean isSunk = sunkCount - sunkShipNum ==  Number.ONE.getValue() ;

    return new PlayerAttackResult(coordinate, isHit, isSunk, sunkCount);
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
    return 41;
  }

  @Override
  public String toString() {
    return "Computer{"
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





