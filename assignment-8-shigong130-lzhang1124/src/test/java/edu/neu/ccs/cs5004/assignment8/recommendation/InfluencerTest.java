package edu.neu.ccs.cs5004.assignment8.recommendation;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import edu.neu.ccs.cs5004.assignment8.Graph;

public class InfluencerTest {
  private Influencer influencer;
  private Graph graph;
  private Integer id;
  private List<Integer> recommends;
  private List<Integer> recommends2;
  private Integer numberOfRecomends;

  @Before
  public void setUp() throws Exception {
    influencer = new Influencer();
    graph = new Graph();
    graph.buildGraph("nodes_small.csv", "edges_small.csv");
    id = 3;
    recommends = new LinkedList<>();
    recommends2 = new LinkedList<>();
    numberOfRecomends = 10;
  }

  @Test
  public void recommendationBasedOnCriteria() {
    Graph graph2 = new Graph();
    graph2.buildGraph("nodes_10000.csv", "edges_10000.csv");
    influencer.recommendationBasedOnCriteria(graph2, id, recommends2, numberOfRecomends);
    Assert.assertEquals(0, recommends2.size());

    List<Integer> recommends3 = new LinkedList<>();
    Graph graph3 = new Graph();
    graph3.buildGraph("nodes_small.csv", "edges_smallOnlyForTest.csv");
    influencer.recommendationBasedOnCriteria(graph3, 92, recommends3, 1);
    Assert.assertEquals(1, recommends3.size());

    influencer.recommendationBasedOnCriteria(graph, id, recommends, numberOfRecomends);
    Assert.assertEquals(0, recommends.size());

  }
}