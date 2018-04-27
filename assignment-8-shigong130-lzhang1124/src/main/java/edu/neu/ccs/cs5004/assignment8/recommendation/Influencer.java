package edu.neu.ccs.cs5004.assignment8.recommendation;

import edu.neu.ccs.cs5004.assignment8.Number;
import edu.neu.ccs.cs5004.assignment8.TwitterGraph;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;


/**
 * Represents influencer criteria class.
 */
public class Influencer implements RecommendationCriteria {

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

    influencer(graph, useerId, recommends, numOfRecommend);
  }

  /**
   * Recommend by using influencer method
   *
   * @param graph          - the graph we have created by using import.
   * @param useerId        - the specific useerId we are processing.
   * @param recommends     - the user's recommendation list.
   * @param numOfRecommend - how many users the program will recommend.
   */
  private void influencer(TwitterGraph graph, Integer useerId, List<Integer> recommends,
                          Integer numOfRecommend) {
    if (recommends.size() >= numOfRecommend) {
      return;
    }
    int count = numOfRecommend - recommends.size();

    int criterionOfInfluencer = Number.INFLUENCER_SMALL.getValue();
    if (graph.totalNumberOfUsers() > Number.SMALL_NODE_SIZE.getValue()) {
      criterionOfInfluencer = Number.INFLUENCER_10000.getValue();
    }

    Set<Integer> follows = graph.getFollows(useerId);
    List<Integer> influencers = graph.getInfluencers(criterionOfInfluencer);
    List<Integer> temp = new LinkedList<>();
    for (Integer id : influencers) {
      if (!follows.contains(id) && !id.equals(useerId)) {
        temp.add(id);
      }
    }


    if (temp.size() > count) {
      Collections.sort(influencers);
    }

    for (int i = 0; i < temp.size() && i < count; i++) {
      if (!recommends.contains(temp.get(i))) {
        recommends.add(temp.get(i));
      }
    }
  }


}
