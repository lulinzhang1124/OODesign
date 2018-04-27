package edu.neu.ccs.cs5004.assignment5.battleship.ships;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SubmarineTest {

  edu.neu.ccs.cs5004.assignment5.battleship.ships.Submarine submarine;
  private Submarine sameRefShip;
  private Submarine sameStateShip;
  private Submarine diffShip;
  private Submarine anotherShip;
  private Submarine nullShip;

  @Before
  public void setUp() throws Exception {
    submarine = new Submarine(1, 0);
    sameRefShip = submarine;
    sameStateShip= new Submarine(1,0);
    diffShip = new Submarine(1,1);
    anotherShip = new Submarine(1,0);
    nullShip = null;
  }


  @Test
  public void testEquals() {
    Assert.assertTrue(submarine.equals(submarine));
    Assert.assertTrue(submarine.equals(sameRefShip));
    Assert.assertTrue(submarine.equals(sameStateShip));
    Assert.assertTrue(sameStateShip.equals(submarine));
    Assert.assertEquals(submarine.equals(sameStateShip),sameStateShip.equals(submarine));
    Assert.assertEquals(submarine.equals(sameStateShip)&& sameStateShip.equals(anotherShip),anotherShip.equals(submarine));
    Assert.assertFalse(submarine.equals(diffShip));
    Assert.assertFalse(submarine.equals(new Integer(1)));
    Assert.assertFalse(submarine.equals(nullShip));
  }

  @Test
  public void testHashCode() {
    Assert.assertEquals(submarine.equals(sameRefShip), submarine.hashCode()==sameRefShip.hashCode());
    Assert.assertEquals(submarine.equals(sameStateShip), submarine.hashCode()==sameStateShip.hashCode());
  }

  @Test
  public void toStringTest() {
    String string = "Submarine{" +
            "getSize=" + submarine.getSize() +
            ", numberHitCells=" + submarine.numberHitCells +
            '}';
    assertEquals(string, submarine.toString());
  }
}