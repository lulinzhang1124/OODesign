package edu.neu.ccs.cs5004.assignment6.midtermq2;

/**
 * Represents a class to use nanoTime testing methods.
 */
public class NanoTest {
  private static final int ZERO = 0;
  private static final int FIFTY = 50;
  private static final int ONE_HUNDRED = 100;
  private static final int ONE = 1;

  /**
   * Test runtime for removeNext() method. O(n^3).
   *
   * @param emergencyQ - an emergency queue.
   */
  public static long removeNextNanoTest(EmergencyQueue emergencyQ) {
    long startTime = System.nanoTime();
    emergencyQ.removeNext();
    long endTime = System.nanoTime();
    long output = endTime - startTime;
    return output;
  }


  /**
   * Test runtime for removeMostUrgent() method. O(1).
   *
   * @param emergencyQ - an emergency queue.
   */
  public static long removeMostUrgentNanoTest(EmergencyQueue emergencyQ) {
    long startTime = System.nanoTime();
    emergencyQ.removeMostUrgent();
    long endTime = System.nanoTime();
    long output = endTime - startTime;
    return output;
  }

  /**
   * Creates queues and test for their runtime. O(n^3).
   * it's obvious that removeMostUrgent() ( O(1)) is much faster than removeNext() ( O(n^3))
   */
  public static void createTestQueues() {

    for (int i = ONE; i <= FIFTY; i++) {
      long removeNextResult = ZERO;
      long removeMostUrgentResult = ZERO;

      for (int j = ONE; j <= ONE_HUNDRED; j++) {

        EmergencyQueue queue1 = EmergencyQueue.createEmpty();
        EmergencyQueue queue2 = EmergencyQueue.createEmpty();
        NanoTest.addPatients(queue1, i);
        NanoTest.addPatients(queue2, i);

        removeNextResult += NanoTest.removeNextNanoTest(queue1);
        removeMostUrgentResult += NanoTest.removeMostUrgentNanoTest(queue2);
      }


      System.out.println("NumOfPatientInQueue = " + i
          + ", removeNextResult duration = " + removeNextResult / ONE_HUNDRED);
      System.out.println("NumOfPatientInQueue = " + i
          + ",removeMostUrgentResult duration = " + removeMostUrgentResult / ONE_HUNDRED);
    }

  }

  /**
   * Adds patients to a queue. O(n^2).
   *
   * @param queue - current queue.
   * @param num   - number of patients to be added.
   */
  public static void addPatients(EmergencyQueue queue, int num) {
    for (int i = ONE; i <= num; i++) {
      Patient patient = new Patient(new Urgency(num), new Name("test", "test"), 2);
      queue.add(patient);
    }
  }

  /**
   * Main function to do the test. O(n^3).
   *
   * @param args - arguments to the method.
   */
  public static void main(String[] args) {
    NanoTest.createTestQueues();
  }

}
