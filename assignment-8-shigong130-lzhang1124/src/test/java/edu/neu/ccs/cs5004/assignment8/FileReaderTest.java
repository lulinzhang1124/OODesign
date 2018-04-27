package edu.neu.ccs.cs5004.assignment8;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class FileReaderTest {

  @Before
  public void setUp() throws Exception {
  }

  @Test
  public void readFileLines() {
    List<String> list = FileReader.readFileLines("no.txt");
    assertEquals(0, list.size());

    list = FileReader.readFileLines("nodes_small.csv");
    assertEquals(102, list.size());
  }
}