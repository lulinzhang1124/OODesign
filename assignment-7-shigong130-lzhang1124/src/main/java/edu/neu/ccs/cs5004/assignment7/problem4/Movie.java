package edu.neu.ccs.cs5004.assignment7.problem4;

import java.util.List;
import java.util.Objects;

/**
 * Represents a movie class.
 */
public class Movie implements Comparable<Movie> {
  private String alias;
  private String title;
  private Integer year;
  private List<Director> directors;
  private List<Actor> actors;
  private Integer counter;

  /**
   * Creates a movie using given information.
   *
   * @param alias     - the alias of a movie.
   * @param title     - the title of a movie.
   * @param year      - the year of a production of a movie.
   * @param directors - the directors of a movie.
   * @param actors    - the actor of a movie.
   */
  public Movie(String alias, String title, Integer year,
               List<Director> directors, List<Actor> actors) {
    this.alias = alias;
    this.title = title;
    this.year = year;
    this.directors = directors;
    this.actors = actors;
    counter = ImovieLibrary.ZERO;
  }

  /**
   * Getter.
   *
   * @return value for property 'alias'.
   */
  public String getAlias() {
    return alias;
  }

  /**
   * Getter.
   *
   * @return value for property 'title'.
   */
  public String getTitle() {
    return title;
  }

  /**
   * Getter.
   *
   * @return value for property 'year'.
   */
  public Integer getYear() {
    return year;
  }

  /**
   * Getter.
   *
   * @return value for property 'directors'.
   */
  public List<Director> getDirectors() {
    return directors;
  }

  /**
   * Getter.
   *
   * @return value for property 'actors'.
   */
  public List<Actor> getActors() {
    return actors;
  }

  /**
   * Getter.
   *
   * @return value for property 'counter'.
   */
  public Integer getCounter() {
    return counter;
  }

  /**
   * Setter for property 'counter'.
   */
  public void setCounter() {
    this.counter = counter + 1;
  }

  /**
   * Compares this object with the specified object for order.  Returns a
   * negative integer, zero, or a positive integer as this object is less
   * than, equal to, or greater than the specified object.
   *
   * @param other the object to be compared.
   * @return a negative integer, zero, or a positive integer as this object.
   *         is less than, equal to, or greater than the specified object.
   * @throws NullPointerException if the specified object is null
   * @throws ClassCastException   if the specified object's type prevents it
   *                              from being compared to this object.
   */
  @Override
  public int compareTo(Movie other) {
    return other.getYear().compareTo(this.getYear());
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    Movie movie = (Movie) obj;
    return Objects.equals(getAlias(), movie.getAlias())
            &&
            Objects.equals(getTitle(), movie.getTitle())
            &&
            Objects.equals(getYear(), movie.getYear())
            &&
            Objects.equals(getDirectors(), movie.getDirectors())
            &&
            Objects.equals(getActors(), movie.getActors())
            &&
            Objects.equals(getCounter(), movie.getCounter());
  }

  @Override
  public int hashCode() {

    return Objects.hash(getAlias(), getTitle(), getYear(),
            getDirectors(), getActors(), getCounter());
  }

  @Override
  public String toString() {
    return "Movie{"
            +
            "alias='"
            + alias
            + '\''
            +
            ", title='"
            + title
            + '\''
            +
            ", year="
            + year
            +
            ", directors="
            + directors
            +
            ", actors="
            + actors
            +
            ", counter="
            + counter
            +
            '}';
  }


}
