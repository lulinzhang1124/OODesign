package edu.neu.ccs.cs5004.assignment6.midtermq2.blackbox;

import org.junit.Before;
import org.junit.Test;

import edu.neu.ccs.cs5004.assignment6.midtermq2.EmergencyQueue;
import edu.neu.ccs.cs5004.assignment6.midtermq2.Name;
import edu.neu.ccs.cs5004.assignment6.midtermq2.Patient;
import edu.neu.ccs.cs5004.assignment6.midtermq2.Urgency;

import static org.junit.Assert.*;

public class EmergencyQueueTest {

  private EmergencyQueue empty;
  private EmergencyQueue single;
  private EmergencyQueue uniqueElements;
  private static final Urgency highUrgency = new Urgency(10);
  private static final Urgency mediumUrgency = new Urgency(6);
  private static final Urgency lowUrgency = new Urgency(1);
  private static final Name jonS = new Name("jon", "S");
  private static final Name ramseyB = new Name("ramsey", "B");
  private static final Name jammieL = new Name("Jammie", "L");
  private static final Name dannyT = new Name("danny", "T");
  Patient mostUrgentPatient,mostUrgentPatient1,nextMostUrgentPatient,lowUrgentPatient,
      mediumUrgentPatient,anotherPatient;

  @Before
  public void setUp() throws Exception {
    empty = EmergencyQueue.createEmpty();
    mostUrgentPatient = new Patient(highUrgency,jonS,2);
    mostUrgentPatient1 = new Patient(highUrgency,jonS,1);
    nextMostUrgentPatient = new Patient(highUrgency,ramseyB,3);
    mediumUrgentPatient = new Patient(mediumUrgency,dannyT,2);
    lowUrgentPatient = new Patient(lowUrgency,jammieL,1);
    single = EmergencyQueue.createEmpty();
    single.add(mostUrgentPatient1);
    uniqueElements = EmergencyQueue.createEmpty();
    uniqueElements.add(lowUrgentPatient);
    uniqueElements.add(mostUrgentPatient);
    uniqueElements.add(nextMostUrgentPatient);
    anotherPatient = new Patient(highUrgency,jammieL,5);
  }


  @Test(expected = IllegalArgumentException.class)
  public void nextPatient() {
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


  @Test
  public void add() {
    empty.add(mostUrgentPatient1);

    assertEquals(empty,single);
  }

  @Test
  public void nextMostUrgent() {
    single.removeMostUrgent();
    single.add(mediumUrgentPatient);
    single.add(mostUrgentPatient);
    assertEquals(single.nextMostUrgent(),uniqueElements.nextMostUrgent());
  }

  @Test
  public void removeMostUrgent() {
    single.removeMostUrgent();
    assertEquals(single,empty);
  }

  @Test
  public void isEmpty() {
    assertTrue(empty.isEmpty());
    assertFalse(single.isEmpty());
  }

  @Test
  public void size() {
    assertEquals(new Integer(3),uniqueElements.size());
    assertEquals(new Integer(0),empty.size());
  }


}