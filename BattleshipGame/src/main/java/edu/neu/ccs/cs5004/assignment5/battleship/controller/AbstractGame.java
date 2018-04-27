package edu.neu.ccs.cs5004.assignment5.battleship.controller;

/**
 * Represent an abstract game.
 */
public abstract class AbstractGame implements Game {

  protected Computer computer;
  protected Human human;

  /**
   * Constructor of AbstractGame.
   */
  public AbstractGame() {
    computer = new Computer();
    human = new Human();
  }

  /**
   * Getter fot the computer.
   *
   * @return the computer player fot the game.
   */
  public Computer getComputer() {
    return computer;
  }

  /**
   * Getter for the human.
   *
   * @return the human player for the game.
   */
  public Human getHuman() {
    return human;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }

    AbstractGame that = (AbstractGame) obj;

    if (getComputer() != null ? !getComputer().equals(that.getComputer()) :
            that.getComputer() != null) {
      return false;
    }
    return getHuman() != null ? getHuman().equals(that.getHuman()) : that.getHuman() == null;
  }

  @Override
  public int hashCode() {
    int result = getComputer() != null ? getComputer().hashCode() : 0;
    result = 31 * result + (getHuman() != null ? getHuman().hashCode() : 0);
    return result;
  }
}
