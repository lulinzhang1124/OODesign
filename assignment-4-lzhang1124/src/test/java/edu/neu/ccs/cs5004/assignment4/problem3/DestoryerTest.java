package edu.neu.ccs.cs5004.assignment4.problem3;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DestoryerTest {

  Destoryer Destoryer;

  @Before
  public void setUp() throws Exception {
    Destoryer = new Destoryer(4, 2);
  }

  @Test
  public void toStringTest() {
    String string = "Destoryer{" +
        "size=" + Destoryer.size +
        ", numberHitCells=" + Destoryer.numberHitCells +
        '}';
    assertEquals(string, Destoryer.toString());
  }
}