package edu.neu.ccs.cs5004.assignment5.battleship.ships;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CruiserTest {

  edu.neu.ccs.cs5004.assignment5.battleship.ships.Cruiser cruiser;
  private Cruiser sameRefShip;
  private Cruiser sameStateShip;
  private Cruiser diffShip;
  private Cruiser anotherShip;
  private Cruiser nullShip;

  @Before
  public void setUp() throws Exception {
    cruiser = new Cruiser(3, 2);
    sameRefShip = cruiser;
    sameStateShip = new Cruiser(3,2);
    diffShip = new Cruiser(3,1);
    anotherShip = new Cruiser(3,2);
    nullShip = null;
  }
  @Test
  public void equals() {
    Assert.assertTrue(cruiser.equals(cruiser));
    Assert.assertTrue(cruiser.equals(sameRefShip));
    Assert.assertTrue(cruiser.equals(sameStateShip));
    Assert.assertTrue(sameStateShip.equals(cruiser));
    Assert.assertEquals(cruiser.equals(sameStateShip),sameStateShip.equals(cruiser));
    Assert.assertEquals(cruiser.equals(sameStateShip)&& sameStateShip.equals(anotherShip),anotherShip.equals(cruiser));
    Assert.assertFalse(cruiser.equals(diffShip));
    Assert.assertFalse(cruiser.equals(new Integer(1)));
    Assert.assertFalse(cruiser.equals(nullShip));
  }

  @Test
  public void testHashCode() {
    Assert.assertEquals(cruiser.equals(sameRefShip), cruiser.hashCode()==sameRefShip.hashCode());
    Assert.assertEquals(cruiser.equals(sameStateShip), cruiser.hashCode()==sameStateShip.hashCode());
  }




  @Test
  public void toStringTest() {
    String string = "Cruiser{" +
            "getSize=" + cruiser.getSize() +
            ", numberHitCells=" + cruiser.getNumberHitCells() +
            '}';
    assertEquals(string, cruiser.toString());
  }
}