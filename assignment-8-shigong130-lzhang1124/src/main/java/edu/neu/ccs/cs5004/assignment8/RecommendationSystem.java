package edu.neu.ccs.cs5004.assignment8;

import edu.neu.ccs.cs5004.assignment8.recommendation.RecommendationCriteria;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.LinkedList;
import java.util.List;


/**
 * Recommend a console class.
 */
public class RecommendationSystem implements IRecommendationSystem {
  private List<Integer> users;
  private List<LinkedList<Integer>> result;

  /**
   * Start to make recommendation.
   *
   * @param graph                  the graph we have created by using import
   * @param processingFlag         the flag we want to user (s/e/random)
   * @param numberOfUsersToProcess how many users the program need to process
   * @param numOfRecommend         how many users the program will recommend
   */
  @Override
  public void recommendation(TwitterGraph graph, String processingFlag,
                             Integer numberOfUsersToProcess, Integer numOfRecommend) {

    users = graph.processUsers(processingFlag, numberOfUsersToProcess);
    result = new LinkedList<>();
    for (Integer user : users) {
      LinkedList<Integer> resultPerUser = makeRecommendation(graph, user, numOfRecommend);
      result.add(resultPerUser);
    }
  }

  /**
   * Creating different kinds of recommendation.
   *
   * @return the list of user we are going to recommend.
   */
  private LinkedList<Integer> makeRecommendation(TwitterGraph graph, Integer useerId, Integer
      numOfRecommend) {
    LinkedList<Integer> recommends = new LinkedList<>();


    RecommendationCriteria.createFriendofFriendCriteria().recommendationBasedOnCriteria(graph,
        useerId, recommends, numOfRecommend);
    RecommendationCriteria.createInfluencerCriteria().recommendationBasedOnCriteria(graph,
        useerId, recommends, numOfRecommend);
    RecommendationCriteria.createRandomCriteria().recommendationBasedOnCriteria(graph,
        useerId, recommends, numOfRecommend);

    return recommends;
  }


  /**
   * Write the result to the csv file.
   *
   * @param filepath the file path passed from RecommendLauncher class
   */
  @Override
  public void writeResult(String filepath) {
    File file = new File(filepath);

    File parent = file.getParentFile();

    if (parent != null && parent.mkdirs()) {

      System.out.println("Create directory " + parent.getAbsolutePath());
    }

    try {

      file.createNewFile();

    } catch (IOException e1) {

      e1.printStackTrace();

    }
    try {
      Writer writer = new OutputStreamWriter(new FileOutputStream(filepath), "UTF-8");
      writer.write("User ID,Recommended nodes\n");
      for (int i = 0; i < users.size(); i++) {
        writer.write(users.get(i) + ",");

        LinkedList<Integer> linkedList = result.get(i);
        for (Integer n : linkedList) {
          writer.write(n + " ");
        }
        writer.write("\n");
      }
      writer.close();
    } catch (IOException e) {
      System.out.println("Error on write file " + filepath);
    }
  }


}
