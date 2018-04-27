package edu.neu.ccs.cs5004.assignment6.midtermq2;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PatientTest {
  private Patient patient;
  private Patient sameRefPatient;
  private Patient sameStatePatient;
  private Patient yetAnotherPatient;
  private Patient diffPatient;
  private Patient nullPatient;
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
    patient = new Patient(urgency,name,2);
    sameRefPatient = patient;
    sameStatePatient = new Patient(urgency,name,2);
    yetAnotherPatient = new Patient(urgency,name,2);
    diffPatient = new Patient(urgency1,name1,2);
    nullPatient = null;

  }

  @Test
  public void setOrder() {
    patient.setOrder(1);
  }

  @Test
  public void getOrder() {
    Assert.assertEquals(new Integer(2),patient.getOrder());
  }

  @Test
  public void getUrgency() {
    Assert.assertEquals(urgency,patient.getUrgency());
  }


  @Test
  public void compareTo() {
    Assert.assertEquals(1,patient.compareTo(diffPatient));
    Assert.assertEquals(0,patient.compareTo(patient));
    Assert.assertEquals(-1,diffPatient.compareTo(patient));
  }

  @Test
  public void equals() {

    Assert.assertTrue(patient.equals(patient));
    Assert.assertTrue(patient.equals(sameRefPatient));
    Assert.assertTrue(patient.equals(sameStatePatient));
    Assert.assertTrue(sameStatePatient.equals(patient));
    Assert.assertEquals(patient.equals(sameStatePatient),sameStatePatient.equals(patient));
    Assert.assertEquals(patient.equals(sameStatePatient)&& sameStatePatient.equals(yetAnotherPatient),yetAnotherPatient.equals(patient));
    Assert.assertFalse(patient.equals(diffPatient));
    Assert.assertFalse(patient.equals(new Long(1)));
    Assert.assertFalse(patient.equals(nullPatient));



  }

  @Test
  public void testHashCode() {

    Assert.assertEquals(patient.equals(sameRefPatient), patient.hashCode()==sameRefPatient.hashCode());
    Assert.assertEquals(patient.equals(sameStatePatient), patient.hashCode()==sameStatePatient.hashCode());

  }

  @Test
  public void testToString() {
    String temp = "Patient{" +
            "urgency=" + urgency +
            ", name=" + name +
            ", order=" + patient.getOrder() +
            '}';
    Assert.assertEquals(temp,patient.toString());

  }
}