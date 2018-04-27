package edu.neu.ccs.cs5004.assignment10;

import java.io.IOException;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;


/**
 * Represent a secure bank verification simulator.
 */
public class SecureBankVerificationSimulator implements ISecureBankVerificationSimulator {
  private static final int MESSAGE_UPPER_BOUND = 30000;
  private static final int MESSAGE_LOWER_BOUND = 10;
  private static final int BIT_LENGTH = 32;

  private final String outputDir;
  private final IBank bank = new Bank();
  private final Map<Integer, IClient> clientsMap = new HashMap<>();
  private final List<IRequest> requests = new ArrayList<>();
  private final List<IResult> results = new ArrayList<>();

  /**
   * Constructs a SecureBankVerificationSimulator with the required user inputs.
   *
   * @param numClients       the number of unique clients
   * @param numVerifications the number of verifications
   * @param fraction         the fraction of invalid messages
   * @param outputDir        the output file name
   */
  public SecureBankVerificationSimulator(int numClients, int numVerifications,
                                         double fraction, String outputDir) {
    this.outputDir = outputDir;

    initClients(numClients);
    initRequests(numVerifications, fraction);
  }

  /**
   * Accepts the user input through command-line arguments. Validates and parses the arguments
   * using a cmdArgument, then passes the arguments to the simulator.
   *
   * @param args the command-line arguments
   * @throws IOException if there exists an I/O failure
   */
  public static void main(String[] args) throws IOException {
    ICmdArgument cmdArgument = new CmdArgument(args);
    if (!cmdArgument.isValid()) {
      throw new IllegalArgumentException(cmdArgument.getErrorMessage());
    }
    ISecureBankVerificationSimulator simulator =
        new SecureBankVerificationSimulator(cmdArgument.getNumClients(),
            cmdArgument.getNumVerifications(),
            cmdArgument.getFraction(),
            cmdArgument.getOutputDir());
    simulator.processVerifications();
    simulator.outputResults();
  }

  private void initClients(int numClients) {
    Random random = new Random();
    for (int i = 0; i < numClients; i++) {
      int clientId = random.nextInt(Integer.MAX_VALUE);
      while (clientsMap.containsKey(clientId)) {
        clientId++;
      }
      IClient newClient = new Client(clientId);
      clientsMap.put(clientId, newClient);
      bank.addClient(clientId, newClient.getPublicKey());
    }
  }

  private void initRequests(int numVerifications, double fraction) {
    Integer[] idArr = new Integer[clientsMap.size()];
    idArr = clientsMap.keySet().toArray(idArr);

    Random random = new Random();
    for (int i = 0; i < numVerifications; i++) {
      int clientId = idArr[random.nextInt(idArr.length)];
      IClient client = clientsMap.get(clientId);

      int msgInt = random.nextInt(MESSAGE_UPPER_BOUND + 1);
      while (msgInt <= MESSAGE_LOWER_BOUND) {
        msgInt++;
      }
      BigInteger message = new BigInteger(msgInt + "");
      BigInteger signature = createSignature(message, client, fraction);

      requests.add(new Request(clientId, message, signature));
    }
  }

  // creates a signature for the request. If the request is deemed invalid, the signature is
  // just some randomly generated integer. If the request is deemed valid, the signature is
  // generated using the RSA algorithm.
  private BigInteger createSignature(BigInteger message, IClient client, double fraction) {
    Random random = new Random();
    if (random.nextDouble() >= fraction) {
      return client.provideSignature(message);
    } else {
      return new BigInteger(BIT_LENGTH, new SecureRandom());
    }
  }

  /**
   * Processes the verifications by sending client requests to the bank and gathers
   * the transaction information.
   */
  @Override
  public void processVerifications() {
    int transactionNum = 0;
    for (IRequest request : requests) {
      boolean isVerified = bank.receiveRequest(request);
      String status = bank.getRequestStatus(request);
      IResult result = new Result(++transactionNum,
          LocalDateTime.now(),
          request,
          isVerified,
          status);
      results.add(result);
    }
  }

  @Override
  public void outputResults() throws IOException {
    IPrinter printer = new edu.neu.ccs.cs5004.assignment10.Printer();
    printer.printPublicKeyUsage(bank.getPublicKeyUsage());
    printer.printTopTenClients(bank.getClientsSentRequest());
    printer.printIDsDepositRejected(bank.getIdDepositRejected());
    printer.printIDsWithdrawalRejected(bank.getIdWithdrawalRejected());

    ICsvFileGenerator csvFileGenerator = new CsvFileGenerator();
    csvFileGenerator.generateCsvFile(results, outputDir);
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) {
      return true;
    }
    if (other == null || getClass() != other.getClass()) {
      return false;
    }

    SecureBankVerificationSimulator that = (SecureBankVerificationSimulator) other;

    if (outputDir != null ? !outputDir.equals(that.outputDir) : that.outputDir != null) {
      return false;
    }
    return clientsMap.equals(that.clientsMap) && requests.equals(that.requests);
  }

  @Override
  public int hashCode() {
    int result = outputDir != null ? outputDir.hashCode() : 0;
    result = 31 * result + clientsMap.hashCode();
    result = 31 * result + requests.hashCode();
    return result;
  }
}
