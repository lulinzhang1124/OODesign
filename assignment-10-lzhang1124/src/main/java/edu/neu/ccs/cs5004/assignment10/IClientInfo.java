package edu.neu.ccs.cs5004.assignment10;

/**
 * Represents the interface of a client's info.
 */
public interface IClientInfo extends Comparable<IClientInfo> {

  /**
   * Returns the client ID.
   *
   * @return the client ID.
   */
  int getClientId();

  /**
   * Returns the deposit limit.
   *
   * @return the deposit limit.
   */
  int getDepositLimit();

  /**
   * Returns the withdrawal limit.
   *
   * @return the withdrawal limit.
   */
  int getWithdrawalLimit();

  /**
   * Returns the public key.
   *
   * @return the public key.
   */
  IKey getPublicKey();

  /**
   * Increments the number of transactions in this client info by 1.
   */
  void addTransaction();

  /**
   * Returns the number of transactions requested.
   *
   * @return the number of transactions requested.
   */
  int getNumTransactions();

}
