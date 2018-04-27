package edu.neu.ccs.cs5004.assignment6.midtermq2.bonus;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import edu.neu.ccs.cs5004.assignment6.midtermq2.Name;
import edu.neu.ccs.cs5004.assignment6.midtermq2.Patient;
import edu.neu.ccs.cs5004.assignment6.midtermq2.Urgency;

public class PatientWrapperTest {

  private PatientWrapper patientWrapper;
  private PatientWrapper sameRefWrapper;
  private PatientWrapper sameStateWrapper;
  private PatientWrapper yetAnotherWrapper;
  private PatientWrapper diffWrapper;
  private PatientWrapper nullWrapper;
  private Patient patient;
  private Patient patient2;
  private Urgency urgency;
  private Urgency urgency1;
  private Name name;
  private Name name1;

  @Before
  public void setUp() throws Exception {

    name = new Name("John","Doe");
    name1 = new Name("Mary","Jane");
    urgency = new Urgency(10);
    urgency1 = new Urgency(5);
    patient = new Patient(urgency,name,1);
    patient2 = new Patient(urgency1,name1,1);

    patientWrapper = new PatientWrapper(patient);
    sameRefWrapper = patientWrapper;
    sameStateWrapper = new PatientWrapper(patient);
    yetAnotherWrapper = new PatientWrapper(patient);
    diffWrapper = new PatientWrapper(patient2);
    nullWrapper = null;

  }

  @Test
  public void getPatient() {
    Assert.assertEquals(patient,patientWrapper.getPatient());
  }

  @Test
  public void compareTo() {
    Assert.assertEquals(0,patientWrapper.compareTo(diffWrapper));
  }
  @Test
  public void testEquals(){
    Assert.assertTrue(patientWrapper.equals(patientWrapper));
    Assert.assertTrue(patientWrapper.equals(sameRefWrapper));
    Assert.assertTrue(patientWrapper.equals(sameStateWrapper));
    Assert.assertTrue(sameStateWrapper.equals(patientWrapper));
    Assert.assertEquals(patientWrapper.equals(sameStateWrapper),sameStateWrapper.equals(patientWrapper));
    Assert.assertEquals(patientWrapper.equals(sameStateWrapper)&& sameStateWrapper.equals(sameStateWrapper),sameStateWrapper.equals(patientWrapper));
    Assert.assertFalse(patientWrapper.equals(diffWrapper));
    Assert.assertFalse(patientWrapper.equals(new Long(1)));
    Assert.assertFalse(patientWrapper.equals(nullWrapper));
  }

  @Test
  public void testHashCode() {
    Assert.assertEquals(patientWrapper.equals(sameRefWrapper), patientWrapper.hashCode()==sameRefWrapper.hashCode());
    Assert.assertEquals(patientWrapper.equals(sameStateWrapper), patientWrapper.hashCode()==sameStateWrapper.hashCode());

  }

  @Test
  public void testToString(){
    String temp = "PatientWrapper{" +
            "patient=" + patientWrapper.getPatient()+
            '}';
    Assert.assertEquals(temp,patientWrapper.toString());
  }

}