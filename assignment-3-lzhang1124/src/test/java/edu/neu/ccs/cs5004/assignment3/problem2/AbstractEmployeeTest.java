package edu.neu.ccs.cs5004.assignment3.problem2;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import edu.neu.ccs.cs5004.assignment3.problem2.pkg1.HrManager;
import edu.neu.ccs.cs5004.assignment3.problem2.pkg1.Salary;

import static org.junit.Assert.*;

public class AbstractEmployeeTest {
  private AbstractEmployee employee;
  private AbstractEmployee sameRefEmployee;
  private AbstractEmployee sameStateAsEmployee;


  @Before
  public void setUp() throws Exception {
    employee = new Lawyer(new Name("Jon", "Snow"), 40, 14,
        "L166Y15", 3);
    sameRefEmployee = employee;
    sameStateAsEmployee = new Lawyer(new Name("Jon", "Snow"), 40, 14,
        "L166Y15", 3);
  }

  @Test
  public void getName() {
    assertEquals(new Name("Jon", "Snow"), employee.getName());
  }

  @Test
  public void getWorkload() {
    assertEquals(new Integer(40), employee.getWorkload());
  }

  @Test
  public void getEmployeeSalary() {
    assertEquals(new Salary(new Integer(80000)), employee.getEmployeeSalary());
  }

  @Test
  public void getPaidVacation() {
    assertEquals(new Integer(20), employee.paidVacation);
  }

  @Test
  public void getEmployeeId() {
    assertEquals("L166Y15", employee.getEmployeeId());
  }

  @Test
  public void getServedYear() {
    assertEquals(new Integer(3), employee.getServedYear());
  }

  @Test
  public void extraVacation() {
    assertEquals(new Integer(6), employee.extraVacation());
  }

  @Test
  public void addBonus() {
    assertEquals(new Salary(85000), employee.addBonus(5000));
    assertEquals(new Salary(80000), employee.addBonus(20000));
  }

  @Test
  public void addBonusEmployees() {
    Employee lawyer = new Lawyer(new Name("Jon", "Snow"), 40,
        14, "L166Y15", 3);
    Employee hr = new HrManager(new Name("Julie", "West"), 40,
        14, "L24Y17", 3, 10);
    Employee ls = new LegalSecretary(new Name("Emma", "Stone"), 40, 14,
        "L166Y19", 1);

    Employee[] employees = {lawyer, hr, ls};
    Salary[] sameSalary = {new Salary(80000), new Salary(90000), new Salary(50000)};
    Salary[] updateSalary = {new Salary(85000), new Salary(95000), new Salary(55000)};
    for (int i = 0; i < 3; i++) {
      assertEquals(sameSalary[i], employee.addBonusEmployees(employees, 20000)[i]);
    }
    for (int i = 0; i < 3; i++) {
      assertEquals(updateSalary[i], employee.addBonusEmployees(employees, 5000)[i]);
    }
  }

  @Test
  public void equals() {
    AbstractEmployee nullEmployee = null;
    AbstractEmployee yetAnotherEmployee = new Lawyer(new Name("Jon", "Snow"), 40,
        14, "L166Y15", 3);
    AbstractEmployee diffEmployee = new Lawyer(new Name("Julie", "West"), 40,
        14, "L166Y15", 3);
    AbstractEmployee diffEmployee2 = new Lawyer(new Name("Jon", "Snow"), 35,
        14, "L166Y15", 3);
    AbstractEmployee diffEmployee3 = new Lawyer(new Name("Jon", "White"), 40,
        14, "L166Y15", 3);
    AbstractEmployee diffEmployee4 = new Lawyer(new Name("Jon", "Snow"), 40,
        15, "L166Y15", 3);
    AbstractEmployee diffEmployee5 = new Lawyer(new Name("Jon", "Snow"), 40,
        14, "L166Y15", 1);
    AbstractEmployee diffEmployee6 = new Lawyer(new Name("Jon", "Snow"), 40,
        14, "L166Y18", 3);

    assertTrue(employee.equals(employee)); // reflexivity
    assertTrue(employee.equals(sameRefEmployee)); // trivial condition both reference the same
    assertTrue(employee.equals(sameStateAsEmployee)); // both objects should have the same
    assertTrue(sameStateAsEmployee.equals(employee)); //symmetry
    assertEquals(employee.equals(sameStateAsEmployee) && sameStateAsEmployee.equals
        (yetAnotherEmployee), yetAnotherEmployee.equals(employee)); //transitivity
    assertFalse(employee.equals(diffEmployee)); //objects have different state
    assertFalse(employee.equals(diffEmployee2));
    assertFalse(employee.equals(diffEmployee3));
    assertFalse(employee.equals(diffEmployee4));
    assertFalse(employee.equals(diffEmployee5));
    assertFalse(employee.equals(diffEmployee6));
    assertFalse(employee.equals(nullEmployee)); // Employee is NOT null
    assertFalse(employee.equals(new Integer(4)));
  }

  @Test
  public void hashCodeTest() {
    Assert.assertEquals(employee.equals(sameRefEmployee), employee.hashCode() == sameRefEmployee
        .hashCode()); //same objects have the same hashCode
    Assert.assertEquals(employee.equals(sameStateAsEmployee), employee.hashCode() ==
        sameStateAsEmployee.hashCode());
  }
}