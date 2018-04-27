package edu.neu.ccs.cs5004.assignment6.midtermq2;

import java.util.Objects;

/**
 * Represents a patient.
 */
public class Patient implements Comparable<Patient> {
  private Urgency urgency;
  private Name name;
  private Integer order;
  private static final Integer ZERO = 0;


  /**
   * Create a new patient with its urgency and name.
   *
   * @param urgency given urgency value of the patient
   * @param name    of the patient
   */
  public Patient(Urgency urgency, Name name, Integer order) {
    this.urgency = urgency;
    this.name = name;
    this.order = order;
  }

  /**
   * Setter for property 'order'. O(1).
   *
   * @param order - the order of patient's arrival.
   */
  public void setOrder(Integer order) {
    this.order = order;
  }


  /**
   * Getter. O(1).
   *
   * @return value for order.
   */
  public Integer getOrder() {
    return order;
  }

  /**
   * Getter for property ’urgency’. O(1).
   *
   * @return Value for property ’urgency’.
   */
  public Urgency getUrgency() {
    return this.urgency;
  }


  /**
   * Compare urgency with another patient. O(1).
   *
   * @param other - another patient.
   * @return - 0, if urgency of both patients are the same. 1 if current patient is more urgent,
   *           -1 if current patient is less urgent.
   */
  @Override
  public int compareTo(Patient other) {
    return this.urgency.compareTo(other.urgency);
  }


  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    Patient patient = (Patient) obj;
    return Objects.equals(getUrgency(), patient.getUrgency())
        &&
        Objects.equals(name, patient.name)
        &&
        Objects.equals(getOrder(), patient.getOrder())
        &&
        Objects.equals(ZERO, patient.ZERO);
  }

  @Override
  public int hashCode() {

    return Objects.hash(getUrgency(), name, getOrder(), ZERO);
  }

  @Override
  public String toString() {
    return "Patient{"
        +
        "urgency="
        + urgency
        +
        ", name="
        + name
        +
        ", order="
        + order
        +
        '}';
  }
}
