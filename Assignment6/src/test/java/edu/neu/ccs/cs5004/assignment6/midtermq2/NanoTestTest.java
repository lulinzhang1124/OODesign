package edu.neu.ccs.cs5004.assignment6.midtermq2;

import org.junit.Before;
import org.junit.Test;

public class NanoTestTest {
  private NanoTest nanoTest;
  private EmergencyQueue eq;
  private static final Urgency highUrgency = new Urgency(10);
  private static final Urgency mediumUrgency = new Urgency(6);
  private static final Urgency lowUrgency = new Urgency(1);
  private static final Name jonS = new Name("jon", "S");
  private static final Name ramseyB = new Name("ramsey", "B");
  private Patient patient1;
  private Patient patient2;

  @Before
  public void setUp() throws Exception {
    nanoTest = new NanoTest();
    eq = EmergencyQueue.createEmpty();
    patient1 = new Patient(lowUrgency,jonS,1);
    patient2 = new Patient(highUrgency,ramseyB,2);
    eq.add(patient1);
    eq.add(patient2);

  }

  @Test
  public void removeNextNanoTest() {
    nanoTest.removeNextNanoTest(eq);
  }

  @Test
  public void removeMostUrgentNanoTest() {
    nanoTest.removeMostUrgentNanoTest(eq);
  }

  @Test
  public void addPatientsTest(){
    NanoTest.addPatients(eq,5);
  }

  @Test
  public void createTestQueues(){
    NanoTest.createTestQueues();
  }
}