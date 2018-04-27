package edu.neu.ccs.cs5004.blackbox;

/*



public class QueueTest {
  private Queue queue;
  private Queue sameRefQueue;
  private Queue sameStateQueue;

  @Before
  public void setUp() throws Exception {
    queue = Queue.createEmpty();
    sameRefQueue = queue;
    sameStateQueue = Queue.createEmpty();

  }

  @Test
  public void createEmpty() {
    assertEquals(queue, Queue.createEmpty());
  }

  @Test
  public void enqueue() {
    assertEquals(7, queue.enqueue(7).front());
    assertEquals(7, queue.enqueue(4).front());
    assertEquals(7, queue.enqueue(5).front());

  }

  @Test
  public void dequeue() {
    assertEquals(4, queue.dequeue().front());
  }

  @Test
  public void front() {
    assertEquals(5, queue.dequeue().front());
  }


  @Test
  public void equalsTest() throws Exception {
    Queue nullQueue = null;
    Queue diffQueue = queue.enqueue(6);
    Queue yetAnotherQueue = Queue.createEmpty();

    assertTrue(queue.equals(queue));
    assertTrue(queue.equals(sameRefQueue));
    assertTrue(queue.equals(sameStateQueue));
    assertFalse(queue.equals(nullQueue));

    assertEquals(queue.equals(sameStateQueue), sameStateQueue.equals(queue)); //Contract: symmetry
    assertEquals(queue.equals(sameStateQueue) && sameStateQueue.equals(yetAnotherQueue),
        yetAnotherQueue.equals(queue)); //transitivity
    assertFalse(queue.equals(diffQueue)); //objects have different state

  }
} */
