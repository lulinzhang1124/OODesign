package edu.neu.ccs.cs5004.assignment10;

import java.util.Random;

/**
 * Represents a client's info.
 */
public class ClientInfo implements IClientInfo {

  private static final int DEPOSIT_LIMIT_UPPER_BOUND = 2000;
  private static final int WITHDRAWAL_LIMIT_UPPER_BOUND = 3000;

  private final int clientId;
  private final IKey publicKey;
  private final int depositLimit;
  private final int withdrawalLimit;
  private int numTransactions = 0;

  /**
   * Constructs a new ClientInfo with the client ID and the public key of a client.
   *
   * @param clientId  the client ID
   * @param publicKey the public key
   */
  public ClientInfo(int clientId, IKey publicKey) {
    if (publicKey == null) {
      throw new IllegalArgumentException("public key is null");
    }
    this.clientId = clientId;
    this.publicKey = publicKey;
    depositLimit = initDepositLimit();
    withdrawalLimit = initWithdrawalLimit();
  }

  private int initDepositLimit() {
    Random random = new Random();
    return random.nextInt(DEPOSIT_LIMIT_UPPER_BOUND + 1);
  }

  private int initWithdrawalLimit() {
    Random random = new Random();
    return random.nextInt(WITHDRAWAL_LIMIT_UPPER_BOUND + 1);
  }

  @Override
  public int getClientId() {
    return clientId;
  }


  @Override
  public IKey getPublicKey() {
    return publicKey;
  }


  @Override
  public int getDepositLimit() {
    return depositLimit;
  }


  @Override
  public int getWithdrawalLimit() {
    return withdrawalLimit;
  }


  @Override
  public void addTransaction() {
    numTransactions++;
  }


  @Override
  public int getNumTransactions() {
    return numTransactions;
  }

  @Override
  public int compareTo(IClientInfo that) {
    return that.getNumTransactions() - this.getNumTransactions();
  }

  @Override
  public String toString() {
    return "ClientInfo {clientId = " + clientId
        + ", numTransactions = " + numTransactions + " }";
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) {
      return true;
    }
    if (other == null || getClass() != other.getClass()) {
      return false;
    }

    ClientInfo that = (ClientInfo) other;

    if (clientId != that.clientId) {
      return false;
    }

    return publicKey.equals(that.publicKey);
  }

  @Override
  public int hashCode() {
    int result = clientId;
    result = 31 * result + publicKey.hashCode();
    return result;
  }
}