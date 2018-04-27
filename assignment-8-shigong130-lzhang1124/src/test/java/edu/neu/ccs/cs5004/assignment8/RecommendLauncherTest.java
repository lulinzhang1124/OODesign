package edu.neu.ccs.cs5004.assignment8;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class RecommendLauncherTest {

  @Before
  public void setUp() throws Exception {
  }

  @Test
  public void testMain() throws Exception {
    String[] args = new String[]{"nodes_small.csv", "edges_small.csv", "result.csv", "s", "10", "15"};
    RecommendLauncher.main(args);

    List<String> results = FileReader.readFileLines("result.csv");
    File file = new File("result.csv");
    file.delete();
    assertEquals(results.size(), 11);
  }

  @Test
  public void testMain2() throws Exception {
    String[] args = new String[]{"nodes_small.csv", "edges_small.csv", "result.csv", "r", "0", "0"};
    RecommendLauncher.main(args);

    args = new String[]{"nodes_small.csv", "edges_small.csv", "result.csv", "s", "0", "0"};
    RecommendLauncher.main(args);

    args = new String[]{"nodes_small.csv", "edges_small.csv", "result.csv", "e", "0", "0"};
    RecommendLauncher.main(args);

    args = new String[]{"nodes_small.csv", "edges_small.csv", "result.csv", "r", "0", "0"};
    RecommendLauncher.main(args);

    args = new String[]{"nodes_small.csv", "edges_small.csv", "result.csv", "a", "a", "b"};
    RecommendLauncher.main(args);

    args = new String[]{"nodes_small.csv", "edges_small.csv", "result.csv", "r", "a", "b"};
    RecommendLauncher.main(args);

    args = new String[]{"nodes_small.csv", "edges_small.csv", "result.csv", "r", "10", "b"};
    RecommendLauncher.main(args);

    args = new String[]{};
    RecommendLauncher.main(args);

    File file = new File("result.csv");
    assertFalse(file.exists());
  }

  @Test
  public void testMain3() throws Exception {
    String[] args = new String[]{"nodes_small.csv", "edges_small.csv", "result.csv", "s", "1", "1"};
    RecommendLauncher.main(args);

    List<String> results = FileReader.readFileLines("result.csv");
    File file = new File("result.csv");
    file.delete();
    assertEquals(results.size(), 2);
  }


  @Test
  public void parseArgsAndInit() {
    String[] twoArgs = {"nodes_small.csv", "edges_small.csv"};
    Assert.assertFalse(RecommendLauncher.parseArgsAndInit(twoArgs));

    String[] wrongFlag = {"nodes_small.csv", "edges_small.csv", "result.csv", "f"};
    Assert.assertFalse(RecommendLauncher.parseArgsAndInit(wrongFlag));

    String[] wrongUserNum = {"nodes_small.csv", "edges_small.csv", "result.csv", "s", "102", "20"};
    Assert.assertFalse(RecommendLauncher.parseArgsAndInit(wrongUserNum));

    String[] wrongRecNum = {"nodes_small.csv", "edges_small.csv", "result.csv", "s", "102", "101"};
    Assert.assertFalse(RecommendLauncher.parseArgsAndInit(wrongRecNum));

    String[] validInput = {"nodes_small.csv", "edges_small.csv", "result.csv", "s", "100", "100"};
    Assert.assertTrue(RecommendLauncher.parseArgsAndInit(validInput));
  }

}