package edu.neu.ccs.cs5004.assignment10;

/**
 * Represent a rsa key.
 */
public interface IRsaKey {
  /**
   * Returns the private key.
   *
   * @return the private key.
   */
  IKey getPrivateKey();

  /**
   * Returns the public key.
   *
   * @return the public key.
   */
  IKey getPublicKey();

}
