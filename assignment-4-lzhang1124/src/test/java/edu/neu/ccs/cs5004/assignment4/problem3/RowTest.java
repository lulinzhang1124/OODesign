package edu.neu.ccs.cs5004.assignment4.problem3;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RowTest {
  Row row1;

  @Before
  public void setUp() throws Exception {
    row1 = Row.ROW2;
  }

  @Test
  public void valueOf() {
    assertEquals(Row.ROW2, Row.valueOf(1));
  }

  @Test(expected = IndexOutOfBoundsException.class)
  public void valueOfTest() {
    Row.valueOf(10);
  }

  @Test
  public void toStringTest() {
    assertEquals("Row{}", row1.toString());
  }
}