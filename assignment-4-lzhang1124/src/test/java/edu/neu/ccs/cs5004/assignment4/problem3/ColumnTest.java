package edu.neu.ccs.cs5004.assignment4.problem3;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ColumnTest {
  Column column1;
  Column column2;

  @Before
  public void setUp() throws Exception {
    column1 = Column.A;
    column2 = Column.C;
  }

  @Test
  public void valueOf() {
    assertEquals(column1, Column.valueOf(0));
  }

  @Test(expected = IndexOutOfBoundsException.class)
  public void valueOfTest() {
    Column.valueOf(10);
  }

  @Test
  public void toStringTest() {
    assertEquals("Column{}", column1.toString());
  }
}