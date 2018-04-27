package edu.neu.ccs.cs5004.assignment7.problem4;

import java.util.List;
import java.util.Map;

/**
 * Represents an interface for movie library project.
 */
public interface ImovieLibrary {

  Integer ONE_THOUSAND = 1000;
  Integer TEN_THOUSAND = 10000;
  Integer ZERO = 0;

  /**
   * Gets a list of movies for the given director.
   *
   * @param director - a director.
   * @return - a list of movies for the given director.
   */
  List<Movie> getDirectorMovie(Director director);

  /**
   * Adds a movie to the library.
   *
   * @param movie - a movie to be added to the library.
   */
  void add(Movie movie);


  /**
   * Requests a movie for streaming.
   *
   * @param alias - the alias of a movie that is requested for streaming.
   */
  void requestMovieForStreaming(String alias);

  /**
   * Gets the streaming statics of a movie.
   *
   * @param alias - the alias of the movie.
   * @return - the total number that this movie was streamed.
   */
  Integer streamingStat(String alias);

  /**
   * Gets the most streamed movie.
   *
   * @return - the most streamed movie.
   */
  Movie mostStreamed();

  /**
   * Getter.
   *
   * @return - the value for property 'library'.
   */
  Map<String, Movie> getLibrary();
}
