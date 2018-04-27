package edu.neu.ccs.cs5004.assignment8;

/**
 * Represent a Edge interface.
 */
public interface IEdge {

  /**
   * Static factory method to create an User object with the given parameters.
   *
   * @param twitterId1 the edge's source user's id
   * @param twitterId2 the edge's destination user's id
   */
  static IEdge createEdge(Integer twitterId1, Integer twitterId2) {
    return new Edge(twitterId1, twitterId2);
  }

  /**
   * Getter.
   *
   * @return ID of first user.
   */
  Integer getTwitterId1();


  /**
   * Getter.
   *
   * @return ID of second user.
   */
  Integer getTwitterId2();

}
