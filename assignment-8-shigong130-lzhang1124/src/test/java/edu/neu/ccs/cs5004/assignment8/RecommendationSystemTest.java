package edu.neu.ccs.cs5004.assignment8;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import static org.junit.Assert.assertTrue;

public class RecommendationSystemTest {

  private RecommendationSystem recommendationSystem;
  private Graph graph;
  private String processingFlag;
  private Integer processingNumber;
  private Integer numberOfRecomends;

  @Before
  public void setUp() throws Exception {
    recommendationSystem = new RecommendationSystem();
    graph = new Graph();
    graph.buildGraph("nodes_small.csv", "edges_small.csv");
    processingNumber = 10;
    processingFlag = "s";
    numberOfRecomends = 15;
  }

  @Test
  public void Recommendation() {
    recommendationSystem.recommendation(graph, processingFlag, processingNumber, numberOfRecomends);
  }


  @Test
  public void writeResult() throws IOException {
    String filePath = "testResult/testWriteResult";
    File file = new File(filePath);
    file.delete();


    Graph graph = new Graph();

    graph.buildGraph("nodes_small.csv", "edges_small.csv");

    RecommendationSystem recommendationSystem = new RecommendationSystem();

    Integer user = 3;

    recommendationSystem.recommendation(graph, "b", 2, 2);

    recommendationSystem.writeResult(filePath);


    assertTrue(file.exists());


    InputStream inputStream = new FileInputStream(filePath);
    Reader temp = new InputStreamReader(inputStream, "UTF-8");
    BufferedReader reader = new BufferedReader(temp);


    String line = reader.readLine();

    assertTrue(line.length() != 0);

    file.delete();
  }

}