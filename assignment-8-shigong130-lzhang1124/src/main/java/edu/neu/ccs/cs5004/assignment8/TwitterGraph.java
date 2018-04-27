package edu.neu.ccs.cs5004.assignment8;

import java.util.List;
import java.util.Set;

/**
 * Represents an interface of Twitter graph.
 */
public interface TwitterGraph {
  /**
   * Build a graph using a node file and an edge file.
   *
   * @param file1 node file.
   * @param file2 edge file.
   */
  void buildGraph(String file1, String file2);

  /**
   * Gets the total number of users.
   *
   * @return total number of users.
   */
  Integer totalNumberOfUsers();

  /**
   * Gets the list of user that this program need to make recommendations.
   *
   * @param processingFlag         - a character from s, e, r.
   * @param numberOfUsersToProcess - number of users you need to process to make recommendation.
   * @return the users list.
   */
  List<Integer> processUsers(String processingFlag, Integer numberOfUsersToProcess);

  /**
   * Gets all user ids.
   *
   * @return - a list of all user ids.
   */
  List<Integer> allUsers();

  /**
   * Gets the set of followers of a given user.
   *
   * @param twitterId id number of the user
   * @return this user's friends list
   */
  Set<Integer> getFollowers(Integer twitterId);

  /**
   * This method is used to get the follows of a user according to his ID.
   *
   * @param twitterId id number of the user
   * @return this user's follows
   */
  Set<Integer> getFollows(Integer twitterId);

  /**
   * Gets the influencers of all users based on the criterion given.
   *
   * @param criterionOfInfluencer used to define whether a node is an influencer.
   * @return list of users who are influencers.
   */
  List<Integer> getInfluencers(int criterionOfInfluencer);


  /**
   * Gets the node information of a given user id.
   *
   * @param twitterId id number of the user.
   * @return user node.
   */
  User getNode(Integer twitterId);


}
