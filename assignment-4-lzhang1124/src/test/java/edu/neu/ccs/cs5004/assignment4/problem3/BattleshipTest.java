package edu.neu.ccs.cs5004.assignment4.problem3;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BattleshipTest {

  Battleship battleship;

  @Before
  public void setUp() throws Exception {
    battleship = new Battleship(4, 2);
  }

  @Test
  public void toStringTest() {
    String string = "Battleship{" +
        "size=" + battleship.size +
        ", numberHitCells=" + battleship.numberHitCells +
        '}';
    assertEquals(string, battleship.toString());
  }
}