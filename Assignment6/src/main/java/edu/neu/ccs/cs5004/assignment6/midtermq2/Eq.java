package edu.neu.ccs.cs5004.assignment6.midtermq2;

import edu.neu.ccs.cs5004.assignment6.problem2.Pq;
import edu.neu.ccs.cs5004.assignment6.problem2.PriorityQueue;

import java.util.Objects;

/**
 * Represents an emergency queue class.
 */
public class Eq implements EmergencyQueue {
  PriorityQueue<Patient> queue;


  public Eq() {
    this.queue = PriorityQueue.createEmptyPriorityQueue();

  }

  public PriorityQueue<Patient> getQueue() {
    return queue;
  }

  /**
   * Gets the next patient based on the arrival order. It is an observer. O(n^3).
   *
   * @return the next patient.
   */
  @Override
  public Patient nextPatient() {
    if (size() == 0) {
      throw new IllegalArgumentException("Call nextPatient on empty queue.");
    }

    PriorityQueue<Patient> priorityQueue = new Pq<>();
    priorityQueue.insert(queue.front());
    Patient res = queue.front();
    while (queue.size() > 1) {
      queue.remove();
      if (queue.front().getOrder() < res.getOrder()) {
        res = queue.front();
      }
      priorityQueue.insert(queue.front());
    }
    queue = priorityQueue;
    return res;
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
  }

  /**
   * Adds a new patient into the emergency queue with {@code priority} and {@code value}. O(n^2).
   *
   * @param patient to add to the queue.
   */
  @Override
  public void add(Patient patient) {
    queue.insert(patient);
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
   * Removes the element with the highest emergency from the queue. O(1).
   */
  @Override
  public void removeMostUrgent() {
    if (isEmpty()) {
      throw new IllegalArgumentException("Call removeMostUrgent on empty queue.");
    }

    queue.remove();
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
    Eq eq = (Eq) obj;
    return Objects.equals(queue, eq.queue);
  }

  @Override
  public int hashCode() {

    return Objects.hash(queue);
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
