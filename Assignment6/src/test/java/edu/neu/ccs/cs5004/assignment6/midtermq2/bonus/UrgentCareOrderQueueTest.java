package edu.neu.ccs.cs5004.assignment6.midtermq2.bonus;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import edu.neu.ccs.cs5004.assignment6.midtermq2.Name;
import edu.neu.ccs.cs5004.assignment6.midtermq2.Patient;
import edu.neu.ccs.cs5004.assignment6.midtermq2.Urgency;
import edu.neu.ccs.cs5004.assignment6.problem2.Pq;

import static org.junit.Assert.*;

public class UrgentCareOrderQueueTest {
  private UrgentCareOrderQueue empty;
  private UrgentCareOrderQueue single;
  private UrgentCareOrderQueue uniqueElements;
  private UrgentCareOrderQueue sameRefEq;
  private UrgentCareOrderQueue sameStateEq;
  private UrgentCareOrderQueue yetAnotherEq;
  private UrgentCareOrderQueue nullEq;
  private static final Urgency highUrgency = new Urgency(10);
  private static final Urgency mediumUrgency = new Urgency(6);
  private static final Urgency lowUrgency = new Urgency(1);
  private static final Name jonS = new Name("jon", "S");
  private static final Name ramseyB = new Name("ramsey", "B");
  private static final Name jammieL = new Name("Jammie", "L");
  private static final Name dannyT = new Name("danny", "T");
  Patient mostUrgentPatient, mostUrgentPatient1, nextMostUrgentPatient, lowUrgentPatient,
          mediumUrgentPatient, anotherPatient;

  @Before
  public void setUp() throws Exception {
    empty = new UrgentCareOrderQueue();
    single = new UrgentCareOrderQueue();
    uniqueElements = new UrgentCareOrderQueue();
    mostUrgentPatient = new Patient(highUrgency, jonS,2);
    mostUrgentPatient1 = new Patient(highUrgency, jonS,1);
    nextMostUrgentPatient = new Patient(highUrgency, ramseyB,3);
    mediumUrgentPatient = new Patient(mediumUrgency, dannyT,2);
    lowUrgentPatient = new Patient(lowUrgency, jammieL,1);
    single.add(mostUrgentPatient1);
    uniqueElements.add(lowUrgentPatient);
    uniqueElements.add(mostUrgentPatient);
    uniqueElements.add(nextMostUrgentPatient);
    //anotherPatient = new Patient(highUrgency, jammieL);
    sameRefEq = uniqueElements;
    sameStateEq = new UrgentCareOrderQueue();
    sameStateEq.add(lowUrgentPatient);
    sameStateEq.add(mostUrgentPatient);
    sameStateEq.add(nextMostUrgentPatient);
    yetAnotherEq = new UrgentCareOrderQueue();
    yetAnotherEq.add(lowUrgentPatient);
    yetAnotherEq.add(mostUrgentPatient);
    yetAnotherEq.add(nextMostUrgentPatient);
    nullEq = null;
  }

  @Test
  public void getQueue() {
    Assert.assertEquals(new Pq(), empty.getQueue());
  }

  @Test
  public void add() {
    empty.add(mostUrgentPatient1);

    //System.out.println(empty);
    assertEquals(empty,single);
  }

  @Test
  public void nextPatient() {
    assertEquals(lowUrgentPatient, uniqueElements.nextPatient());
  }

  @Test(expected = NullPointerException.class)
  public void nextPatient1() {
    empty.nextPatient();
  }

  @Test
  public void removeMostUrgent1() {
    single.removeMostUrgent();
    assertEquals(single,empty);
  }

  @Test
  public void removeNext() {
    System.out.println(single);
    System.out.println(single.size());
    single.removeNext();
    assertEquals(empty, single);

    uniqueElements.removeNext();
    empty.add(mostUrgentPatient);
    empty.add(nextMostUrgentPatient);
    assertEquals(empty, uniqueElements);
  }

  @Test(expected = IllegalArgumentException.class)
  public void removeNext1() {
    empty.removeNext();
  }

  @Test
  public void nextMostUrgent1() {
    single.removeMostUrgent();
    single.add(mediumUrgentPatient);
    single.add(mostUrgentPatient);
    assertEquals(single.nextMostUrgent(),uniqueElements.nextMostUrgent());
  }

  @Test(expected = IllegalArgumentException.class)
  public void nextMostUrgent() {
    empty.nextMostUrgent();
  }

  @Test(expected = IllegalArgumentException.class)
  public void removeMostUrgent() {
    empty.removeMostUrgent();
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
  public void testEquals() {
    Assert.assertTrue(uniqueElements.equals(uniqueElements));
    Assert.assertTrue(uniqueElements.equals(sameRefEq));
    Assert.assertTrue(uniqueElements.equals(sameStateEq));
    Assert.assertTrue(sameStateEq.equals(uniqueElements));
    Assert.assertEquals(uniqueElements.equals(sameStateEq), sameStateEq.equals(uniqueElements));
    Assert.assertEquals(uniqueElements.equals(sameStateEq) && sameStateEq.equals(yetAnotherEq), yetAnotherEq.equals(uniqueElements));
    Assert.assertFalse(uniqueElements.equals(single));
    Assert.assertFalse(uniqueElements.equals(new Long(1)));
    Assert.assertFalse(uniqueElements.equals(nullEq));
  }

  @Test
  public void testHashCode() {
    Assert.assertEquals(uniqueElements.equals(sameRefEq), uniqueElements.hashCode() == sameRefEq.hashCode());
    Assert.assertEquals(uniqueElements.equals(sameStateEq), uniqueElements.hashCode() == sameStateEq.hashCode());

  }

  @Test
  public void testToString() {
    String temp = "Eq{"
            +
            "queue="
            + uniqueElements.getQueue()
            +
            '}';

    Assert.assertEquals(temp, uniqueElements.toString());
  }
}