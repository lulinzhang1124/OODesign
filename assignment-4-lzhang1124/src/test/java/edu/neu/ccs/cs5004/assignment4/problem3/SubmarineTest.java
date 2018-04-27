package edu.neu.ccs.cs5004.assignment4.problem3;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SubmarineTest {

  Submarine Submarine;

  @Before
  public void setUp() throws Exception {
    Submarine = new Submarine(4, 2);
  }

  @Test
  public void toStringTest() {
    String string = "Submarine{" +
        "size=" + Submarine.size +
        ", numberHitCells=" + Submarine.numberHitCells +
        '}';
    assertEquals(string, Submarine.toString());
  }
}