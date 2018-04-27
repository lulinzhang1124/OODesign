package edu.neu.ccs.cs5004.Problem1;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class AbstractEmployeeTest {
    private AbstractEmployee Employee;
    private AbstractEmployee sameRefEmployee;
    private AbstractEmployee sameStateAsEmployee;
    private AbstractEmployee yetAnotherEmployee;
    private AbstractEmployee diffEmployee;
    private AbstractEmployee nullEmployee = null;


    @Before
    public void setUp() throws Exception {
        Employee = new Lawyer(new Name("Jon", "Snow"), 40, 40000, 14,
                "L166Y15", 3);
        sameRefEmployee = Employee;
        sameStateAsEmployee = new Lawyer(new Name("Jon", "Snow"), 40, 40000,
                14, "L166Y15", 3);
        yetAnotherEmployee = new Lawyer(new Name("Jon", "Snow"), 40, 40000,
                14, "L166Y15", 3);
        diffEmployee = new Lawyer(new Name("Julie", "West"), 40, 40000,
                14, "L24Y17", 1);

    }

    @Test
    public void getName() {
        Assert.assertEquals(new Name("Jon", "Snow"), Employee.getName());
    }

    @Test
    public void getWorkload() {
        Assert.assertEquals(new Integer(40), Employee.workload);
    }

    @Test
    public void getSalary() {
        Assert.assertEquals(new Integer(80000), Employee.salary);
    }

    @Test
    public void getPaidVacation() {
        Assert.assertEquals(new Integer(20), Employee.paidVacation);
    }

    @Test
    public void getEmployeeID() {
        Assert.assertEquals("L166Y15", Employee.employeeID);
    }

    @Test
    public void getServedYear() {
        Assert.assertEquals(new Integer(3), Employee.servedYear);
    }

    @Test
    public void addBonusTest() {
        Assert.assertEquals(new Integer(90000), Employee.addBonus(10000));
    }

    @Test
    public void extraVacation() {
        Assert.assertEquals(new Integer(6), Employee.extraVacation(Employee.servedYear));
    }

    @Test
    public void testEquals() throws Exception {
        Assert.assertTrue(Employee.equals(Employee)); // reflexivity
        Assert.assertTrue(Employee.equals(sameRefEmployee)); // trivial condition both reference the same object
        Assert.assertTrue(Employee.equals(sameStateAsEmployee)); // both objects should have the same state
        Assert.assertTrue(sameStateAsEmployee.equals(Employee)); //symmetry
        Assert.assertEquals(Employee.equals(sameStateAsEmployee) && sameStateAsEmployee.equals(yetAnotherEmployee), yetAnotherEmployee.equals(Employee)); //transitivity
        Assert.assertFalse(Employee.equals(diffEmployee)); //objects have different state
        Assert.assertFalse(Employee.equals(nullEmployee)); // Employee is NOT null

    }

    @Test
    public void testHashCode() throws Exception {
        Assert.assertEquals(Employee.equals(sameRefEmployee), Employee.hashCode() == sameRefEmployee.hashCode()); //same objects have the same hashCode
        Assert.assertEquals(Employee.equals(sameStateAsEmployee), Employee.hashCode() == sameStateAsEmployee.hashCode()); //equal objects have the same hashCode


    }

    @Test
    public void toStringTest() {
        String temp = "AbstractEmployee{" +
                "name=" + Employee.name +
                ", workload=" + Employee.workload +
                ", salary=" + Employee.salary +
                ", paidVacation=" + Employee.paidVacation +
                ", employeeID='" + Employee.employeeID + '\'' +
                ", servedYear=" + Employee.servedYear +
                '}';
    }
}