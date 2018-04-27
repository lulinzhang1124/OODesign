package edu.neu.ccs.cs5004.assignment4.problem1;

/**
 * This interface captures Stack ADT.
 */
public interface Stack {

  static Stack createEmpty() {
    return new MyStack();
  }

  ;

  Stack push(int num);

  Stack pop();

  int top();

}
