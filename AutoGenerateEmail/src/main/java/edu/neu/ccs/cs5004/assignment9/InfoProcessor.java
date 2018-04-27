package edu.neu.ccs.cs5004.assignment9;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InfoProcessor implements Processor {

    private final Map<String, String> map = new HashMap<>();

    public InfoProcessor(){}

    /**
     * Constructs a new InfoProcessor with headers and corresponding passenger information.
     * @param headers a list of strings
     * @param info s list of strings
     */
    public void updateProcessor(List<String> headers, List<String> info) {

      for (int i = 0; i < headers.size(); i++) {
        map.put(headers.get(i), info.get(i));
      }
    }

    /**
     * Returns the value to the corresponding placeholder.
     * @param placeholder a string
     * @return the value to the corresponding placeholder, null if the placeholder is not found.
     */
    @Override
    public String getValue(String placeholder) {
      return map.get(placeholder);
    }

}
