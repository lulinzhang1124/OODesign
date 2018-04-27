package edu.neu.ccs.cs5004.assignment5.battleship.ships;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BattleshipTest {

  private Battleship battleship;
  private Battleship sameRefship;
  private Battleship sameStateShip;
  private Battleship diffShip;
  private Battleship anotherShip;
  private Battleship nullShip;

  @Before
  public void setUp() throws Exception {
    battleship=new Battleship(4,3);
    sameRefship = battleship;
    sameStateShip= new Battleship(4,3);
    diffShip = new Battleship(4,2);
    anotherShip = new Battleship(4,3);
    nullShip = null;
  }

  @Test
  public void equals() {
    Assert.assertTrue(battleship.equals(battleship));
    Assert.assertTrue(battleship.equals(sameRefship));
    Assert.assertTrue(battleship.equals(sameStateShip));
    Assert.assertTrue(sameStateShip.equals(battleship));
    Assert.assertEquals(battleship.equals(sameStateShip),sameStateShip.equals(battleship));
    Assert.assertEquals(battleship.equals(sameStateShip)&& sameStateShip.equals(anotherShip),anotherShip.equals(battleship));
    Assert.assertFalse(battleship.equals(diffShip));
    Assert.assertFalse(battleship.equals(new Integer(1)));
    Assert.assertFalse(battleship.equals(nullShip));
  }

  @Test
  public void testHashCode() {
    Assert.assertEquals(battleship.equals(sameRefship), battleship.hashCode()==sameRefship.hashCode());
    Assert.assertEquals(battleship.equals(sameStateShip), battleship.hashCode()==sameStateShip.hashCode());
  }

  @Test
  public void toStringTest() {
    String string = "Battleship{" +
            "getSize=" + battleship.getSize() +
            ", numberHitCells=" + battleship.getNumberHitCells() +
            '}';
    assertEquals(string, battleship.toString());
  }
}