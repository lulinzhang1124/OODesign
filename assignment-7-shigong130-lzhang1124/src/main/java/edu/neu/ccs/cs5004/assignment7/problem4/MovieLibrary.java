package edu.neu.ccs.cs5004.assignment7.problem4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Represents a movie library.
 */
public class MovieLibrary implements ImovieLibrary {

  private Map<String, Movie> library;

  /**
   * Creates a movie library.
   */
  public MovieLibrary() {
    library = new HashMap<>();
  }

  /**
   * Gets a list of movies for the given director.
   * Time complexity is the larger of O(nlogn) or O(mn), where n stands for the number of movies,
   * m stands for the number of directors per movie. Since using common sense, we assume
   * the number of directors per movie is a constant number, in this case, time complexity will
   * be O(nlogn). Space complexity is O(n).
   *
   * @param director - a director.
   * @return - a list of movies for the given director.
   */
  @Override
  public List<Movie> getDirectorMovie(Director director) {

    List<Movie> listOfMovie = new ArrayList<>();

    for (Map.Entry<String, Movie> entry : library.entrySet()) {

      if (entry.getValue().getDirectors().contains(director)) {
        listOfMovie.add(entry.getValue());
      }
    }

    sortList(listOfMovie);
    return listOfMovie;
  }

  /**
   * Sort a given movie list.
   *
   * @param movies - a movie list.
   */
  private void sortList(List<Movie> movies) {
    Collections.sort(movies);
  }

  /**
   * Adds a movie to the library. Time complexity is O(1), space complexity is O(1).
   *
   * @param movie - a movie to be added to the library.
   */
  @Override
  public void add(Movie movie) {
    if (movie.getYear() < ONE_THOUSAND || movie.getYear() >= TEN_THOUSAND) {
      throw new InvalidArgumentException("release year need to be four digit");
    }
    if (library.containsKey(movie.getAlias())) {
      throw new InvalidArgumentException("alias already used.");
    }

    library.put(movie.getAlias(), movie);
  }

  /**
   * Requests a movie for streaming. Time complexity O(1), space complexity is O(1).
   *
   * @param alias - the alias of a movie that is requested for streaming.
   */
  @Override
  public void requestMovieForStreaming(String alias) {
    library.get(alias).setCounter();
  }

  /**
   * Gets the streaming statics of a movie. Time complexity O(1), space complexity is O(1).
   *
   * @param alias - the alias of the movie.
   * @return - the total number that this movie was streamed.
   */
  @Override
  public Integer streamingStat(String alias) {

    return library.get(alias).getCounter();
  }


  /**
   * Gets the most streamed movie. Time complexity O(n), space complexity O(1).
   *
   * @return - the most streamed movie.
   */
  @Override
  public Movie mostStreamed() {
    Integer maxCount = ZERO;
    Movie mostStreamed = null;
    for (Map.Entry<String, Movie> entry : library.entrySet()) {
      if (entry.getValue().getCounter() > maxCount) {
        maxCount = entry.getValue().getCounter();
        mostStreamed = entry.getValue();
      }
    }

    return mostStreamed;
  }

  /**
   * Getter.
   *
   * @return - the value for property 'library'.
   */
  public Map<String, Movie> getLibrary() {
    return library;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    MovieLibrary that = (MovieLibrary) obj;
    return Objects.equals(library, that.library);
  }

  @Override
  public int hashCode() {

    return Objects.hash(library);
  }

  @Override
  public String toString() {
    return "MovieLibrary{"
            +
            "library="
            + library
            +
            '}';
  }
}
