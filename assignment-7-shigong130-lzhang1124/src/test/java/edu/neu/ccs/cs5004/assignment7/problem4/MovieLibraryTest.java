package edu.neu.ccs.cs5004.assignment7.problem4;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MovieLibraryTest {
  private String alias1;
  private String alias2;
  private String alias3;
  private String title1;
  private String title2;
  private String title3;
  private Movie movie1;
  private Movie movie2;
  private Movie movie3;
  private Name name1;
  private Name name2;
  private Name name3;
  private Name name4;
  private Name name5;
  private Director director1;
  private Director director2;
  private Director director3;
  private Director director4;
  private Director director5;
  private Name name6;
  private Actor actor1;
  private List<Director> directors1;
  private List<Director> directors2;
  private List<Director> directors3;
  private List<Actor> actor;
  private MovieLibrary movieLibrary;
  private MovieLibrary sameRefLibrary;
  private MovieLibrary sameStateLibrary;
  private MovieLibrary yetAnotherLibrary;
  private MovieLibrary diffLibrary;
  private MovieLibrary mtLibrary;
  private MovieLibrary nullLibrary;



  @Before
  public void setUp() throws Exception {
    alias1 = "hello";
    alias2 = "lala";
    alias3 = "dear";
    title1 = "hello Kitty";
    title2 = "lala land";
    title3 = "dear friend";
    name1 = new Name("Angela","Baby");
    name2 = new Name("Mary","Baby");
    name3 = new Name("Simon","Li");
    name4 = new Name("Nichole","Wang");
    name5 = new Name("Emma","Oh");
    director1 = new

            Director(name1);
    director2 = new Director(name2);
    director3 = new Director(name3);
    director4 = new Director(name4);
    director5 = new Director(name5);
    directors1 = new ArrayList<>();
    directors1.add(director1);
    directors1.add(director2);
    directors1.add(director3);
    directors1.add(director4);
    directors2 = new ArrayList<>();
    directors2.add(director1);
    directors2.add(director2);
    directors2.add(director4);
    directors3 = new ArrayList<>();
    directors3.add(director4);
    directors3.add(director5);
    name6 = new Name("actor","chen");
    actor = new ArrayList<>();
    actor1 = new Actor(name6);
    actor.add(actor1);
    movie1 = new Movie(alias1,title1,2018,directors1,actor);
    movie2 = new Movie(alias2,title2,2020,directors2,actor);
    movie3 = new Movie(alias3,title3,2019,directors3,actor);
    movieLibrary = new MovieLibrary();
    movieLibrary.add(movie1);
    movieLibrary.add(movie2);
    movieLibrary.add(movie3);
    sameRefLibrary = movieLibrary;
    sameStateLibrary = new MovieLibrary();
    sameStateLibrary.add(movie1);
    sameStateLibrary.add(movie2);
    sameStateLibrary.add(movie3);
    yetAnotherLibrary = new MovieLibrary();
    yetAnotherLibrary.add(movie1);
    yetAnotherLibrary.add(movie2);
    yetAnotherLibrary.add(movie3);
    diffLibrary = new MovieLibrary();
    diffLibrary.add(movie1);
    mtLibrary = new MovieLibrary();
    nullLibrary = null;
  }

  @Test
  public void getDirectorMovie() {
    List<Movie> expected = new ArrayList<>();
    expected.add(movie2);
    expected.add(movie3);
    expected.add(movie1);
    Assert.assertEquals(expected,movieLibrary.getDirectorMovie(director4));


   }

  @Test
  public void add() {
    MovieLibrary expected = new MovieLibrary();
    expected.add(movie1);
    expected.add(movie2);
    expected.add(movie3);
    Assert.assertEquals(expected,movieLibrary);
    mtLibrary.add(movie1);
    Assert.assertEquals(diffLibrary, mtLibrary);
  }

  @Test(expected = InvalidArgumentException.class)
  public void add2() {
   movieLibrary.add(movie1);
  }


  @Test(expected = InvalidArgumentException.class)
  public void add1() {
   Movie movieWrongYear = new Movie(alias1,title1,999, directors1,actor);
    mtLibrary.add(movieWrongYear);
  }

  @Test
  public void requestMovieForStreaming() {
    movieLibrary.requestMovieForStreaming("lala");
  }

  @Test
  public void streamingStat() {
    movieLibrary.requestMovieForStreaming("lala");
    movieLibrary.requestMovieForStreaming("lala");
    movieLibrary.requestMovieForStreaming("lala");
    movieLibrary.requestMovieForStreaming("hello");
    Assert.assertEquals(new Integer(3),movieLibrary.streamingStat("lala"));
    Assert.assertEquals(new Integer(1),movieLibrary.streamingStat("hello"));
  }

  @Test
  public void mostStreamed() {
    Assert.assertEquals(null,movieLibrary.mostStreamed());

    movieLibrary.requestMovieForStreaming("lala");
    movieLibrary.requestMovieForStreaming("lala");
    movieLibrary.requestMovieForStreaming("lala");
    movieLibrary.requestMovieForStreaming("hello");
    movieLibrary.requestMovieForStreaming("lala");
    movieLibrary.requestMovieForStreaming("dear");
    movieLibrary.requestMovieForStreaming("dear");
    Assert.assertEquals(movie2,movieLibrary.mostStreamed());

  }

  @Test
  public void testEquals() {
    Assert.assertTrue(movieLibrary.equals(movieLibrary));
    Assert.assertTrue(movieLibrary.equals(sameRefLibrary));
    Assert.assertTrue(movieLibrary.equals(sameStateLibrary));
    Assert.assertTrue(sameStateLibrary.equals(movieLibrary));
    Assert.assertEquals(movieLibrary.equals(sameStateLibrary),sameStateLibrary.equals(movieLibrary));
    Assert.assertEquals(movieLibrary.equals(sameStateLibrary)&& sameStateLibrary.equals(yetAnotherLibrary),yetAnotherLibrary.equals(movieLibrary));
    Assert.assertFalse(movieLibrary.equals(diffLibrary));
    Assert.assertFalse(movieLibrary.equals(new Integer(1)));
    Assert.assertFalse(movieLibrary.equals(nullLibrary));
  }

  @Test
  public void testHashCode() {
    Assert.assertEquals(movieLibrary.equals(sameRefLibrary), movieLibrary.hashCode()==sameRefLibrary.hashCode());
    Assert.assertEquals(movieLibrary.equals(sameStateLibrary), movieLibrary.hashCode()==sameStateLibrary.hashCode());


  }

  @Test
  public void testToString() {

    String temp = "MovieLibrary{" +
            "library=" + movieLibrary.getLibrary() +
            '}';

    Assert.assertEquals(temp,movieLibrary.toString());
  }
}