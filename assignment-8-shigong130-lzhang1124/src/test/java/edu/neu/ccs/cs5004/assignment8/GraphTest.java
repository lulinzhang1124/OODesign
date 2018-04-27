package edu.neu.ccs.cs5004.assignment8;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class GraphTest {
  private Graph graph;
  private Graph sameRefGraph;
  private Graph sameStateGraph;
  private Graph diffGraph;
  private Graph nullGraph;

  @Before
  public void setUp() throws Exception {
    graph = new Graph();
    graph.buildGraph("nodes_small.csv", "edges_small.csv");
    sameRefGraph = graph;
    sameStateGraph = new Graph();
    sameStateGraph.buildGraph("nodes_small.csv", "edges_small.csv");
    diffGraph = new Graph();
    diffGraph.buildGraph("nodes_10000.csv", "edges_10000.csv");
    nullGraph = null;


  }


  @Test
  public void getMap() {

    assertEquals(101, graph.getMap().size());
  }


  @Test
  public void totalNumberOfUsers() {
    assertEquals(101, graph.totalNumberOfUsers().intValue());
  }

  @Test
  public void processUsers() {
    List<Integer> temp = new ArrayList<>();
    temp.add(0);
    temp.add(1);
    temp.add(2);
    List<Integer> temp2 = new ArrayList<>();
    temp2.add(100);
    temp2.add(99);
    temp2.add(98);
    assertEquals(temp, graph.processUsers("s", 3));
    assertEquals(temp2, graph.processUsers("e", 3));
    assertEquals(3, graph.processUsers("r", 3).size(), 3);
  }

  @Test
  public void getNode() {
    Calendar calendar = Calendar.getInstance();
    calendar.clear();
    calendar.set(2009, 01 - 1, 01);
    Date date = calendar.getTime();
    User user = new TwitterUser(1, date, 'F', 22, "Seattle");
    assertEquals(graph.getNode(user.getId()), graph.getNode(1));
  }

  @Test
  public void getFollowers() {
    Set<Integer> temp = new HashSet<>();
    temp.addAll(Arrays.asList(96, 33, 97, 99, 74, 76, 48, 20, 86, 88, 25, 94, 95));

    assertEquals(temp, graph.getNode(3).getFollowers());
  }

  @Test
  public void getFollows() {
    Set<Integer> temp = new HashSet<>();
    temp.addAll(Arrays.asList(80, 81, 39, 23, 79));

    assertEquals(temp, graph.getNode(1).getFollows());
  }

  @Test
  public void getInfluencers() {
    List<Integer> temp = new ArrayList<>();
    temp.add(36);
    temp.add(80);
    assertEquals(temp, graph.getInfluencers(19));
  }


  @Test
  public void testEquals() {

    Assert.assertTrue(graph.equals(graph));
    Assert.assertTrue(graph.equals(sameRefGraph));
    Assert.assertTrue(graph.equals(sameStateGraph));
    Assert.assertTrue(sameStateGraph.equals(graph));
    Assert.assertEquals(graph.equals(sameStateGraph), sameStateGraph.equals(graph));
    Assert.assertFalse(graph.equals(diffGraph));
    Assert.assertFalse(graph.equals(new Integer(1)));
    Assert.assertFalse(graph.equals(nullGraph));
  }

  @Test
  public void testHashCode() {
    Assert.assertEquals(graph.equals(sameRefGraph), graph.hashCode() == sameRefGraph.hashCode());
    Assert.assertEquals(graph.equals(sameStateGraph), graph.hashCode() == sameStateGraph.hashCode());
  }

  @Test
  public void testToString() {
    String temp = "Graph{" +
        "map=" + graph.getMap() +
        '}';

    Assert.assertEquals(temp, graph.toString());

  }
}