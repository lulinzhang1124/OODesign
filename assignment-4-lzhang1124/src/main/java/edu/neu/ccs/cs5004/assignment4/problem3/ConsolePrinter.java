package edu.neu.ccs.cs5004.assignment4.problem3;

/**
 * Represents a console printer.
 */

public class ConsolePrinter implements Printer {

  @Override
  public void toConsole(Map map) {
    prettyPrint(map);
  }

  /**
   * Print the map.
   *
   * @param map the map to be printed
   */
  void prettyPrint(Map map) {

    System.out.println();
    System.out.println("    A   B   C   D   E   F   G   H   I   J"); //alphabetic notation
    System.out.println(" ###########################################");
    for (int i = 0; i < Map.ROW; i++) { //rows
      System.out.print(" #|");
      for (int j = 0; j < Map.COLUMN; j++) { //columns
        if (map.getMap(Row.valueOf(i), Column.valueOf(j)).getClass() == OpenSeaCell.class
            || map.getMap(Row.valueOf(i), Column.valueOf(j)).getClass() == GapCell.class) {
          waterCellPrint();

        } else if (map.getMap(Row.valueOf(i), Column.valueOf(j)).getClass()
            == SpecificShipCell.class) {
          shipCellPrint();

        }
        System.out.print("|");
      }
      System.out.println("# " + (i + 1)); //next row
      if (i != Map.ROW - 1) {
        System.out.println(" #|---------------------------------------|#"); //linebreak between rows
      } else {
        System.out.println(" ###########################################");
      }
    }

    System.out.println("    A   B   C   D   E   F   G   H   I   J");//alphabetic notation
    System.out.println();

  }

  /**
   * Print a water cell.
   */
  void waterCellPrint() {
    System.out.print("   ");
  }

  /**
   * Print a ship cell.
   */
  void shipCellPrint() {
    System.out.print(" O ");
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
