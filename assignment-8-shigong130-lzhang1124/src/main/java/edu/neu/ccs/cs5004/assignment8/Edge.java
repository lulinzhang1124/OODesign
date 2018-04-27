package edu.neu.ccs.cs5004.assignment8;

import java.util.Objects;

/**
 * Represents a edge class.
 */
public class Edge implements IEdge {
  private Integer twitterId1;
  private Integer twitterId2;


  /**
   * Creates a new edge.
   *
   * @param twitterId1 - id of first uer.
   * @param twitterId2 - id of second user.
   */
  public Edge(Integer twitterId1, Integer twitterId2) {
    this.twitterId1 = twitterId1;
    this.twitterId2 = twitterId2;
  }

  /**
   * This method is used to read the edge data from file
   *
   * @param line each line in the file
   * @return edge. for example 1,3 means user 1 follows user 3
   */
  public static Edge buildFromLine(String line) {
    String[] items = line.split(",");
    if (items.length != Number.TWO.getValue()) {
      return null;
    }
    Integer id1 = Integer.valueOf(items[Number.ZERO.getValue()]);
    Integer id2 = Integer.valueOf(items[Number.ONE.getValue()]);

    return new Edge(id1, id2);
  }

  /**
   * Getter.
   *
   * @return ID of first user.
   */
  public Integer getTwitterId1() {
    return twitterId1;
  }

  /**
   * Getter.
   *
   * @return ID of second user.
   */
  public Integer getTwitterId2() {
    return twitterId2;
  }


  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    Edge edge = (Edge) obj;
    return Objects.equals(twitterId1, edge.twitterId1)
        && Objects.equals(twitterId2, edge.twitterId2);
  }

  @Override
  public int hashCode() {

    return Objects.hash(twitterId1, twitterId2);
  }

  @Override
  public String toString() {
    return "Edge{" + "twitterId1=" + twitterId1 + ", twitterId2=" + twitterId2 + '}';
  }
}
