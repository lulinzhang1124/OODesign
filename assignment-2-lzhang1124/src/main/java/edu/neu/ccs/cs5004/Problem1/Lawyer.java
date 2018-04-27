package edu.neu.ccs.cs5004.Problem1;

/**
 * Represents a Circle in our shapes program.
 */
public class Lawyer extends AbstractEmployee {

    // private Integer salary;

    public Lawyer(Name name, Integer workload, Integer salary, Integer paidVacation,
                  String employeeID, Integer servedYear) {
        super(name, workload, salary, paidVacation, employeeID, servedYear);
        this.salary = super.getSalary() * 2;
        this.paidVacation = super.paidVacation + this.extraVacation(this.servedYear);
    }

    public String uniqueBehavior() {
        return "Let's sue!";
    }

    @Override
    public String toString() {
        return "Lawyer{" +
                "name=" + name +
                ", workload=" + workload +
                ", salary=" + salary +
                ", paidVacation=" + paidVacation +
                ", employeeID='" + employeeID + '\'' +
                ", servedYear=" + servedYear +
                '}';
    }
}
