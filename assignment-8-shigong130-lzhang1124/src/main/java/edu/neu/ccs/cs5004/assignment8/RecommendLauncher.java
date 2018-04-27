package edu.neu.ccs.cs5004.assignment8;

/**
 * Represents a recommendation system that user can use it to run.
 */
public class RecommendLauncher {

  //node file
  private static String file1;
  //edge file
  private static String file2;
  //output file
  private static String file3;

  //three additional parameters
  private static String processingFlag = "s";
  //an integer in the set [1, totalNumberOfUsers], The default value is 50.
  private static Integer numberOfUsersToProcess = Number.FIFTY.getValue();
  //an integer in the set [1, 100], The default value is 15.
  private static Integer numberOfRecommendations = Number.FIFTEEN.getValue();

  private static TwitterGraph graph = new Graph();

  /**
   * Main function.
   *
   * @param args arguments read from the commandline input
   */
  public static void main(String[] args) {
    graph = new Graph();

    if (!parseArgsAndInit(args)) {
      return;
    }

    RecommendationSystem recommendationSystem = new RecommendationSystem();
    recommendationSystem.recommendation(graph, processingFlag, numberOfUsersToProcess,
        numberOfRecommendations);
    recommendationSystem.writeResult(file3);
  }

  /**
   * Validate the commandline input.
   *
   * <p>Format: file1.csv file2.csv file3.csv [processingFlag]
   * [numberOfUsersToProcess] [numberOfRecommendations]
   *
   * <p>For processingFlag, s means process the user from beginning,
   * e from the end, and r is in random order.
   *
   * <p>For numberOfUsersToProcess, which is an integer in the set [1, TOTAL NUMBER OF USERS]
   * For numberOfRecommendations, which is an integer in the set [1, 100].
   *
   * @param args arguments read from the commandline input
   * @return whether the arguments is valid
   */
  public static boolean parseArgsAndInit(String[] args) {
    if (args.length < Number.THREE.getValue()) {
      System.out.println("Invalid arguments! \n"
          + "Usage: file1.csv file2.csv file3.csv [processingFlag]"
          + " [numberOfUsersToProcess] [numberOfRecommendations]");
      return false;
    }

    file1 = args[0];
    file2 = args[1];
    file3 = args[2];

    graph.buildGraph(file1, file2);

    if (args.length >= Number.FOUR.getValue()) {
      processingFlag = args[3];
      if (!(processingFlag.equals("s") || processingFlag.equals("e")
          || processingFlag.equals("r"))) {
        System.out.println("processingFlag format wrong.");
        return false;
      }
    }

    if (args.length >= Number.FIVE.getValue()) {
      try {
        numberOfUsersToProcess = Integer.valueOf(args[4]);
        if (!(numberOfUsersToProcess >= 1
            && numberOfUsersToProcess <= graph.totalNumberOfUsers())) {
          System.out.println("numberOfUsersToProcess is not in bound!.");
          return false;
        }
      } catch (Exception e) {
        System.out.println("numberOfUsersToProcess format wrong.");
        return false;
      }
    }

    if (args.length == Number.SIX.getValue()) {
      try {
        numberOfRecommendations = Integer.valueOf(args[5]);
        if (!(numberOfRecommendations >= Number.ONE.getValue()
            && numberOfRecommendations <= Number.ONE_HUNDRED.getValue())) {
          System.out.println("numberOfRecommendations is not in bound!.");
          return false;
        }
      } catch (Exception e) {
        System.out.println("numberOfRecommendations format wrong.");
        return false;
      }
    }

    if (args.length > Number.SIX.getValue()) {
      System.out.println("The number of arguments should be 6, you exceed the limit!");
      return false;
    }
    return true;
  }


}
