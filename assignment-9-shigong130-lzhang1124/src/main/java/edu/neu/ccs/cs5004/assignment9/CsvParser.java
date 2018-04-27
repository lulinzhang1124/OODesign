package edu.neu.ccs.cs5004.assignment9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CsvParser implements IcsvParser {

  private static final String CSV_SPLIT = ",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)"; // regular expression to split the line
  private List<List<String>> tokens;

  /**
   * Constructs a new CSVParser object. Parses the input csv string.
   * @param csv a string of a csv file
   */
  public CsvParser(String csv) {
    parseCSV(csv);
  }

  // for each line in the string, parses the line to tokens and stores as a list of strings.
  private void parseCSV(String csv) {
    tokens = new ArrayList<>();
    String[] lines = csv.split(System.getProperty("line.separator"));
    for (int i = 0; i < lines.length; i++) {
      String line = lines[i];

      //split and delete quote
      String[] values = deleteQuote(line.split(CSV_SPLIT));
      tokens.add(Arrays.asList(values));
    }
  }
  private String[] deleteQuote(String[] strs){

    for(int i = 0; i < strs.length; i++){
      if(strs[i].charAt(0) == '"' && strs[i].charAt(strs[i].length()-1) == '"'){
        strs[i] = strs[i].substring(1,strs[i].length()-1);
      }
    }
    return strs;
  }

  /**
   * Returns a list of lists of string, the strings are tokens in the original csv file.
   * @return a list of lists of string
   */
  @Override
  public List<List<String>> getTokens() {
    return tokens;
  }

}
