package edu.neu.ccs.cs5004.assignment10;

import java.math.BigInteger;

/**
 * Represents a key.
 */
public interface IKey {

  /**
   * Encrypts / decrypts a message using this key.
   *
   * @param message the message to be encrypted/decrypted
   * @return a message translated from the given message
   */
  BigInteger encryptOrDecrypt(BigInteger message);
}
