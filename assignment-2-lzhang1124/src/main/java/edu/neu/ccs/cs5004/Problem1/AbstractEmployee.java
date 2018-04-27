package edu.neu.ccs.cs5004.Problem1;

import java.util.Objects;

/**
 * Represents the common properties of a shape
 */
public abstract class AbstractEmployee implements Employee {
    /**
     * Represents the common properties of a shape
     */
    protected Name name;
    protected Integer workload;
    protected Integer salary;
    protected Integer paidVacation;
    protected String employeeID;
    protected Integer servedYear;

    public AbstractEmployee(Name name, Integer workload, Integer salary, Integer paidVacation,
                            String employeeID, Integer servedYear) {
        this.name = name;
        this.workload = workload;
        this.salary = salary;
        this.paidVacation = paidVacation;
        this.employeeID = employeeID;
        this.servedYear = servedYear;
    }


    /**
     * Getter for property 'pin'.
     *
     * @return Value for property 'pin'.
     */
    public Name getName() {
        return name;
    }

    public Integer getWorkload() {
        return workload;
    }

    public Integer getSalary() {
        return salary;
    }

    public Integer getPaidVacation() {
        return paidVacation;
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public Integer getServedYear() {
        return servedYear;
    }

    //add Bonus
    public Integer addBonus(Integer bonus) {
        this.salary = this.getSalary() + bonus;
        return this.salary;
    }

    public Integer extraVacation(Integer servedYear) {
        return 2 * servedYear;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractEmployee that = (AbstractEmployee) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(workload, that.workload) &&
                Objects.equals(salary, that.salary) &&
                Objects.equals(paidVacation, that.paidVacation) &&
                Objects.equals(employeeID, that.employeeID) &&
                Objects.equals(servedYear, that.servedYear);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, workload, salary, paidVacation, employeeID, servedYear);
    }

    @Override
    public String toString() {
        return "AbstractEmployee{" +
                "name=" + name +
                ", workload=" + workload +
                ", salary=" + salary +
                ", paidVacation=" + paidVacation +
                ", employeeID='" + employeeID + '\'' +
                ", servedYear=" + servedYear +
                '}';
    }
}


