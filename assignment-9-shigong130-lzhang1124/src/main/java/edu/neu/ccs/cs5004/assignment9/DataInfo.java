package edu.neu.ccs.cs5004.assignment9;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

import edu.neu.ccs.cs5004.assignment9.IO_Processor.CsvReader;

public class DataInfo implements Idata{
  private int count = 0; // records the number of passenger called by nextPassenger()
  private List<String> headers;
  private List<List<String>> info;

  /**
   * Parses the csv file using a csv parser. Builds passenger information based on the
   * results of csv parser.
   *
   * @param csvFileName the name of a csv file
   */
  public DataInfo(String csvFileName) throws IOException {
    CsvParser CsvParser = new CsvParser(CsvReader.fileReader(csvFileName));
    buildData(CsvParser.getTokens());
  }

  private void buildData(List<List<String>> tokens) {
    headers = tokens.get(0);
    info = tokens.subList(1, tokens.size());
  }

  /**
   * Returns the headers in csv file.
   * @return headers in csv file
   */
  @Override
  public List<String> getHeaders() {
    return headers;
  }

  /**
   * Returns true if there exists next passenger.
   * @return true if there exists next passenger, false otherwise
   */
  @Override
  public boolean hasNext() {
    return count < info.size();
  }


  @Override
  public List<String> nextLine() {
    return info.get(count++);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    DataInfo dataInfo = (DataInfo) o;
    return count == dataInfo.count &&
            Objects.equals(getHeaders(), dataInfo.getHeaders()) &&
            Objects.equals(info, dataInfo.info);
  }

  @Override
  public int hashCode() {

    return Objects.hash(count, getHeaders(), info);
  }

  @Override
  public String toString() {
    return "DataInfo{" +
            "count=" + count +
            ", headers=" + headers +
            ", info=" + info +
            '}';
  }
}
