package edu.neu.ccs.cs5004.assignment3.problem2;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class AbstractSecretaryTest {

  private AbstractSecretary abstractSecretary1;
  private AbstractSecretary sameRefabstractSecretary1;
  private AbstractSecretary sameStateAsabstractSecretary1;

  @Before
  public void setUp() throws Exception {
    abstractSecretary1 = new LegalSecretary(new Name("Jon", "Snow"), 40,
        14, "L166Y15", 3);
    sameRefabstractSecretary1 = abstractSecretary1;
    sameStateAsabstractSecretary1 = new LegalSecretary(new Name("Jon", "Snow"), 40, 14,
        "L166Y15", 3);
  }

  @Test
  public void secheduleMeeting() {
    assertEquals("Let's schedule meetings.", abstractSecretary1.scheduleMeeting());
  }

  @Test
  public void uniqueBehavior() {
    assertEquals("Let's schedule meetings. Let's prepare legal documents!",
        abstractSecretary1.uniqueBehavior());
  }

  @Test
  public void equals() {
    AbstractSecretary nullabstractSecretary1 = null;
    AbstractSecretary yetAnotherabstractSecretary1 = new LegalSecretary(new Name("Jon", "Snow"), 40,
        14, "L166Y15", 3);
    AbstractSecretary diffabstractSecretary1 = new LegalSecretary(new Name("Julie", "West"), 40,
        14, "L166Y15", 3);
    AbstractSecretary diffabstractSecretary12 = new LegalSecretary(new Name("Jon", "Snow"), 35,
        14, "L166Y15", 3);
    AbstractSecretary diffabstractSecretary14 = new LegalSecretary(new Name("Jon", "Snow"), 40,
        15, "L166Y15", 3);
    AbstractSecretary diffabstractSecretary15 = new LegalSecretary(new Name("Jon", "Snow"), 40,
        14, "L166Y15", 1);
    AbstractSecretary diffabstractSecretary16 = new LegalSecretary(new Name("Jon", "Snow"), 40,
        14, "L166Y18", 3);

    assertTrue(abstractSecretary1.equals(abstractSecretary1)); // reflexivity
    assertTrue(abstractSecretary1.equals(sameRefabstractSecretary1)); // trivial condition both reference the same
    assertTrue(abstractSecretary1.equals(sameStateAsabstractSecretary1)); // both objects should have the same
    assertTrue(sameStateAsabstractSecretary1.equals(abstractSecretary1)); //symmetry

    assertFalse(abstractSecretary1.equals(diffabstractSecretary1)); //objects have different state
    assertFalse(abstractSecretary1.equals(diffabstractSecretary12));
    assertFalse(abstractSecretary1.equals(diffabstractSecretary14));
    assertFalse(abstractSecretary1.equals(diffabstractSecretary15));
    assertFalse(abstractSecretary1.equals(diffabstractSecretary16));
    assertFalse(abstractSecretary1.equals(nullabstractSecretary1)); // abstractSecretary1 is NOT null
    assertFalse(abstractSecretary1.equals(new Integer(4)));
    assertFalse(abstractSecretary1.equals(null));
    Integer nullnum = null;
    assertFalse(abstractSecretary1.equals(nullnum));

  }

  @Test
  public void hashCodeTest() {
    assertEquals(abstractSecretary1.equals(sameRefabstractSecretary1), abstractSecretary1.hashCode() == sameRefabstractSecretary1
        .hashCode()); //same objects have the same hashCode
    assertEquals(abstractSecretary1.equals(sameStateAsabstractSecretary1), abstractSecretary1.hashCode() ==
        sameStateAsabstractSecretary1.hashCode());
  }


}