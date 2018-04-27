package edu.neu.ccs.cs5004.assignment8;


import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * Represents the common properties of a iterator.
 */
public class UserIterator implements Iterator {
  private List<Integer> allUsers;
  private int index;

  UserIterator(List<Integer> allusers, String processingFlag) {
    this.allUsers = allusers;
    processUsers(processingFlag);
    index = 0;
  }

  /**
   * This method is used to define three ways to process user.
   * Where s means process the user from beginning, e from the end, and r is in random order.
   *
   * @param processingFlag a character from s, e, r
   */
  private void processUsers(String processingFlag) {

    switch (processingFlag) {
      case "r":
        Collections.shuffle(allUsers);
        break;
      case "e":
        Collections.reverse(allUsers);
        break;
      default:
    }
  }



  @Override
  public boolean hasNext() {
    return allUsers.size() - index != 0;
  }

  @Override
  public Integer next() {
    return allUsers.get(index++);
  }

  @Override
  public void remove() {
    allUsers.remove(index - 1);
  }
}

