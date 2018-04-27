package edu.neu.ccs.cs5004.assignment8;

import org.junit.Assert;
import org.junit.Test;

public class NumberTest {


  @Test
  public void getValue() {
    Assert.assertEquals(0, Number.ZERO.getValue());
  }
}