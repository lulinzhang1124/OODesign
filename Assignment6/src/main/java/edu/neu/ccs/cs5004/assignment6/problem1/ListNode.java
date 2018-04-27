package edu.neu.ccs.cs5004.assignment6.problem1;

import java.util.Objects;

/**
 * Represents a list node.
 *
 * @param <E> - generic type.
 */
public class ListNode<E> {
  private E val;
  protected ListNode next;

  /**
   * Creates a list node.
   *
   * @param val  - value of current node.
   * @param next - next list node.
   */
  public ListNode(E val, ListNode next) {
    this.val = val;
    this.next = next;
  }

  /**
   * Creates a list node.
   *
   * @param val - value of current node.
   */
  public ListNode(E val) {
    this(val, null);
  }

  /**
   * Getter. O(1).
   *
   * @return value of current node value.
   */
  public E getVal() {
    return val;
  }

  /**
   * Getter. O(1).
   *
   * @return value for property 'next'.
   */
  public ListNode getNext() {
    return next;
  }


  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    ListNode<?> listNode = (ListNode<?>) obj;
    return Objects.equals(val, listNode.val)
        && Objects.equals(next, listNode.next);
  }

  @Override
  public int hashCode() {

    return Objects.hash(val, next);
  }

  @Override
  public String toString() {
    return "ListNode{" + "val=" + val
        + ", next=" + next + '}';
  }
}
