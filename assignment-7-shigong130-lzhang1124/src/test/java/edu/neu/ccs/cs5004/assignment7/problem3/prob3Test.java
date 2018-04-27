package edu.neu.ccs.cs5004.assignment7.problem3;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class prob3Test {
  private Map<String, List<Integer>> map;
  List<Integer> l1;
  List<Integer> l2;
  List<Integer> l3;
  List<Integer> l4;
  List<Integer> l5;
  SkillIndex p1;


  @Before
  public void setUp() throws Exception {
    p1 = new SkillIndex();
    l1 = new ArrayList<>();
    l1.add(112233);
    l1.add(223456);
    l1.add(357911);
    l1.add(481216);
    l1.add(714210);
    l2 = new ArrayList<>();
    l2.add(112233);
    l2.add(357911);
    l2.add(714210);
    l3 = new ArrayList<>();
    l3.add(112233);
    l4 = new ArrayList<>();
    l4.add(223456);
    l5 = new ArrayList<>();
    l5.add(357911);

    map = new HashMap<>();
    map.put("Java",l1);
    map.put("Python",l2);
    map.put("OOD",l3);
    map.put("JavaScript",l4);
    map.put("AWS",l5);
  }

  @Test
  public void convert() {
    List<String> s1 = new ArrayList<>();
    List<String> s2 = new ArrayList<>();
    List<String> s3 = new ArrayList<>();
    List<String> s4 = new ArrayList<>();
    List<String> s5 = new ArrayList<>();
    s1.add("Java");
    s1.add("OOD");
    s1.add("Python");
    s2.add("Java");
    s2.add("JavaScript");
    s3.add("Java");
    s3.add("AWS");
    s3.add("Python");
    s4.add("Java");
    s5.add("Java");
    s5.add("Python");
    Map<Integer,List<String>> res = new HashMap<>();
    res.put(112233,s1);
    res.put(223456, s2);
    res.put(357911,s3);
    res.put(481216, s4);
    res.put(714210,s5);

    assertEquals(res,p1.convert(map));
  }
}