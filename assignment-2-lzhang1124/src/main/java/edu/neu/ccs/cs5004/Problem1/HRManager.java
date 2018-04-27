package edu.neu.ccs.cs5004.Problem1;

/**
 * Represents a Circle in our shapes program.
 */
public class HRManager extends AbstractEmployee {
    private Integer recruited;

    public HRManager(Name name, Integer workload, Integer salary, Integer paidVacation,
                     String employeeID, Integer servedYear, Integer recruited) {
        super(name, workload, salary, paidVacation, employeeID, servedYear);
        this.recruited = recruited;
        this.salary = super.salary + 5000 * recruited;
        this.paidVacation = super.paidVacation + this.extraVacation(this.servedYear)
                + 7;
    }

    public String uniqueBehavior() {
        return "Let's hunt talents!";
    }

    public Integer getRecruited() {
        return recruited;
    }


    @Override
    public String toString() {
        return "HRManager{" +
                "recruited=" + recruited +
                ", name=" + name +
                ", workload=" + workload +
                ", salary=" + salary +
                ", paidVacation=" + paidVacation +
                ", employeeID='" + employeeID + '\'' +
                ", servedYear=" + servedYear +
                '}';
    }
}