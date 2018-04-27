package edu.neu.ccs.cs5004.assignment10;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CmdArgumentTest {
  private ICmdArgument handler;
  private String[] args;

  @Before
  public void setUp() throws Exception {
    args = new String[] {"10", "5", "1", "test.csv"};
    handler = new CmdArgument(args);
  }

  @Test
  public void isValid() throws Exception {
    String[] args0 = {"12", "2", "0"};
    assertFalse(new CmdArgument(args0).isValid());
    String[] args1 = {"a", "2", "0", "test.csv"};
    assertFalse(new CmdArgument(args1).isValid());
    String[] args2 = {"-1", "2", "0", "test.csv"};
    assertFalse(new CmdArgument(args2).isValid());
    String[] args3 = {"50000000", "2", "0", "test.csv"};
    assertFalse(new CmdArgument(args3).isValid());
    String[] args4 = {"12", "b", "0", "test.csv"};
    assertFalse(new CmdArgument(args4).isValid());
    String[] args5 = {"12", "-2", "0", "test.csv"};
    assertFalse(new CmdArgument(args5).isValid());
    String[] args6 = {"12", "20000", "0", "test.csv"};
    assertFalse(new CmdArgument(args6).isValid());
    String[] args7 = {"12", "2", "c", "test.csv"};
    assertFalse(new CmdArgument(args7).isValid());
    String[] args8 = {"12", "2", "2", "test.csv"};
    assertFalse(new CmdArgument(args8).isValid());
    String[] args9 = {"12", "2", "2", "test"};
    assertFalse(new CmdArgument(args9).isValid());
  }

  @Test
  public void testEquals() throws Exception {
    assertFalse(handler.equals(null));
    assertTrue(handler.equals(handler));
    assertTrue(handler.equals(new CmdArgument(args)));
    String[] args0 = {"12", "2", "0"};
    assertFalse(handler.equals(new CmdArgument(args0)));
    String[] args1 = {"4", "5", "1", "test.csv"};
    assertFalse(handler.equals(new CmdArgument(args1)));
    String[] args2 = {"10", "2", "1", "test.csv"};
    assertFalse(handler.equals(new CmdArgument(args2)));
    String[] args3 = {"10", "5", "0", "test.csv"};
    assertFalse(handler.equals(new CmdArgument(args3)));
    String[] args4 = {"10", "5", "1", "test1.csv"};
    assertFalse(handler.equals(new CmdArgument(args4)));
    String[] args5 = {"4", "5", "1", null};
    assertTrue((new CmdArgument(args5)).equals(new CmdArgument(args5)));
  }

  @Test
  public void testHashCode() throws Exception {
    String[] args9 = {"12", "2", "2", "test"};
    assertTrue(handler.hashCode() != (new CmdArgument(args9)).hashCode());
  }

}