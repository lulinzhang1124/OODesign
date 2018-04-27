package edu.neu.ccs.cs5004.assignment3.problem2.pkg1;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SalaryTest {
  private Salary salary;
  private Salary sameRefSalary;
  private Salary sameStateAsSalary;

  @Before
  public void setUp() throws Exception {
    salary = new Salary(40000);
    sameRefSalary = salary;
    sameStateAsSalary = new Salary(40000);
  }

  @Test
  public void getDollar() {
    assertEquals(new Integer(40000), salary.getDollar());
  }

  @Test
  public void equals() {
    Salary nullSalary = null;
    Salary diffSalary = new Salary(80000);
    Integer num = 40000;

    assertTrue(salary.equals(salary));
    assertTrue(salary.equals(sameRefSalary));
    assertTrue(salary.equals(sameStateAsSalary));
    assertFalse(salary.equals(diffSalary));
    assertFalse(salary.equals(nullSalary));
    assertFalse(salary.equals(num));
  }

  @Test
  public void hashCodeTest() {
    assertEquals(salary.equals(sameRefSalary), salary.hashCode() == sameRefSalary
        .hashCode()); //same objects have the same hashCode
    assertEquals(salary.equals(sameStateAsSalary), salary.hashCode() ==
        sameStateAsSalary.hashCode());
  }


  @Test
  public void toStringTest() {
    String temp = "Salary{" +
        "salary=" + salary.getDollar() +
        '}';
    assertEquals(temp, salary.toString());

  }

}