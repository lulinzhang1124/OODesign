package edu.neu.ccs.cs5004.assignment4.problem3;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CruiserTest {

  Cruiser Cruiser;

  @Before
  public void setUp() throws Exception {
    Cruiser = new Cruiser(4, 2);
  }

  @Test
  public void toStringTest() {
    String string = "Cruiser{" +
        "size=" + Cruiser.size +
        ", numberHitCells=" + Cruiser.numberHitCells +
        '}';
    assertEquals(string, Cruiser.toString());
  }
}