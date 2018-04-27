package edu.neu.ccs.cs5004.assignment5.battleship.ships;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DestroyerTest {

  edu.neu.ccs.cs5004.assignment5.battleship.ships.Destroyer Destroyer;
  private Destroyer sameRefShip;
  private Destroyer sameStateShip;
  private Destroyer diffShip;
  private Destroyer anotherShip;
  private Destroyer nullShip;

  @Before
  public void setUp() throws Exception {
    Destroyer = new Destroyer(4, 2);
    sameRefShip = Destroyer;
    sameStateShip =  new Destroyer(4, 2);
    anotherShip =  new Destroyer(4, 2);
    diffShip = new Destroyer(4,1);
    nullShip = null;
  }

  @Test
  public void testEquals() {
    Assert.assertTrue(Destroyer.equals(Destroyer));
    Assert.assertTrue(Destroyer.equals(sameRefShip));
    Assert.assertTrue(Destroyer.equals(sameStateShip));
    Assert.assertTrue(sameStateShip.equals(Destroyer));
    Assert.assertEquals(Destroyer.equals(sameStateShip),sameStateShip.equals(Destroyer));
    Assert.assertEquals(Destroyer.equals(sameStateShip)&& sameStateShip.equals(anotherShip),anotherShip.equals(Destroyer));
    Assert.assertFalse(Destroyer.equals(diffShip));
    Assert.assertFalse(Destroyer.equals(new Integer(1)));
    Assert.assertFalse(Destroyer.equals(nullShip));}

  @Test
  public void testHashCode() {
    Assert.assertEquals(Destroyer.equals(sameRefShip), Destroyer.hashCode()==sameRefShip.hashCode());
    Assert.assertEquals(Destroyer.equals(sameStateShip), Destroyer.hashCode()==sameStateShip.hashCode());
  }


  @Test
  public void toStringTest() {
    String string = "Destroyer{" +
            "getSize=" + Destroyer.getSize() +
            ", numberHitCells=" + Destroyer.getNumberHitCells() +
            '}';
    assertEquals(string, Destroyer.toString());
  }
}