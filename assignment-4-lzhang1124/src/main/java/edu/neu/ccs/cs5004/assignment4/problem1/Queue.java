package edu.neu.ccs.cs5004.assignment4.problem1;

/**
 * Created by zontakm on 9/12/2017.
 * This interface captures Queue ADT
 */
public interface Queue {
  static Queue createEmpty() {
    return new MyQueue();
  }

  Queue enqueue(int elt);

  Queue dequeue();

  int front();
}
