package edu.neu.ccs.cs5004.assignment6.midtermq2;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import edu.neu.ccs.cs5004.assignment6.problem2.Pq;

import static org.junit.Assert.*;

public class EqTest {
  private Eq empty;
  private Eq single;
  private Eq uniqueElements;
  private Eq sameRefEq;
  private Eq sameStateEq;
  private Eq yetAnotherEq;
  private Eq nullEq;
  private static final Urgency highUrgency = new Urgency(10);
  private static final Urgency lowUrgency = new Urgency(1);
  private static final Name jonS = new Name("jon", "S");
  private static final Name ramseyB = new Name("ramsey", "B");
  private static final Name jammieL = new Name("Jammie", "L");
  private static final Name dannyT = new Name("danny", "T");
  Patient mostUrgentPatient,mostUrgentPatient1,nextMostUrgentPatient,lowUrgentPatient,
          anotherPatient;

  @Before
  public void setUp() throws Exception {
    empty = new Eq();
    single = new Eq();
    uniqueElements = new Eq();
    mostUrgentPatient = new Patient(highUrgency,jonS,2);
    mostUrgentPatient1 = new Patient(highUrgency,jonS,1);
    nextMostUrgentPatient = new Patient(highUrgency,ramseyB,3);
    lowUrgentPatient = new Patient(lowUrgency,jammieL,1);
    single.add(mostUrgentPatient1);
    uniqueElements.add(lowUrgentPatient);
    uniqueElements.add(mostUrgentPatient);
    uniqueElements.add(nextMostUrgentPatient);
    anotherPatient = new Patient(highUrgency,jammieL,6);
    sameRefEq = uniqueElements;
    sameStateEq = new Eq();
    sameStateEq.add(lowUrgentPatient);
    sameStateEq.add(mostUrgentPatient);
    sameStateEq.add(nextMostUrgentPatient);
    yetAnotherEq = new Eq();
    yetAnotherEq.add(lowUrgentPatient);
    yetAnotherEq.add(mostUrgentPatient);
    yetAnotherEq.add(nextMostUrgentPatient);
    nullEq = null;
  }

  @Test
  public void getQueue() {
    Assert.assertEquals(new Pq(),empty.getQueue());
  }

  @Test
  public void nextPatient() {
    assertEquals(lowUrgentPatient, uniqueElements.nextPatient());
  }

  @Test(expected = IllegalArgumentException.class)
  public void nextPatient1() {
    empty.nextPatient();
    assertEquals(lowUrgentPatient, uniqueElements.nextPatient());
  }

  @Test
  public void removeNext() {
    single.removeNext();
    assertEquals(empty,single);

    uniqueElements.removeNext();
    empty.add(mostUrgentPatient);
    empty.add(nextMostUrgentPatient);
    assertEquals(empty,uniqueElements);
  }

  @Test(expected = IllegalArgumentException.class)
  public void removeNext1() {
    empty.removeNext();}


  @Test(expected = IllegalArgumentException.class)
  public void nextMostUrgent() {
    empty.nextMostUrgent();
  }

  @Test(expected = IllegalArgumentException.class)
  public void removeMostUrgent() {
    empty.removeMostUrgent();
  }

  @Test
  public void add() {
    empty.add(mostUrgentPatient1);

    assertEquals(single,empty);
  }



  @Test
  public void isEmpty() {
    assertTrue(empty.isEmpty());
    assertFalse(uniqueElements.isEmpty());
  }

  @Test
  public void size() {
    assertEquals(new Integer(0),empty.size());
    assertEquals(new Integer(3),uniqueElements.size());

  }

@Test
public void testEquals(){
  Assert.assertTrue(uniqueElements.equals(uniqueElements));
  Assert.assertTrue(uniqueElements.equals(sameRefEq));
  Assert.assertTrue(uniqueElements.equals(sameStateEq));
  Assert.assertTrue(sameStateEq.equals(uniqueElements));
  Assert.assertEquals(uniqueElements.equals(sameStateEq),sameStateEq.equals(uniqueElements));
  Assert.assertEquals(uniqueElements.equals(sameStateEq)&& sameStateEq.equals(yetAnotherEq),yetAnotherEq.equals(uniqueElements));
  Assert.assertFalse(uniqueElements.equals(single));
  Assert.assertFalse(uniqueElements.equals(new Long(1)));
  Assert.assertFalse(uniqueElements.equals(nullEq));
}

  @Test
  public void testHashCode() {
    Assert.assertEquals(uniqueElements.equals(sameRefEq), uniqueElements.hashCode()==sameRefEq.hashCode());
    Assert.assertEquals(uniqueElements.equals(sameStateEq), uniqueElements.hashCode()==sameStateEq.hashCode());

  }

  @Test
  public void testToString() {
    String temp = "Eq{"
            +
            "queue="
            + uniqueElements.getQueue()
            +
            '}';

    Assert.assertEquals(temp,uniqueElements.toString());
  }


}