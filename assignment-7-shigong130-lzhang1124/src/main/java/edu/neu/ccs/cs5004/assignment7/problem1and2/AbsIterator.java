package edu.neu.ccs.cs5004.assignment7.problem1and2;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * Represents the common properties of a iterator.
 */
public abstract class AbsIterator implements Iterator {
  protected List<TreeNode> list;
  protected int index;
  private static final Integer ONE = 1;
  private static final Integer ZERO = 0;

  AbsIterator() {
    list = new LinkedList<>();
    index = ZERO;
  }

  int getIndex() {
    return index;
  }

  @Override
  public boolean hasNext() {
    return list.size() - index != ZERO;
  }

  @Override
  public Ibst next() {
    return new Ibst(list.get(index++));
  }

  @Override
  public void remove() {
    list.remove(index - ONE);

  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    AbsIterator that = (AbsIterator) obj;
    return index == that.index
        && Objects.equals(list, that.list);
  }

  @Override
  public int hashCode() {

    return Objects.hash(list, index);
  }


}
