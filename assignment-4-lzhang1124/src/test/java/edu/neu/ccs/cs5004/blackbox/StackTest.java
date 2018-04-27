package edu.neu.ccs.cs5004.blackbox;

/*

public class StackTest {
  private Stack stack;
  private Stack sameRefstack;
  private Stack sameStatestack;

  @Before
  public void setUp() throws Exception {
    stack = Stack.createEmpty();
    sameRefstack = stack;
    sameStatestack = Stack.createEmpty();

  }

  @Test
  public void createEmpty() throws Exception {
    assertEquals(stack, Stack.createEmpty());

  }

  @Test
  public void push() throws Exception {
    assertEquals(7, stack.push(7).top());
    assertEquals(4, stack.push(4).top());
    assertEquals(5, stack.push(5).top());

  }

  @Test
  public void pop() throws Exception {
    assertEquals(4, stack.pop().top());

  }

  @Test
  public void top() throws Exception {
    assertEquals(4, stack.top());

  }

  @Test
  public void equalsTest() throws Exception {
    Stack nullstack = null;
    Stack diffstack = stack.push(6);
    Stack yetAnotherstack = Stack.createEmpty();

    assertTrue(stack.equals(stack));
    assertTrue(stack.equals(sameRefstack));
    assertTrue(stack.equals(sameStatestack));
    assertFalse(stack.equals(nullstack));

    assertEquals(stack.equals(sameStatestack), sameStatestack.equals(stack)); //Contract: symmetry
    assertEquals(stack.equals(sameStatestack) && sameStatestack.equals(yetAnotherstack), yetAnotherstack.equals(stack)); //transitivity
    assertFalse(stack.equals(diffstack)); //objects have different state

  }

}  */