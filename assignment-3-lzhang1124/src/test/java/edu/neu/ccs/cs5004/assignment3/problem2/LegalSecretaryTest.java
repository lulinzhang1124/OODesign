package edu.neu.ccs.cs5004.assignment3.problem2;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class LegalSecretaryTest {

  private LegalSecretary sameRefLegalSecretary;
  private LegalSecretary sameStateLegalSecretary;
  private LegalSecretary ls1;

  @Before
  public void setUp() throws Exception {
    ls1 = new LegalSecretary(new Name("Jon", "Snow"), 40, 14,
        "L166Y15", 3);

    sameRefLegalSecretary = ls1;
    sameStateLegalSecretary = new LegalSecretary(new Name("Jon", "Snow"), 40, 14,
        "L166Y15", 3);
  }


  @Test
  public void copyFactoryTest() {
    LegalSecretary gs1 = new LegalSecretary(new Name("Jon", "Snow"), 40, 14,
        "L166Y15", 3);
    Assert.assertEquals(ls1, gs1.copyFactory(gs1));
  }

  @Test
  public void prepareLegalDoc() {
    Assert.assertEquals("Let's prepare legal documents!", ls1.prepareLegalDoc());
  }

  @Test
  public void uniqueBehavior() {
    String temp = "Let's schedule meetings. Let's prepare legal documents!";
    Assert.assertEquals(temp, ls1.uniqueBehavior());
  }

  @Test
  public void equals() {
    LegalSecretary nullls1 = null;
    LegalSecretary yetAnotherls1 = new LegalSecretary(new Name("Jon", "Snow"), 40,
        14, "L166Y15", 3);
    LegalSecretary diffls1 = new LegalSecretary(new Name("Julie", "West"), 40,
        14, "L166Y15", 3);
    LegalSecretary diffls12 = new LegalSecretary(new Name("Jon", "Snow"), 35,
        14, "L166Y15", 3);
    LegalSecretary diffls14 = new LegalSecretary(new Name("Jon", "Snow"), 40,
        15, "L166Y15", 3);
    LegalSecretary diffls15 = new LegalSecretary(new Name("Jon", "Snow"), 40,
        14, "L166Y15", 1);
    LegalSecretary diffls16 = new LegalSecretary(new Name("Jon", "Snow"), 40,
        14, "L166Y18", 3);

    assertTrue(ls1.equals(ls1)); // reflexivity
    assertTrue(ls1.equals(sameRefLegalSecretary)); // trivial condition both reference the same
    assertTrue(ls1.equals(sameStateLegalSecretary)); // both objects should have the same
    assertTrue(sameStateLegalSecretary.equals(ls1)); //symmetry

    assertFalse(ls1.equals(diffls1)); //objects have different state
    assertFalse(ls1.equals(diffls12));
    assertFalse(ls1.equals(diffls14));
    assertFalse(ls1.equals(diffls15));
    assertFalse(ls1.equals(diffls16));
    assertFalse(ls1.equals(nullls1)); // ls1 is NOT null
    assertFalse(ls1.equals(new Integer(4)));

  }

  @Test
  public void hashCodeTest() {
    assertEquals(ls1.equals(sameRefLegalSecretary), ls1.hashCode() == sameRefLegalSecretary
        .hashCode()); //same objects have the same hashCode
    assertEquals(ls1.equals(sameStateLegalSecretary), ls1.hashCode() ==
        sameStateLegalSecretary.hashCode());
  }

  @Test
  public void toStringTest() {
    String temp = "LegalSecretary{" +
        " name=" + ls1.name +
        ", workload=" + ls1.getWorkload() +
        ", salary=" + ls1.salary +
        ", paidVacation=" + ls1.paidVacation +
        ", employeeId='" + ls1.getEmployeeId() + '\'' +
        ", servedYear=" + ls1.getServedYear() +
        '}';
    Assert.assertEquals(temp, ls1.toString());
  }
}