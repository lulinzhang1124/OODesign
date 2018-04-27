package edu.neu.ccs.cs5004.assignment8;

import java.util.Date;
import java.util.Set;

/**
 * Represents a node interface.
 */
public interface User {

  /**
   * Static factory method to create an User object with the given parameters.
   *
   * @param twitterId   the user's id number
   * @param dateCreated the user account's created date
   * @param gender      the user's gender,
   * @param age         the user's age,
   * @param city        the user's city
   */
  static User creatUser(Integer twitterId, Date dateCreated, Character gender,
                        Integer age, String city) {
    return new TwitterUser(twitterId, dateCreated, gender, age, city);
  }


  /**
   * Getter.
   *
   * @return the id of a user node.
   */
  Integer getId();


  /**
   * Getter.
   *
   * @return the set of followers node has.
   */
  Set<Integer> getFollowers();

  /**
   * Getter.
   *
   * @return the recommendedNumber
   */
  Integer getRecommendedNumber();

  /**
   * Gets the total number of followers.
   *
   * @return - the total number of followers.
   */
  Integer getFollowersNum();

  /**
   * Getter.
   *
   * @return the set of nodes that user follows.
   */
  Set<Integer> getFollows();


}
