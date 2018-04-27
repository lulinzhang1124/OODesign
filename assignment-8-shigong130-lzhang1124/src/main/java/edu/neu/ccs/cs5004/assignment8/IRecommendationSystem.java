package edu.neu.ccs.cs5004.assignment8;


/**
 * Represents a read console interface.
 */
public interface IRecommendationSystem {

  /**
   * Start recommendation based on given parameters.
   *
   * @param graph                   the graph we have created by using import
   * @param processingFlag          the flag we want to user (s/e/random)
   * @param numberOfUsersToProcess  how many users the program need to process
   * @param numberOfRecommendations how many users the program will recommend
   */
  void recommendation(TwitterGraph graph, String processingFlag, Integer numberOfUsersToProcess,
                      Integer numberOfRecommendations);


  /**
   * Write the results in an output file.
   *
   * @param filepath the file path passed from RecommendLauncher class
   */
  void writeResult(String filepath);


}
