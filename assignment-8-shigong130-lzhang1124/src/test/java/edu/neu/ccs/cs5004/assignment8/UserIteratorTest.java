package edu.neu.ccs.cs5004.assignment8;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class UserIteratorTest {
  private UserIterator userIterator;
  private List<Integer> allusers;

  @Before
  public void setUp() throws Exception {
    allusers = new ArrayList<>();
    allusers.add(1);
    allusers.add(2);
    allusers.add(3);
    allusers.add(4);
    allusers.add(5);
    allusers.add(6);

    userIterator = new UserIterator(allusers,"e");

  }


  @Test
  public void hasNext() {
    UserIterator userIterator2 = new UserIterator(allusers,"e");
    userIterator2.next();
    userIterator2.next();
    userIterator2.next();
    userIterator2.next();
    userIterator2.next();
    userIterator2.next();
    Assert.assertTrue(userIterator.hasNext());
    Assert.assertFalse(userIterator2.hasNext());

  }

  @Test
  public void next() {
    List<Integer> allusers1;
    allusers1 = new ArrayList<>();
    allusers1.add(1);
    allusers1.add(2);
    allusers1.add(3);
    UserIterator userIterator2 = new UserIterator(allusers1,"s");
   Assert.assertEquals(new Integer(6), userIterator.next());
   Assert.assertEquals(new Integer(1), userIterator2.next());
  }

  @Test
  public void remove() {
    userIterator.next();
    userIterator.remove();

  }
}