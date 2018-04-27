package edu.neu.ccs.cs5004.assignment3.problem2;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class LawyerTest {
  private Lawyer lawyer;
  private Lawyer sameReflawyer;
  private Lawyer sameStateAslawyer;

  @Before
  public void setUp() throws Exception {
    lawyer = new Lawyer(new Name("Jon", "Snow"), 40, 14,
        "L166Y15", 3);
    sameReflawyer = lawyer;
    sameStateAslawyer = new Lawyer(new Name("Jon", "Snow"), 40, 14,
        "L166Y15", 3);
  }

  @Test
  public void sue() {
    assertEquals("Let's sue!", lawyer.sue());
  }

  @Test
  public void uniqueBehavior() {
    assertEquals("Let's sue!", lawyer.uniqueBehavior());
  }

  @Test
  public void equals() {
    Lawyer nulllawyer = null;
    Lawyer yetAnotherlawyer = new Lawyer(new Name("Jon", "Snow"), 40,
        14, "L166Y15", 3);
    Lawyer difflawyer = new Lawyer(new Name("Julie", "West"), 40,
        14, "L24Y17", 3);
    Lawyer difflawyer2 = new Lawyer(new Name("Jon", "Snow"), 35,
        14, "L166Y15", 3);
    Lawyer difflawyer4 = new Lawyer(new Name("Jon", "Snow"), 40,
        15, "L166Y15", 3);
    Lawyer difflawyer5 = new Lawyer(new Name("Jon", "Snow"), 40,
        14, "L166Y15", 1);
    Lawyer difflawyer6 = new Lawyer(new Name("Jon", "Snow"), 40,
        14, "L166Y18", 3);

    assertTrue(lawyer.equals(lawyer)); // reflexivity
    assertTrue(lawyer.equals(sameReflawyer)); // trivial condition both reference the same
    assertTrue(lawyer.equals(sameStateAslawyer)); // both objects should have the same
    assertTrue(sameStateAslawyer.equals(lawyer)); //symmetry
    assertEquals(lawyer.equals(sameStateAslawyer) && sameStateAslawyer.equals
        (yetAnotherlawyer), yetAnotherlawyer.equals(lawyer)); //transitivity
    assertFalse(lawyer.equals(difflawyer)); //objects have different state
    assertFalse(lawyer.equals(difflawyer2));
    assertFalse(lawyer.equals(difflawyer4));
    assertFalse(lawyer.equals(difflawyer5));
    assertFalse(lawyer.equals(difflawyer6));
    assertFalse(lawyer.equals(nulllawyer)); // lawyer is NOT null
    assertFalse(lawyer.equals(new Integer(4)));
  }

  @Test
  public void hashCodeTest() {
    assertEquals(lawyer.equals(sameReflawyer), lawyer.hashCode() == sameReflawyer
        .hashCode()); //same objects have the same hashCode
    assertEquals(lawyer.equals(sameStateAslawyer), lawyer.hashCode() ==
        sameStateAslawyer.hashCode());
  }

  @Test
  public void toStringTest() {
    String temp = "Lawyer{" + "name="
        + lawyer.getName() + ", workload="
        + lawyer.getWorkload() + ", salary="
        + lawyer.salary + ", paidVacation="
        + lawyer.paidVacation + ", employeeId='"
        + lawyer.getEmployeeId() + '\''
        + ", servedYear=" + lawyer.getServedYear() + '}';
    assertEquals(temp, lawyer.toString());
  }

}