package edu.neu.ccs.cs5004.assignment10;

import java.math.BigInteger;

/**
 * Represents a request from client.
 */
public interface IRequest {
  /**
   * Returns the ID of client who sent this request.
   *
   * @return the ID of client who sent this request.
   */
  int getClientId();

  /**
   * Returns the message contained in this request.
   *
   * @return the message contained in this request.
   */
  BigInteger getMessage();

  /**
   * Returns the signature of this request.
   *
   * @return the signature of this request.
   */
  BigInteger getSignature();

}
