package edu.neu.ccs.cs5004.assignment5.battleship.controller;

import edu.neu.ccs.cs5004.assignment5.battleship.viewer.Printer;

/**
 * Represents a real game.
 */
public class RealGame extends AbstractGame implements Game {

  /**
   * Constructor of real game.
   */
  public RealGame() {
    super();
    Printer.CONSOLE_PRINTER.printMessage("gameMode");
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
    return "RealGame{"
            +
            "computer="
            + computer
            +
            ", human="
            + human
            +
            '}';
  }
}
