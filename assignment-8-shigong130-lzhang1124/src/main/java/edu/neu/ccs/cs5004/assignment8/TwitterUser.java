package edu.neu.ccs.cs5004.assignment8;

import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Represents a user class.
 */
public class TwitterUser implements User {
  private Integer twitterId;
  private Character gender;
  private Integer age;
  private String city;
  private Date dateCreated;
  private Set<Integer> followers = new HashSet<>();
  private Set<Integer> follows = new HashSet<>();
  private Integer recommendedNumber = 0;


  /**
   * Constructor of a new user.
   *
   * @param twitterId   - every user's unique ID.
   * @param dateCreated - the date of profile creation in the format MM/DD/YY.
   * @param gender      - represent as one of the characters M, F or O, denoting male, female
   *                    and other.
   * @param age         - represent as an integer in the range [0, 100].
   * @param city        - represent the user's city.
   */
  TwitterUser(Integer twitterId, Date dateCreated, Character gender, Integer age, String city) {
    this.twitterId = twitterId;
    this.dateCreated = dateCreated;
    this.gender = gender;
    this.age = age;
    this.city = city;

  }

  /**
   * This method is used to read and parse the data from file.
   *
   * @param line each line in the file
   * @return a user that read from this line
   */
  public static User buildFromLine(String line) {
    String[] items = line.split(",");
    if (items.length != 5) {
      return null;
    }
    Integer twitterId = Integer.valueOf(items[0]);
    String dateCreated = items[1];
    Character gender = items[2].charAt(0);
    Integer age = Integer.valueOf(items[3]);
    String city = items[4];

    String[] itemsDate = dateCreated.split("/");
    int month = Integer.parseInt(itemsDate[0]);
    int day = Integer.parseInt(itemsDate[1]);
    int year = Integer.parseInt(itemsDate[2]);

    Calendar calendar = Calendar.getInstance();
    calendar.clear();
    calendar.set(year + Number.TWO_THOUSAND.getValue(),
        month - Number.ONE.getValue(), day);
    User user = new TwitterUser(twitterId, calendar.getTime(), gender, age, city);
    return user;
  }

  /**
   * Getter.
   *
   * @return - value for property 'follows'.
   */
  public Set<Integer> getFollows() {
    return follows;
  }

  /**
   * This method is used to get each user's ID.
   *
   * @return the id number
   */
  @Override
  public Integer getId() {
    return twitterId;
  }

  /**
   * This method is used to get the friend list of a user.
   *
   * @return list that contains users who are followers
   */
  @Override
  public Set<Integer> getFollowers() {
    return followers;
  }

  /**
   * This method is used to get the recommendation number of a user.
   *
   * @return recommendation number of this user
   */
  @Override
  public Integer getRecommendedNumber() {
    return recommendedNumber;
  }

  /**
   * This method is used to get the friend list of a user.
   *
   * @return number of followers
   */
  @Override
  public Integer getFollowersNum() {
    return followers.size();
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    TwitterUser twitterUser = (TwitterUser) obj;
    return Objects.equals(twitterId, twitterUser.twitterId)
        &&
        Objects.equals(gender, twitterUser.gender)
        &&
        Objects.equals(age, twitterUser.age)
        &&
        Objects.equals(city, twitterUser.city)
        &&
        Objects.equals(dateCreated, twitterUser.dateCreated)
        &&
        Objects.equals(getFollowers(), twitterUser.getFollowers())
        &&
        Objects.equals(getFollows(), twitterUser.getFollows())
        &&
        Objects.equals(getRecommendedNumber(), twitterUser.getRecommendedNumber());
  }

  @Override
  public int hashCode() {

    return Objects.hash(twitterId, gender, age, city, dateCreated, getFollowers(),
        getFollows(), getRecommendedNumber());
  }

  @Override
  public String toString() {
    return "TwitterUser{"
        +
        "twitterId="
        + twitterId
        + ", gender="
        + gender
        + ", age="
        + age
        + ", city='"
        + city + '\''
        + ", dateCreated="
        + dateCreated
        + ", followers="
        + followers + ", follows=" + follows + ", recommendedNumber=" + recommendedNumber + '}';
  }
}
