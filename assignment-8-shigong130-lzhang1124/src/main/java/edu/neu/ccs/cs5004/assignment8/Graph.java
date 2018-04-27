package edu.neu.ccs.cs5004.assignment8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * Represents a graph class.
 */
public class Graph implements TwitterGraph {


  private Map<Integer, User> map = new HashMap<>();


  /**
   * Getter.
   *
   * @return - the value of property 'map'.
   */
  public Map<Integer, User> getMap() {
    return map;
  }


  /**
   * This method is used to build the graph, representing the relationship between users.
   *
   * @param file1 node file, which contains users each line
   * @param file2 edge file, which contains edge each line
   */
  @Override
  public void buildGraph(String file1, String file2) {
    List<String> lines = FileReader.readFileLines(file1);
    lines.remove(Number.ZERO.getValue());
    for (String line : lines) {
      User user = TwitterUser.buildFromLine(line);
      if (user == null) {
        continue;
      }
      //add the user which read from the file.

      map.put(user.getId(), user);
    }

    //add the edge information into the graph, which represents the relationship between users.
    lines = FileReader.readFileLines(file2);
    lines.remove(Number.ZERO.getValue());
    for (String line : lines) {
      Edge edge = Edge.buildFromLine(line);
      addEdge(edge);
    }
  }

  /**
   * This method is used to add the edge information for a user.
   *
   * @param edge for example edge 1,2 means user 1 follows user 2
   */
  private void addEdge(Edge edge) {
    User user1 = map.get(edge.getTwitterId1());
    User user2 = map.get(edge.getTwitterId2());
    if (user1 == null || user2 == null) {
      return;
    }
    user1.getFollows().add(user2.getId());
    user2.getFollowers().add(user1.getId());

  }

  /**
   * Get the total number of users.
   *
   * @return total number of users
   */
  @Override
  public Integer totalNumberOfUsers() {
    return allUsers().size();
  }

  /**
   * Gets all user ids.
   *
   * @return - a list of all user ids.
   */
  @Override
  public List<Integer> allUsers() {
    return new ArrayList<>(map.keySet());
  }


  /**
   * This method is used to define three ways to process user.
   * Where s means process the user from beginning, e from the end, and r is in random order.
   *
   * @param processingFlag         a character from s, e, r
   * @param numberOfUsersToProcess number of users you need to process to make recommendation
   * @return the users list
   */
  @Override
  public List<Integer> processUsers(String processingFlag, Integer numberOfUsersToProcess) {
    List<Integer> users = new LinkedList<>();
    UserIterator userIterator = new UserIterator(allUsers(), processingFlag);
    for (int i = 0; i < numberOfUsersToProcess && i < map.keySet().size(); i++) {
      users.add(userIterator.next());
    }
    return users;
  }

  /**
   * This method is to get the user according to his ID number.
   *
   * @param twitterId id number of the user
   * @return user node
   */
  public User getNode(Integer twitterId) {
    return map.get(twitterId);
  }

  /**
   * This method is used to get the followers of a user according to his ID.
   *
   * @param twitterId id number of the user
   * @return this user's followers
   */
  @Override
  public Set<Integer> getFollowers(Integer twitterId) {
    return map.get(twitterId).getFollowers();
  }

  /**
   * This method is used to get the follows of a user according to his ID.
   *
   * @param twitterId id number of the user
   * @return this user's follows
   */
  @Override
  public Set<Integer> getFollows(Integer twitterId) {
    return map.get(twitterId).getFollows();
  }

  /**
   * This method is used to get the influencers list.
   * The influencers's criterion standard is based on the number, criterionOfInfluencer
   *
   * @param criterionOfInfluencer used to define whether a node is an influencer.
   * @return list of users who are influencers
   */

  @Override
  public List<Integer> getInfluencers(int criterionOfInfluencer) {
    List<Integer> list = new LinkedList<>();
    for (Integer id : allUsers()) {
      if (map.get(id).getFollowersNum() >= criterionOfInfluencer) {
        list.add(id);
      }
    }
    return list;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    Graph graph = (Graph) obj;
    return Objects.equals(getMap(), graph.getMap());
  }

  @Override
  public int hashCode() {

    return Objects.hash(getMap());
  }

  @Override
  public String toString() {
    return "Graph{" + "map=" + map + '}';
  }
}
