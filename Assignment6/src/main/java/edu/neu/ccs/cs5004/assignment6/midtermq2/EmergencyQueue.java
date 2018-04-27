package edu.neu.ccs.cs5004.assignment6.midtermq2;

/**
 * Represents an emergency queue interface.
 */
public interface EmergencyQueue {

  /**
   * Creates an empty priority queue. It is a creator.
   *
   * @return empty priority queue.
   */
  static EmergencyQueue createEmpty() {
    return new Eq();
  }


  /**
   * Gets the next patient based on the arrival order. It is an observer.
   *
   * @return the next patient.
   */
  Patient nextPatient();

  /**
   * Removes the next patient based on the arrival order. It is a mutator.
   */
  void removeNext();

  /**
   * Adds a patient to the queue, based on his emergency. It is a mutator.
   *
   * @param patient - a patient.
   */
  void add(Patient patient);


  /**
   * Get the patient with the highest urgency in the queue.
   *
   * @return the patient with the highest urgency in the queue. It is an observer.
   */
  Patient nextMostUrgent();


  /**
   * Removes the most urgent patient from the queue. It is a mutator.
   */
  void removeMostUrgent();


  /**
   * Checks if the queue is empty. It is an observer.
   *
   * @return true if the queue is empty, false otherwise.
   */
  Boolean isEmpty();

  /**
   * Gets the number of patients in the queue. It is an observer.
   *
   * @return the number of patients in the queue.
   */
  Integer size();

}

