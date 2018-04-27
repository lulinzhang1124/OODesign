package edu.neu.ccs.cs5004.assignment6.midtermq2.bonus;

import edu.neu.ccs.cs5004.assignment6.midtermq2.Patient;

import java.util.Objects;

/**
 * A wrapper to wrap patient class and use comparable.
 */
public class PatientWrapper implements Comparable<PatientWrapper> {
  private Patient patient;

  /**
   * Creates a patient wrapper.
   *
   * @param patient - a patient.
   */
  public PatientWrapper(Patient patient) {
    this.patient = patient;
  }

  /**
   * Getter. O(1).
   *
   * @return the patient.
   */
  public Patient getPatient() {
    return patient;
  }

  /**
   * Compare two patient wrapper's arrival order. O(1).
   *
   * @param other - another patient.
   * @return - positive if other patient arrive after current patient, vice versa.
   */
  @Override
  public int compareTo(PatientWrapper other) {
    return other.patient.getOrder() - this.patient.getOrder();
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    PatientWrapper that = (PatientWrapper) obj;
    return Objects.equals(getPatient(), that.getPatient());
  }

  @Override
  public int hashCode() {

    return Objects.hash(getPatient());
  }

  @Override
  public String toString() {
    return "PatientWrapper{"
        +
        "patient="
        + patient
        +
        '}';
  }
}
