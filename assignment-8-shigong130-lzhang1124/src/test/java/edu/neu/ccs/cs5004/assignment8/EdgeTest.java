package edu.neu.ccs.cs5004.assignment8;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class EdgeTest {
  private Edge edge;
  private Edge sameRefEdge;
  private Edge sameStateEdge;
  private Edge yetAnotherEdge;
  private Edge diffEdge;
  private Edge nullEdge;


  @Before
  public void setUp() throws Exception {
    edge = Edge.buildFromLine("1,2");
    sameRefEdge = edge;
    sameStateEdge = Edge.buildFromLine("1,2");
    yetAnotherEdge = Edge.buildFromLine("1,2");
    diffEdge = Edge.buildFromLine("3.4");
    nullEdge = null;
  }

  @Test
  public void testEdge() throws Exception {


    assertEquals(edge, new Edge(1, 2));
    assertTrue(Edge.buildFromLine("") == null);
    assertEquals(edge.hashCode(), new Edge(1, 2).hashCode());
    assertFalse(edge.equals(new Edge(2, 3)));
    assertFalse(edge.equals(new Object()));
  }


  @Test
  public void getTwitterId1() {
    Assert.assertEquals(new Integer(1), edge.getTwitterId1());
  }

  @Test
  public void getTwitterId2() {
    Assert.assertEquals(new Integer(2), edge.getTwitterId2());

  }

  @Test
  public void buildFromLine() {
    Assert.assertNull(edge.buildFromLine("3"));
    Assert.assertNull(edge.buildFromLine("3, 4, 5"));
    Assert.assertEquals(edge, Edge.buildFromLine("1,2"));

  }

  @Test
  public void equals() {

    Assert.assertTrue(edge.equals(edge));
    Assert.assertTrue(edge.equals(sameRefEdge));
    Assert.assertTrue(edge.equals(sameStateEdge));
    Assert.assertTrue(sameStateEdge.equals(edge));
    Assert.assertEquals(edge.equals(sameStateEdge), sameStateEdge.equals(edge));
    Assert.assertEquals(edge.equals(sameStateEdge) && sameStateEdge.equals(yetAnotherEdge), yetAnotherEdge.equals(edge));
    Assert.assertFalse(edge.equals(diffEdge));
    Assert.assertFalse(edge.equals(new Integer(1)));
    Assert.assertFalse(edge.equals(nullEdge));

  }

  @Test
  public void testHashCode() {
    Assert.assertEquals(edge.equals(sameRefEdge), edge.hashCode() == sameRefEdge.hashCode());
    Assert.assertEquals(edge.equals(sameStateEdge), edge.hashCode() == sameStateEdge.hashCode());
  }


  @Test
  public void testToString() {
    String temp = "Edge{" + "twitterId1=" + edge.getTwitterId1() + ", twitterId2=" + edge.getTwitterId2() + '}';
    Assert.assertEquals(temp, edge.toString());
  }
}