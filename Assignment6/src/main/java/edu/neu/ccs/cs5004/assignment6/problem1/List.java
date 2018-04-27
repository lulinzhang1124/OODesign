package edu.neu.ccs.cs5004.assignment6.problem1;

/**
 * Represents a list.
 *
 * @param <E> - generic type.
 */
public interface List<E> {

  /**
   * Create an empty list.
   *
   * @return empty list.
   */
  static List creatlEmptyList() {
    return new LinkedList<>();
  }

  /**
   * adds an element to the front of the list.
   *
   * @param element - an element to be added.
   */
  void add(E element);


  /**
   * adds an element at the specified index.
   *
   * @param index   - an index.
   * @param element - an element to be added.
   */
  void add(int index, E element);

  /**
   * gets an element located at the specified index (the list remains unaltered).
   *
   * @param index - an index.
   * @return the element at the index given.
   */
  E get(int index);


  /**
   * retrieves the element in the list and returns the respective index in the list
   *
   * @param element - an element.
   * @return the index of the given element.
   */
  int indexOf(E element);

  /**
   * returns true if the list is empty and false otherwise
   *
   * @return true if list is empty, false otherwise.
   */
  boolean isEmpty();

  /**
   * removes the element located at the specified index from the list
   *
   * @param index - the index of element to be removed.
   */
  void remove(int index);

  /**
   * returns the size of the list.
   *
   * @return the size of the list.
   */
  int size();

  /**
   * returns true if the list contains the specified element, false otherwise.
   *
   * @param element - an element.
   * @return true if list contains the element, false otherwise.
   */
  boolean contains(E element);

}
