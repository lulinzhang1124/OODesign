package edu.neu.ccs.cs5004.assignment3.problem2.pkg1;

import org.junit.Before;
import org.junit.Test;

import edu.neu.ccs.cs5004.assignment3.problem2.Employee;
import edu.neu.ccs.cs5004.assignment3.problem2.Lawyer;
import edu.neu.ccs.cs5004.assignment3.problem2.Name;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class HrManagerTest {

  private HrManager sameRefHrManager;
  private HrManager sameStateHrManager;
  private HrManager HrManager;

  @Before
  public void setUp() throws Exception {

    HrManager = new HrManager(new Name("Jon", "Snow"), 40, 14,
        "L166Y15", 3, 10);
    sameRefHrManager = HrManager;
    sameStateHrManager = new HrManager(new Name("Jon", "Snow"), 40, 14,
        "L166Y15", 3, 10);

  }

  @Test
  public void getHrManagerSalary() {
    assertEquals(new Salary(90000), HrManager.getEmployeeSalary());
  }

  @Test
  public void HrManagerSalary() {
    Employee lawyer = new Lawyer(new Name("Jon", "Snow"), 40, 14,
        "L166Y15", 3);
    assertEquals(new Salary(80000), HrManager.employeeSalary(lawyer));
  }

  @Test
  public void requestSalaryIncrease() {
    assertEquals("Yes.", HrManager.requestSalaryIncrease(HrManager, 5000));
    assertEquals("No.", HrManager.requestSalaryIncrease(HrManager, 20000));
  }

  @Test
  public void requestSeveralSalaryIncrease() {
  }

  @Test
  public void huntTalents() {
    assertEquals("Let's hunt talents!", HrManager.huntTalents());
  }

  @Test
  public void uniqueBehavior() {
    assertEquals("Let's hunt talents!", HrManager.uniqueBehavior());
  }

  @Test
  public void getRecruited() {
    assertEquals(new Integer(10), HrManager.getRecruited());
  }


  @Test
  public void equals() {
    HrManager nullHrManager = null;
    HrManager yetAnotherHrManager = new HrManager(new Name("Jon", "Snow"), 40,
        14, "L166Y15", 3, 10);
    HrManager diffHrManager = new HrManager(new Name("Julie", "West"), 40,
        14, "L24Y17", 3, 10);
    HrManager diffHrManager2 = new HrManager(new Name("Jon", "Snow"), 35,
        14, "L166Y15", 3, 10);
    HrManager diffHrManager3 = new HrManager(new Name("Jon", "Snow"), 35,
        14, "L166Y18", 1, 8);
    HrManager diffHrManager4 = new HrManager(new Name("Jon", "Snow"), 35,
        15, "L166Y15", 3, 10);
    HrManager diffHrManager5 = new HrManager(new Name("Jon", "Snow"), 35,
        14, "L166Y15", 1, 10);
    HrManager diffHrManager6 = new HrManager(new Name("Jon", "Snow"), 35,
        14, "L166Y18", 1, 10);

    assertTrue(HrManager.equals(HrManager)); // reflexivity
    assertTrue(HrManager.equals(sameRefHrManager)); // trivial condition both reference the same
    assertTrue(HrManager.equals(sameStateHrManager)); // both objects should have the same
    assertTrue(sameStateHrManager.equals(HrManager)); //symmetry
    assertEquals(HrManager.equals(sameStateHrManager) && sameStateHrManager.equals
        (yetAnotherHrManager), yetAnotherHrManager.equals(HrManager)); //transitivity
    assertFalse(HrManager.equals(diffHrManager)); //objects have different state
    assertFalse(HrManager.equals(diffHrManager2));
    assertFalse(HrManager.equals(diffHrManager4));
    assertFalse(HrManager.equals(diffHrManager3));
    assertFalse(HrManager.equals(diffHrManager5));
    assertFalse(HrManager.equals(diffHrManager6));
    assertFalse(HrManager.equals(nullHrManager));

  }

  @Test
  public void hashCodeTest() {
    assertEquals(HrManager.equals(sameRefHrManager), HrManager.hashCode() == sameRefHrManager
        .hashCode());
    assertEquals(HrManager.equals(sameStateHrManager), HrManager.hashCode() ==
        sameStateHrManager.hashCode());
  }

  @Test
  public void toStringTest() {
    String temp = "HrManager{" +
        "recruited=" + HrManager.getRecruited() +
        ", name=" + HrManager.getName() +
        ", salary=" + HrManager.getEmployeeSalary() +
        ", paidVacation=" + HrManager.getPaidVacation() +
        '}';
    assertEquals(temp, HrManager.toString());
  }
}