package edu.neu.ccs.cs5004.assignment6.problem1;


import java.util.Objects;

/**
 * Represents a linked list class.
 *
 * @param <E> - generic type.
 */
public class LinkedList<E> implements List<E> {

  private ListNode<E> head;

  public LinkedList() {
    head = null;
  }

  /**
   * adds an element to the front of the list. O(1).
   *
   * @param element - an element to be added.
   */
  @Override
  public void add(E element) {
    ListNode<E> newhead = new ListNode<>(element);
    newhead.next = head;
    head = newhead;
  }


  /**
   * adds an element at the specified index. O(n).
   *
   * @param index   - an index.
   * @param element - an element to be added.
   */
  @Override
  public void add(int index, E element) {

    if (index < 0 || index > this.size()) {
      throw new IndexOutOfBoundsException("index: " + index + "is invalid.");
    }

    if (index == 0) {
      this.add(element);
      return;
    }

    ListNode<E> cur = head;
    ListNode<E> pre = head;
    ListNode<E> ele = new ListNode<>(element);

    for (int i = 0; i < index; i++) {
      pre = cur;
      cur = cur.next;
    }

    pre.next = ele;
    ele.next = cur;

  }

  /**
   * gets an element located at the specified index (the list remains unaltered). O(n).
   *
   * @param index - an index.
   * @return the element at the index given.
   */
  @Override
  public E get(int index) {

    if (index < 0 || index > this.size()) {
      throw new IndexOutOfBoundsException("index:" + index + "is invalid.");
    }

    ListNode<E> cur = head;

    for (int i = 0; i < index; i++) {
      cur = cur.next;
    }

    return cur.getVal();
  }


  /**
   * retrieves the element in the list and returns the respective index in the list. O(n).
   *
   * @param element - an element.
   * @return the index of the given element.
   */
  @Override
  public int indexOf(E element) {

    for (int i = 0; i < this.size(); i++) {
      if (this.get(i).equals(element)) {
        return i;
      }
    }

    return -1;
  }

  /**
   * returns true if the list is empty and false otherwise. O(1).
   *
   * @return true if list is empty, false otherwise.
   */
  @Override
  public boolean isEmpty() {
    return head == null;
  }

  /**
   * removes the element located at the specified index from the list. O(n).
   *
   * @param index - the index of element to be removed.
   */
  @Override
  public void remove(int index) {
    if (index < 0 || index >= this.size()) {
      throw new IndexOutOfBoundsException("index:" + index + "is invalid.");
    }

    if (index == 0) {
      head = head.next;
      return;
    }

    ListNode<E> cur = head;
    ListNode<E> pre = head;

    for (int i = 0; i < index; i++) {
      pre = cur;
      cur = cur.next;
    }
    pre.next = cur.next;

  }

  /**
   * returns the size of the list. O(n).
   *
   * @return the size of the list.
   */
  @Override
  public int size() {
    int size = 0;
    ListNode<E> cur = head;
    while (cur != null) {
      size++;
      cur = cur.next;
    }
    return size;
  }

  /**
   * returns true if the list contains the specified element, false otherwise. 0(n).
   *
   * @param element - an element.
   * @return true if list contains the element, false otherwise.
   */
  @Override
  public boolean contains(E element) {
    return indexOf(element) != -1;
  }


  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    LinkedList<?> that = (LinkedList<?>) obj;
    return Objects.equals(head, that.head);
  }

  @Override
  public int hashCode() {

    return Objects.hash(head);
  }

  @Override
  public String toString() {
    return "LinkedList{" + "head=" + head + '}';
  }
}
