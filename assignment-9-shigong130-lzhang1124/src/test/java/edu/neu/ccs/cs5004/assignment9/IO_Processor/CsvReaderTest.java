package edu.neu.ccs.cs5004.assignment9.IO_Processor;


import org.junit.Before;
import org.junit.Test;

import java.io.IOException;


import static org.junit.Assert.*;

public class CsvReaderTest {


  @Before
  public void setUp() throws Exception {

  }

  @Test(expected = IOException.class)
  public void fileReader() throws IOException {
    String content = CsvReader.fileReader("no.txt");
    assertEquals(0,content.length());

    content = CsvReader.fileReader("customer.csv");

  }

  @Test
  public void fileReader1() throws IOException {

    String content = CsvReader.fileReader("customer.csv");

  }
}
