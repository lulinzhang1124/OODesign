package edu.neu.ccs.cs5004.assignment8.recommendation;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import edu.neu.ccs.cs5004.assignment8.Graph;

public class RandomTest {

  private Random random;
  private Graph graph;
  private Integer id;
  private List<Integer> recommends;
  private Integer numberOfRecomends;

  @Before
  public void setUp() throws Exception {
    random = new Random();
    graph = new Graph();
    graph.buildGraph("nodes_small.csv", "edges_small.csv");
    id = 3;
    recommends = new LinkedList<>();
    numberOfRecomends = 10;
  }

  @Test
  public void recommendationBasedOnCriteria() {
    random.recommendationBasedOnCriteria(graph, id, recommends, numberOfRecomends);
    Assert.assertEquals(10, recommends.size());
  }
}