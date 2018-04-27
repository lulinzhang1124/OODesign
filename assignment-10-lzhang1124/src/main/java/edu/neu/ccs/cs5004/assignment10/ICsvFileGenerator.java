package edu.neu.ccs.cs5004.assignment10;

import java.io.IOException;
import java.util.List;

/**
 * Represents a csv file generator.
 */
public interface ICsvFileGenerator {

  /**
   * Generates a csv file with the provided file name for the results of simulation.
   *
   * @param results   the results of simulation
   * @param outputDir the csv file name
   * @throws IOException if there exists an I/O failure
   */
  void generateCsvFile(List<IResult> results, String outputDir) throws IOException;
}
