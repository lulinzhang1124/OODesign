package edu.neu.ccs.cs5004.assignment7.problem4;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class MovieTest {

  private Movie movie;
  private Movie sameRefMovie;
  private Movie sameStateMovie;
  private Movie yetAnotherMovie;
  private Movie diffMovie;
  private Movie nullMovie;
  private String alias1;
  private String alias2;
  private String title1;
  private String title2;
  private Name name1;
  private Name name2;
  private Director director1;
  private Director director2;
  private Name name6;
  private Actor actor1;
  private List<Director> directors1;
  private List<Director> directors2;
  private List<Actor> actor;
  private Movie diffTitleMovie;
  private Movie diffYearMovie;

  @Before
  public void setUp() throws Exception {
    alias1 = "hello";
    alias2 = "lala";
    title1 = "hello Kitty";
    title2 = "lala land";
    name1 = new Name("Angela","Baby");
    name2 = new Name("Mary","Baby");
    director1 = new Director(name1);
    director2 = new Director(name2);
    name6 = new Name("actor","chen");
    actor = new ArrayList<>();
    actor1 = new Actor(name6);
    actor.add(actor1);
    directors1 = new ArrayList<>();
    directors1.add(director1);
    directors1.add(director2);
    directors2 = new ArrayList<>();
    directors2.add(director1);
    movie = new Movie(alias1,title1,2018,directors1,actor);
    diffMovie = new Movie(alias2,title2,2020,directors2,actor);
    sameRefMovie = movie;
    sameStateMovie = new Movie(alias1,title1,2018,directors1,actor);
    yetAnotherMovie = new Movie(alias1,title1,2018,directors1,actor);
    nullMovie = null;
    diffTitleMovie = new Movie(alias1,title2,2018,directors1,actor);
    diffYearMovie = new Movie(alias1,title1,2019,directors1,actor);

  }



  @Test
  public void getAlias() {
    Assert.assertEquals(alias1,movie.getAlias());
  }

  @Test
  public void getTitle() {
    Assert.assertEquals(title1,movie.getTitle());
  }

  @Test
  public void getYear() {
    Assert.assertEquals(new Integer(2018),movie.getYear());
  }

  @Test
  public void getDirectors() {
    Assert.assertEquals(directors1,movie.getDirectors());
  }

  @Test
  public void getActors() {
    Assert.assertEquals(actor,movie.getActors());
  }

  @Test
  public void getCounter() {
    Assert.assertEquals(new Integer(0),movie.getCounter());
  }

  @Test
  public void setCounter() {
    movie.setCounter();
  }

  @Test
  public void testEquals() {

    Assert.assertTrue(movie.equals(movie));
    Assert.assertTrue(movie.equals(sameRefMovie));
    Assert.assertTrue(movie.equals(sameStateMovie));
    Assert.assertTrue(sameStateMovie.equals(movie));
    Assert.assertEquals(movie.equals(sameStateMovie),sameStateMovie.equals(movie));
    Assert.assertEquals(movie.equals(sameStateMovie)&& sameStateMovie.equals(yetAnotherMovie),yetAnotherMovie.equals(movie));
    Assert.assertFalse(movie.equals(diffMovie));
    Assert.assertFalse(movie.equals(new Integer(1)));
    Assert.assertFalse(movie.equals(nullMovie));
    Assert.assertFalse(movie.equals(diffTitleMovie));
    Assert.assertFalse(movie.equals(diffYearMovie));
  }

  @Test
  public void testHashCode() {
    Assert.assertEquals(movie.equals(sameRefMovie), movie.hashCode()==sameRefMovie.hashCode());
    Assert.assertEquals(movie.equals(sameStateMovie), movie.hashCode()==sameStateMovie.hashCode());

  }

  @Test
  public void testToString() {
    String temp =  "Movie{" +
            "alias='" + movie.getAlias() + '\'' +
            ", title='" + movie.getTitle() + '\'' +
            ", year=" + movie.getYear() +
            ", directors=" + movie.getDirectors() +
            ", actors=" + movie.getActors() +
            ", counter=" + movie.getCounter() +
            '}';
  }

  @Test
  public void compareTo() {
    Assert.assertEquals(1,movie.compareTo(diffMovie));
  }
}