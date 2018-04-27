package edu.neu.ccs.cs5004.assignment6.midtermq2.bonus;

import edu.neu.ccs.cs5004.assignment6.midtermq2.EmergencyQueue;
import edu.neu.ccs.cs5004.assignment6.midtermq2.Patient;
import edu.neu.ccs.cs5004.assignment6.problem2.Pq;
import edu.neu.ccs.cs5004.assignment6.problem2.PriorityQueue;


import java.util.Objects;

/**
 * Bonus question. Implement all previous requirements together with Q6, Q7.
 */
public class UrgentCareOrderQueue implements EmergencyQueue {
  PriorityQueue<Patient> queue;
  PriorityQueue<PatientWrapper> orderQueue;

  /**
   * Creates the urgent care order queue.
   */
  public UrgentCareOrderQueue() {
    this.queue = PriorityQueue.createEmptyPriorityQueue();
    this.orderQueue = PriorityQueue.createEmptyPriorityQueue();
  }

  /**
   * Getter. O(1).
   *
   * @return the value for property 'queue'.
   */
  public PriorityQueue<Patient> getQueue() {
    return queue;
  }

  /**
   * Gets the next patient based on the arrival order. It is an observer. O(1).
   *
   * @return the next patient.
   */
  @Override
  public Patient nextPatient() {
    if (size() == 0) {
      throw new NullPointerException("Call nextPatient on empty queue.");
    }

    return this.orderQueue.front().getPatient();
  }

  /**
   * Removes the next patient based on the arrival order. It is a mutator. O(n^3).
   */
  @Override
  public void removeNext() {
    if (size() == 0) {
      throw new IllegalArgumentException("Call removeNext on empty queue.");
    }


    PriorityQueue<Patient> newQueue = new Pq<>();
    while (queue.size() != 0) {
      if (!queue.front().equals(nextPatient())) {
        newQueue.insert(queue.front());
      }
      queue.remove();
    }
    queue = newQueue;

    this.orderQueue.remove();
  }

  /**
   * Adds a new patient into the emergency queue with {@code priority} and {@code value}. O(n^2).
   *
   * @param patient to add to the queue
   */
  @Override
  public void add(Patient patient) {
    queue.insert(patient);
    this.orderQueue.insert(new PatientWrapper(patient));
  }


  /**
   * Return the value of the the element with the highest priority. O(1).
   *
   * @return the value of the element with the highest priority.
   */
  @Override
  public Patient nextMostUrgent() {
    if (isEmpty()) {
      throw new IllegalArgumentException("Call nextMostUrgent on empty queue.");
    }
    return queue.front();
  }

  /**
   * Removes the element with the highest emergency from the queue. O(n^3).
   */
  @Override
  public void removeMostUrgent() {
    if (isEmpty()) {
      throw new IllegalArgumentException("Call removeMostUrgent on empty queue.");
    }

    Patient mostUrgentPatient = queue.front();
    queue.remove();


    PriorityQueue<PatientWrapper> newOrderQueue = new Pq<>();
    while (this.orderQueue.size() != 0) {
      if (!this.orderQueue.front().getPatient().equals(mostUrgentPatient)) {
        newOrderQueue.insert(this.orderQueue.front());
      }
      this.orderQueue.remove();
    }
    this.orderQueue = newOrderQueue;
  }

  /**
   * Check if the queue is empty. O(1).
   *
   * @return true if empty, false otherwise
   */
  @Override
  public Boolean isEmpty() {
    return queue.isEmpty();
  }

  /**
   * Gets the number of patients in the queue. It is an observer. O(n).
   *
   * @return the number of patients in the queue.
   */
  @Override
  public Integer size() {
    return queue.size();
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    UrgentCareOrderQueue that = (UrgentCareOrderQueue) obj;
    return Objects.equals(getQueue(), that.getQueue())
        &&
        Objects.equals(orderQueue, that.orderQueue);
  }

  @Override
  public int hashCode() {

    return Objects.hash(getQueue(), orderQueue);
  }

  @Override
  public String toString() {
    return "Eq{"
        +
        "queue="
        + queue
        +
        '}';
  }
}
