package edu.neu.ccs.cs5004.assignment4.problem3;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ConsolePrinterTest {
  private Map map;
  private ConsolePrinter printer;
  private ConsolePrinter sameRefAsPrinter;
  private ConsolePrinter sameStateAsPrinter;

  @Before
  public void printerUp() throws Exception {
    printer = new ConsolePrinter();
    map = new Map();
    sameRefAsPrinter = printer;
    sameStateAsPrinter = new ConsolePrinter();

  }

  @Test
  public void prettyPrintTest() {
    Cell shipcell = new SpecificShipCell(false, new NotSunk(),
        new Destoryer(1, 0));
    map.setMap(Row.ROW2, Column.B, shipcell);
    printer.prettyPrint(map);
  }

  @Test
  public void waterCellPrint() {
    printer.waterCellPrint();
  }

  @Test
  public void shipCellPrint() {
    printer.shipCellPrint();
  }


  @Test
  public void toConsole() {
    printer.toConsole(map);
  }


  @Test
  public void equals() {
    ConsolePrinter nullprinter = null;

    assertTrue(printer.equals(printer));
    assertTrue(printer.equals(sameRefAsPrinter));
    assertTrue(printer.equals(sameStateAsPrinter));

    assertFalse(printer.equals(nullprinter));
    assertFalse(printer.equals(new Integer(9)));
  }

  @Test
  public void hashCodeTest() {
    assertEquals(printer.equals(sameRefAsPrinter), printer.hashCode() == sameRefAsPrinter.hashCode());
    assertEquals(printer.equals(sameStateAsPrinter), printer.hashCode() == sameStateAsPrinter.hashCode());
  }

  @Test
  public void toStringTest() {
    assertEquals("ConsolePrinter{}", printer.toString());
  }
}