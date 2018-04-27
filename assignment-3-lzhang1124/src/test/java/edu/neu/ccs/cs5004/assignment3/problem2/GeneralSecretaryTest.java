package edu.neu.ccs.cs5004.assignment3.problem2;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class GeneralSecretaryTest {

  private GeneralSecretary gs1;
  private GeneralSecretary sameRefGeneralSecretary;
  private GeneralSecretary sameStateAsGeneralSecretary;

  @Before
  public void setUp() throws Exception {
    gs1 = new GeneralSecretary(new Name("Jon", "Snow"), 40, 14,
        "L166Y15", 3);
    sameRefGeneralSecretary = gs1;
    sameStateAsGeneralSecretary = new GeneralSecretary(new Name("Jon", "Snow"), 40, 14,
        "L166Y15", 3);
  }

  @Test
  public void extraVacation() {
    Assert.assertEquals(new Integer(0), gs1.extraVacation());
  }

  @Test
  public void copyFactoryTest() {
    LegalSecretary ls = new LegalSecretary(new Name("Jon", "Snow"), 40, 14,
        "L166Y15", 3);
    Assert.assertEquals(ls, gs1.copyFactory(gs1));

  }

  @Test
  public void promoteTest() {
    LegalSecretary ls = new LegalSecretary(new Name("Jon", "Snow"), 40, 14,
        "L166Y15", 3);
    Assert.assertEquals(ls, gs1.promote(gs1));

  }

  @Test
  public void equals() {
    GeneralSecretary nullGeneralSecretary = null;
    GeneralSecretary yetAnotherGeneralSecretary = new GeneralSecretary(new Name("Jon", "Snow"), 40,
        14, "L166Y15", 3);
    GeneralSecretary diffGeneralSecretary = new GeneralSecretary(new Name("Julie", "West"), 40,
        14, "L166Y15", 3);
    GeneralSecretary diffGeneralSecretary2 = new GeneralSecretary(new Name("Jon", "Snow"), 35,
        14, "L166Y15", 3);
    GeneralSecretary diffGeneralSecretary4 = new GeneralSecretary(new Name("Jon", "Snow"), 40,
        15, "L166Y15", 3);
    GeneralSecretary diffGeneralSecretary5 = new GeneralSecretary(new Name("Jon", "Snow"), 40,
        14, "L166Y15", 1);
    GeneralSecretary diffGeneralSecretary6 = new GeneralSecretary(new Name("Jon", "Snow"), 40,
        14, "L166Y18", 3);

    assertTrue(gs1.equals(gs1)); // reflexivity
    assertTrue(gs1.equals(sameRefGeneralSecretary)); // trivial condition both reference the same
    assertTrue(gs1.equals(sameStateAsGeneralSecretary)); // both objects should have the same
    assertTrue(sameStateAsGeneralSecretary.equals(gs1)); //symmetry

    assertFalse(gs1.equals(diffGeneralSecretary)); //objects have different state
    assertFalse(gs1.equals(diffGeneralSecretary2));
    assertFalse(gs1.equals(diffGeneralSecretary4));
    assertFalse(gs1.equals(diffGeneralSecretary5));
    assertFalse(gs1.equals(diffGeneralSecretary6));
    assertFalse(gs1.equals(nullGeneralSecretary)); // GeneralSecretary is NOT null
    assertFalse(gs1.equals(new Integer(4)));

  }

  @Test
  public void hashCodeTest() {
    assertEquals(gs1.equals(sameRefGeneralSecretary), gs1.hashCode() == sameRefGeneralSecretary
        .hashCode()); //same objects have the same hashCode
    assertEquals(gs1.equals(sameStateAsGeneralSecretary), gs1.hashCode() ==
        sameStateAsGeneralSecretary.hashCode());
  }

  @Test
  public void toStringTest() {
    String temp = "GeneralSecretary{" +
        "name=" + gs1.name +
        ", workload=" + gs1.getWorkload() +
        ", salary=" + gs1.salary +
        ", paidVacation=" + gs1.paidVacation +
        ", employeeId='" + gs1.getEmployeeId() + '\'' +
        ", servedYear=" + gs1.getServedYear() +
        '}';
    assertEquals(temp, gs1.toString());
  }
}