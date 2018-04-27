package edu.neu.ccs.cs5004.assignment4.problem3;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class MapTest {
  private Map map;
  private Map sameRefMap;
  private Map sameStateMap;
  private Cell shipcell;


  @Before
  public void mapUp() throws Exception {
    map = new Map();
    sameRefMap = map;
    sameStateMap = new Map();
    shipcell = new SpecificShipCell(false, new NotSunk(),
        new Destoryer(1, 0));
  }

  @Test
  public void mapMap() {
    map.setMap(Row.ROW2, Column.B, shipcell);

    assertEquals(map.getMap(Row.ROW2, Column.B), shipcell);
  }

  @Test
  public void getMap() {
    assertEquals(new OpenSeaCell(false), map.getMap(Row.ROW1, Column.H));
  }

  @Test
  public void prettyPrint() {
    ConsolePrinter printer = new ConsolePrinter();
    map.prettyPrint(printer);
  }

  @Test
  public void equals() {

    Map nullmap = null;
    Map yetAnothermap = new Map();
    Map map1 = new Map();
    map1.setMap(Row.ROW8, Column.C, shipcell);


    assertTrue(map.equals(map));
    assertTrue(map.equals(sameRefMap));
    assertTrue(map.equals(sameStateMap));

    assertFalse(map.equals(nullmap));
    assertFalse(map.equals(new Integer(9)));

    assertEquals(map.equals(sameStateMap), sameStateMap.equals(map));
    assertEquals(map.equals(sameStateMap) && sameStateMap.equals(yetAnothermap),
        yetAnothermap.equals(map));

    assertFalse(map.equals(map1));

  }

  @Test
  public void hashCodeTest() {

    Cell enemyshipcell = new EnemyShipCell(false, new NotSunk(), false);
    Cell gapcell = new GapCell(false);

    map.setMap(Row.ROW2, Column.H, shipcell);
    map.setMap(Row.ROW2, Column.I, gapcell);
    map.setMap(Row.ROW8, Column.B, enemyshipcell);

    assertEquals(map.equals(sameRefMap), map.hashCode() == sameRefMap.hashCode());
    assertEquals(map.equals(sameStateMap), map.hashCode() == sameStateMap.hashCode());
  }

  @Test
  public void toStringTest() {
    String temp = "Map{" +
        "map=" + Arrays.toString(map.mapcell) +
        '}';
    assertEquals(temp, map.toString());
  }
}