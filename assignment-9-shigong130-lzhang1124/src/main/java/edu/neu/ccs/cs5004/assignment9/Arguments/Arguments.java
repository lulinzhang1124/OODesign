package edu.neu.ccs.cs5004.assignment9.Arguments;

import java.util.HashMap;
import java.util.Map;

/**
 * Represents an abstract argument class.
 *
 */
public class Arguments implements Iarguments{

  private static final String OUTPUT_DIR = "--output-dir";
  private static final String CSV_FILE = "--csv-file";
  private final Map<String, String> userInput; // stores the user-input arguments
  private final StringBuilder errorMsg; // stores error message
  private String template;
  private String request;

  /**
   * Construct a new arguments.
   *
   * @param args - arguments input on command line.
   */
  public Arguments(String[]args) {
    userInput = new HashMap<>();

    userInput.put(OUTPUT_DIR, null);
    userInput.put(CSV_FILE, null);
    addRequest(args);
    errorMsg = new StringBuilder();
    parseArgs(args);


  }

  /**
   * Add request to userInput.
   *
   * @param args - string arguments we passed in.
   */
  private void addRequest(String[] args){
    int requestIndex = requestIndex(args);
    request = args[requestIndex];
    template = request + "-template";

    userInput.put(request,null);
    userInput.put(template,null);

  }

  /**
   *
   * Gets the index of the request in the inputs.
   *
   * @param args - input on command line.
   *
   * @return the index of the request.
   */
  private int requestIndex(String[] args){
    for(int i=0;i<args.length-1;i++){
      if(isHeader(args[i]) && isHeader(args[i+1])){
        return i;
      }
    }
      throw new IllegalArgumentException("No request found.");


  }

  /**
   * Convert arguments input into 'userInput'.
   *
   * @param args - arguments input on command line.
   */
  private void parseArgs(String[] args) {
    int i = 0;

    while (i < args.length) {

      String arg = args[i++];

      // if this arg is not a header, continue
      if (!isHeader(arg)) continue;

      // if this arg is a header but can not be recognized,
      // appends error message and continue
      if (!isRecognizable(arg)) {

        errorMsg.append(arg);
        errorMsg.append(" given is inconsistent with request: **");
        errorMsg.append(request);
        errorMsg.append("** therefore cannot be recognized\n");
        continue;
      }

      // if this argument is the last argument,
      // or if next argument is also a header, appends error message and continue
//      if (i >= args.length || isHeader(args[i])) {
//        errorMsg.append(arg);
//        errorMsg.append(" was given without providing appropriate argument\n");
//        continue;
//      } //TODO REVIEW :maybe we can delete these



      // validates the format of argument and puts it in user input map
      if (validate(arg, args[i])) {
        userInput.put(arg, args[i]);
      }
    }
  }

  /**
   * Check if current argument is starts with "--".
   *
   * @param arg - argument inputs on command line.
   * @return true if the argument starts with "--".
   */
  private boolean isHeader(String arg) {
    return arg.startsWith("--");
  }


  /**
   * Check if current argument is one of the keys in user input map/
   *
   * @param arg - argument inputs on command line.
   * @return true if the argument is one of the keys in user input map.
   */
  private boolean isRecognizable(String arg) {
    return userInput.containsKey(arg);
  }

  /**
   * Validates if a header ends with template and if it is a template,
   * check if argument given is a txt file.
   *
   * @param header - a header which starts with "--".
   * @param arg - a string argument.
   * @return true if header is not a template or header is a template and arg ends with txt.
   */
  private boolean validate(String header, String arg) {
    return !header.endsWith("template") || validateTemplate(header, arg);

  }


  /**
   * Check if a string template given is a txt file.
   *
   * @param header - a header which starts with "--".
   * @param template - a string argument.
   * @return true if template ends with txt.
   */
  private boolean validateTemplate(String header,String template) {
    if (template.endsWith(".txt")) {
      return true;
    } else {
      errorMsg.append(header);
      errorMsg.append(" is looking for a text file, but **");
      errorMsg.append(template);
      errorMsg.append("** does not provide a text filename\n");
      return false;
    }
  }

// eg. given letter-template email-template.txt
//  private boolean isSameCategory(String header, String template){
//    String[] headerCategory = header.split("-");
//    String[] templateCategory = template.split("-");
//
//    if(headerCategory[0].equals(templateCategory[0])){
//      return true;
//    }else{
//      errorMsg.append(template);
//      errorMsg.append(" is not consistant with header: " +header+" provided");
//      return false; //TODO REVIEW: not sure if this one is necessary： eg. given letter-template email-template.txt
//    }

 // }

  /**
   * Returns true if the required information -- request, template, output directory,
   * and csv file -- are provided in legal format.
   *
   * @return true if arguments are in legal format and false otherwise.
   */
  @Override
  public boolean isLegalFormat() {

    for(Map.Entry entry: userInput.entrySet()){
      if(entry.getValue()==null){
        return false;
      }
    }
    return true;
  }

  /**
   * Returns the error message.
   *
   * @return the error message if arguments are in illegal format; null if arguments are in
   * legal format.
   */
  @Override
  public String getErrorMessage() {
    if (isLegalFormat()) return null;
    if (errorMsg.toString().equals("")) {
      errorMsg.append("Some required arguments are missing! Please see the example below.\n");
    }
    return "Error:\n\n" + errorMsg.toString() + "\n" + usageMsg();
  }

  /**
   * Gets the usage message based on different concrete class.
   *
   * @return - a string served as usage message.
   */
  private String usageMsg(){
     return "Usage: \n\n"
             + "--<request>                only generate text baded on requests\n\n"
             + "--<request>-template <file>  accepts a filename that holds the template\n"
             + "                          Required if --(request) is used\n\n"
             + "--output-dir <path>       accepts the name of a folder, all output is placed\n"
             + "                          in this folder\n\n"
             + "--csv-file <path>         accepts the name of the csv file to process\n\n"

             + "For example:\n"
             + "--email --email-template email-template.txt " +
             "--output-dir emails --csv-file customer.csv\n"
             + "--letter --letter-template letter-template.txt " +
             "--output-dir letters --csv-file customer.csv\n";
   }


  /**
   * Returns the name of a folder that will store all output; null if arguments are
   * not in legal format.
   * @return the name of a folder that will store all output; null if arguments are
   * not in legal format.
   */
  @Override
  public String getOutputDir() {
    if (!isLegalFormat()) return null;
    return userInput.get(OUTPUT_DIR);
  }

  /**
   * Returns the name of csv file; null if arguments are not in legal format
   *
   * @return the name of csv file; null if arguments are not in legal format
   */
  @Override
  public String getCsvFile() {
    if (!isLegalFormat()) return null;
    return userInput.get(CSV_FILE);
  }

  /**
   * Returns a filename that holds the template; null if arguments are not in legal format.
   *
   * @return a filename that holds the template; null if arguments are not in legal format.
   */
  @Override
  public String getTemplate() {
    if (!isLegalFormat()) return null;
    return userInput.get(template);
  }


}
