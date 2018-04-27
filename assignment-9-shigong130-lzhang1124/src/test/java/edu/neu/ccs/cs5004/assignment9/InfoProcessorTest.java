package edu.neu.ccs.cs5004.assignment9;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;


public class InfoProcessorTest {
  private InfoProcessor infoProcessor;
  private List<String> header;
  private List<String> info;
  private List<String> info2;
  private InfoProcessor sameRefProcessor;
  private InfoProcessor sameStateProcesor;
  private InfoProcessor yetAnotherProessor;
  private InfoProcessor diffProcessor;
  private InfoProcessor nullProcessor;


  @Before
  public void setUp() throws Exception {
    infoProcessor = new InfoProcessor();
    header = Arrays.asList("name","gender","city");
    info2 = Arrays.asList("Simon","male","Seattle");
    info = Arrays.asList("John","male","Seattle");
    infoProcessor.updateProcessor(header,info);
    sameRefProcessor = infoProcessor;
    sameStateProcesor = new InfoProcessor();
    sameStateProcesor.updateProcessor(header,info);
    yetAnotherProessor = new InfoProcessor();
    yetAnotherProessor.updateProcessor(header,info);
    diffProcessor = new InfoProcessor();
    diffProcessor.updateProcessor(header,info2);
    nullProcessor = null;
  }

  @Test
  public void updateProcessor() {
    info = Arrays.asList("Marry","female","Boston");
   infoProcessor.updateProcessor(header,info);
    Assert.assertEquals("Marry",infoProcessor.getValue("name"));

  }

  @Test
  public void getValue() {

    Assert.assertEquals("John",infoProcessor.getValue("name"));
  }

  @Test
  public void equals() {

    Assert.assertTrue(infoProcessor.equals(infoProcessor));
    Assert.assertTrue(infoProcessor.equals(sameRefProcessor));
    Assert.assertTrue(infoProcessor.equals(sameStateProcesor));
    Assert.assertTrue(sameStateProcesor.equals(infoProcessor));
    Assert.assertEquals(infoProcessor.equals(sameStateProcesor),sameStateProcesor.equals(infoProcessor));
    Assert.assertEquals(infoProcessor.equals(sameStateProcesor)&& sameStateProcesor.equals(yetAnotherProessor),yetAnotherProessor.equals(infoProcessor));
    Assert.assertFalse(infoProcessor.equals(diffProcessor));
    Assert.assertFalse(infoProcessor.equals(new Integer(1)));
    Assert.assertFalse(infoProcessor.equals(nullProcessor));
  }

  @Test
  public void testHashCode() {
    Assert.assertEquals(infoProcessor.equals(sameRefProcessor), infoProcessor.hashCode()==sameRefProcessor.hashCode());
    Assert.assertEquals(infoProcessor.equals(sameStateProcesor), infoProcessor.hashCode()==sameStateProcesor.hashCode());

  }

  @Test
  public void testToString() {
    String temp = "InfoProcessor{map={gender=male, city=Seattle, name=John}}";
    Assert.assertEquals(temp,infoProcessor.toString());
  }
}
