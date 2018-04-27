package edu.neu.ccs.cs5004.assignment8.recommendation;

import edu.neu.ccs.cs5004.assignment8.TwitterGraph;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;


/**
 * Represents random criteria class.
 */
public class Random implements RecommendationCriteria {

  /**
   * Recommendation made based on current criteria.
   *
   * @param graph          - the graph we have created by using import.
   * @param useerId        - the specific useerId we are processing.
   * @param recommends     - the user's recommendation list.
   * @param numOfRecommend - how many users the program will recommend.
   */
  @Override
  public void recommendationBasedOnCriteria(
      TwitterGraph graph, Integer useerId, List<Integer> recommends, Integer numOfRecommend) {
    random(graph, useerId, recommends, numOfRecommend);
  }

  /**
   * Recommend by using random method.
   *
   * @param graph          the graph we have created by using import
   * @param useerId        the specific user ID we are processing
   * @param recommends     the user's recommendation list
   * @param numOfRecommend how many users the program will recommend
   */
  private void random(TwitterGraph graph, Integer useerId, List<Integer> recommends,
                      Integer numOfRecommend) {

    if (recommends.size() == numOfRecommend) {
      return;
    }


    List<Integer> allUser = graph.allUsers();
    Set<Integer> follows = graph.getFollows(useerId);

    Collections.shuffle(allUser);

    Iterator<Integer> irt = allUser.iterator();
    Integer next;

    while (recommends.size() < numOfRecommend) {


      if (irt.hasNext()) {
        next = irt.next();
        if ((!recommends.contains(next)) && (!follows.contains(next)) && (!next.equals(useerId))) {
          recommends.add(next);
        }

      } else {
        break;
      }

    }
  }


}
