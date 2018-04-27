package edu.neu.ccs.cs5004.assignment8.recommendation;

import edu.neu.ccs.cs5004.assignment8.TwitterGraph;

import java.util.List;

/**
 * Represents the recommendation criteria interface.
 */
public interface RecommendationCriteria {

  static RecommendationCriteria createFriendofFriendCriteria() {
    return new FriendOfFriend();
  }

  static RecommendationCriteria createInfluencerCriteria() {
    return new Influencer();
  }

  static RecommendationCriteria createRandomCriteria() {
    return new Random();
  }


  /**
   * Recommendation made based on different criteria.
   *
   * @param graph          - the graph we have created by using import.
   * @param useerId        - the specific useerId we are processing.
   * @param recommends     - the user's recommendation list.
   * @param numOfRecommend - how many users the program will recommend.
   */
  void recommendationBasedOnCriteria(TwitterGraph graph, Integer useerId, List<Integer> recommends,
                                     Integer numOfRecommend);
}
