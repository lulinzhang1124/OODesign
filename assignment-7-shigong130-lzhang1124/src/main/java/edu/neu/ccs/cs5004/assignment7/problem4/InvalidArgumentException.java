package edu.neu.ccs.cs5004.assignment7.problem4;

/**
 * Represents an invalid argument exception class.
 */
public class InvalidArgumentException extends RuntimeException{

  /**
   * Creates an exception.
   *
   * @param msg - error message.
   */
  public InvalidArgumentException(String msg) {
   super(msg);
  }
}
