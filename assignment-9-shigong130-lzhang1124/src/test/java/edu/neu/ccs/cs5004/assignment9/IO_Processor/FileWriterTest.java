package edu.neu.ccs.cs5004.assignment9.IO_Processor;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


import java.io.File;
import java.io.IOException;



public class FileWriterTest {


  @Before
  public void setUp() throws Exception {
  }

  @Test
  public void writeStringToFile() {
    File file= new File("test1");
    try {
      FileWriter.writeStringToFile(file,"test");
    } catch (IOException e) {
      e.printStackTrace();
    }
    Assert.assertTrue(file.exists());
    file.delete();


  }
}
