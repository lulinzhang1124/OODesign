package edu.neu.ccs.cs5004.assignment5.battleship.controller;


import edu.neu.ccs.cs5004.assignment5.battleship.enums.Number;
import edu.neu.ccs.cs5004.assignment5.battleship.viewer.Printer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;


/**
 * Represents a read console to get the input data.
 */
public class ReadConsole {
  private String input;
  private BufferedReader reader = new BufferedReader(
          new InputStreamReader(System.in, StandardCharsets.UTF_8));

  /**
   * Default constructor.
   */
  public ReadConsole() {
    //default
  }

  /**
   * Constructor for unit test.
   *
   * @param testReader - reader for test.
   */
  public ReadConsole(BufferedReader testReader) {
    reader = testReader;
  }

  /**
   * Get the input string through bufferReader.
   *
   * @param args - command-line arguments.
   */
  public void readFromConsole(String[] args) throws UserInteruptException {
    try {

      input = reader.readLine();

      if ("q".equals(input)) {
        Printer.CONSOLE_PRINTER.printMessage("exit");
        throw new UserInteruptException();
      }

    } catch (IOException ioe) {
      ioe.printStackTrace();
    }
  }

  public static class UserInteruptException extends Exception {

  }

  /**
   * Printer the wrong input message.
   */
  public static void wrongInput() {
    Printer.CONSOLE_PRINTER.printMessage("wrongInput");
  }

  /**
   * Get the input string.
   *
   * @return the input string.
   */
  public String getInput() {
    return input;
  }

  /**
   * Get the valid input location.
   *
   * @return the int[] represents the cell location.
   */
  public int[] inputLocation() throws UserInteruptException {

    int[] location = new int[2];

    boolean factor = true;

    while (factor == true) {
      readFromConsole(null);

      String input = getInput();
      char[] str = input.toCharArray();

      switch (input.length()) {
        case 2:
          if (str[0] - 'A' >= 0 && str[0] <= 'J' && str[1] >= '1' && str[1] <= '9') {
            location[0] = (int) str[0] - 'A';
            location[1] = (int) str[1] - '1';
            return location;
          } else {
            ReadConsole.wrongInput();
          }
          break;

        case 3:
          if (str[0] - 'A' >= 0 && str[0] <= 'J' && str[1] >= '1' && str[2] <= '0') {
            location[0] = (int) str[0] - 'A';
            location[1] = Number.NINE.getValue(); //we get 10 but the index is 9
            return location;
          } else {
            ReadConsole.wrongInput();
          }
          break;

        default:
          ReadConsole.wrongInput();

      }
    }
    return location;

  }

  /**
   * Get the invalid integer for the given range.
   *
   * @param start the start of the range
   * @param end   the end of the range
   * @return the valid integer
   */
  public int inputNum(int start, int end) throws UserInteruptException {
    while (true) {
      readFromConsole(null);
      if (getInput().length() == Number.ONE.getValue() && getInput().charAt(Number.ZERO.getValue())
              >= start + Number.FORTY_EIGHT.getValue()
              && getInput().charAt(Number.ZERO.getValue()) <= end + Number.FORTY_EIGHT.getValue()) {
        return Integer.parseInt(getInput());
      } else {
        ReadConsole.wrongInput();
      }
    }
  }

  @Override
  public boolean equals(Object other) {
    if (other == null) {
      return false;
    }

    if (this == other) {
      return true;
    }


    return this.getClass() == other.getClass();
  }


  @Override
  public int hashCode() {
    return 51;
  }

  @Override
  public String toString() {
    return "ReadConsole{}";
  }
}
