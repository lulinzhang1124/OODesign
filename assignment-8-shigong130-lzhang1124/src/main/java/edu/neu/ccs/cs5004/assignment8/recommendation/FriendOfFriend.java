package edu.neu.ccs.cs5004.assignment8.recommendation;

import edu.neu.ccs.cs5004.assignment8.TwitterGraph;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Represents friend of friend criteria.
 */
public class FriendOfFriend implements RecommendationCriteria {


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

    friendOfFriend(graph, useerId, recommends, numOfRecommend);
  }


  /**
   * Recommend by using FriendOfFriend.
   *
   * @param graph          - the graph we have created by using import.
   * @param useerId        - the id of the user that program will recommend for.
   * @param recommends     - the user's recommendation list.
   * @param numOfRecommend - how many users the program will recommend.
   */
  private void friendOfFriend(TwitterGraph graph, Integer useerId, List<Integer> recommends,

                              Integer numOfRecommend) {
    //check if has enough recommendations
    if (recommends.size() >= numOfRecommend) {
      return;
    }
    int count = numOfRecommend - recommends.size();


    Set<Integer> follows = graph.getFollows(useerId);
    List<Integer> friendsOfFriends = new LinkedList<>();
    for (Integer id : follows) {
      Set<Integer> temp = graph.getNode(id).getFollows();
      for (Integer id2 : temp) {
        if ((!friendsOfFriends.contains(id2)) && (!follows.contains(id2)) && !id2.equals(useerId)) {
          friendsOfFriends.add(id2);
        }
      }
    }

    if (friendsOfFriends.size() > count) {
      Collections.sort(friendsOfFriends);
    }

    for (int i = 0; i < friendsOfFriends.size() && i < count; i++) {
      if (!recommends.contains(friendsOfFriends.get(i))) {
        recommends.add(friendsOfFriends.get(i));
      }
    }
  }
}
