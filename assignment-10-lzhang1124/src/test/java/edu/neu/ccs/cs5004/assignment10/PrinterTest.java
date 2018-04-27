package edu.neu.ccs.cs5004.assignment10;

import org.junit.Test;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class PrinterTest {
  @Test
  public void printPublicKeyUsage() throws Exception {
    Map<IKey, Integer> map = new HashMap<>();
    map.put(new Key(BigInteger.ONE, BigInteger.TEN), 2);
    map.put(new Key(BigInteger.ONE, BigInteger.ZERO), 1);
    (new Printer()).printPublicKeyUsage(map);
  }

}