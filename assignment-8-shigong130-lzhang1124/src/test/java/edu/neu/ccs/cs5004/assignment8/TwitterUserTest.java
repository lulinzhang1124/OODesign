package edu.neu.ccs.cs5004.assignment8;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Calendar;
import java.util.Date;


public class TwitterUserTest {
  private TwitterUser twitterUser;
  private TwitterUser sameRefTwitterUser;
  private TwitterUser sameStateTwitterUser;
  private TwitterUser yetAnotherTwitterUser;
  private TwitterUser diffTwitterUser;
  private TwitterUser diffTwitterUser2;
  private TwitterUser nullTwitterUser;
  private Date date;

  @Before
  public void setUp() throws Exception {
    Calendar calendar = Calendar.getInstance();
    calendar.clear();
    calendar.set(2018, 03 - 1, 28);
    date = calendar.getTime();
    twitterUser = new TwitterUser(0, date, 'F', 18, "Seattle");
    sameRefTwitterUser = twitterUser;
    sameStateTwitterUser = new TwitterUser(0, date, 'F', 18, "Seattle");
    yetAnotherTwitterUser = new TwitterUser(0, date, 'F', 18, "Seattle");
    diffTwitterUser = new TwitterUser(1, date, 'F', 18, "Seattle");
    diffTwitterUser2 = new TwitterUser(0, date, 'M', 18, "Seattle");
    nullTwitterUser = null;

  }

  @Test
  public void getFollows() {
    Assert.assertEquals(0, twitterUser.getFollowers().size());


  }

  @Test
  public void getId() {
    Assert.assertEquals(new Integer(0), twitterUser.getId());
  }


  @Test
  public void getFollowers() {
    Assert.assertEquals(0, twitterUser.getFollowers().size());
  }

  @Test
  public void getRecommendedNumber() {
    Assert.assertEquals(new Integer(0), twitterUser.getRecommendedNumber());
  }

  @Test
  public void getFollowersNum() {
    Assert.assertEquals(new Integer(0), twitterUser.getRecommendedNumber());
  }

  @Test
  public void buildFromLine() {
    String invalid = "1,2,3,4,5,6";
    Assert.assertNull(twitterUser.buildFromLine(invalid));

    String valid = "0,03/28/18,F,18,Seattle";
    Assert.assertEquals(twitterUser, twitterUser.buildFromLine(valid));

  }

  @Test
  public void testEquals() {

    Assert.assertTrue(twitterUser.equals(twitterUser));
    Assert.assertTrue(twitterUser.equals(sameRefTwitterUser));
    Assert.assertTrue(twitterUser.equals(sameStateTwitterUser));
    Assert.assertTrue(sameStateTwitterUser.equals(twitterUser));
    Assert.assertEquals(twitterUser.equals(sameStateTwitterUser), sameStateTwitterUser.equals(twitterUser));
    Assert.assertEquals(twitterUser.equals(sameStateTwitterUser) && sameStateTwitterUser.equals(yetAnotherTwitterUser), yetAnotherTwitterUser.equals(twitterUser));
    Assert.assertFalse(twitterUser.equals(diffTwitterUser));
    Assert.assertFalse(twitterUser.equals(diffTwitterUser2));
    Assert.assertFalse(twitterUser.equals(new Integer(1)));
    Assert.assertFalse(twitterUser.equals(nullTwitterUser));
  }

  @Test
  public void testHashCode() {
    Assert.assertEquals(twitterUser.equals(sameRefTwitterUser), twitterUser.hashCode() == sameRefTwitterUser.hashCode());
    Assert.assertEquals(twitterUser.equals(sameStateTwitterUser), twitterUser.hashCode() == sameStateTwitterUser.hashCode());
  }

  @Test
  public void testToString() {

    String temp = "TwitterUser{twitterId=0, gender=F, age=18, city='Seattle', dateCreated=Wed Mar 28 00:00:00 PDT 2018, followers=[], follows=[], recommendedNumber=0}";
    Assert.assertEquals(temp, twitterUser.toString());
  }
}