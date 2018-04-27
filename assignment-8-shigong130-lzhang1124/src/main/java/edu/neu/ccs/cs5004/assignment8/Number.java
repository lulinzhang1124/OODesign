package edu.neu.ccs.cs5004.assignment8;

/**
 * Represents enum class for magic numbers.
 */
public enum Number {

  ZERO(0),
  ONE(1),
  TWO(2),
  THREE(3),
  FOUR(4),
  FIVE(5),
  SIX(6),
  ONE_HUNDRED(100),
  TWO_THOUSAND(2000),
  INFLUENCER_SMALL(25),
  INFLUENCER_10000(250),
  SMALL_NODE_SIZE(101),
  FIFTY(50),
  FIFTEEN(15);


  private final int value;

  Number(final int newValue) {
    value = newValue;
  }

  /**
   * Getter.
   *
   * @return get enum number value.
   */
  public int getValue() {
    return value;
  }
}
