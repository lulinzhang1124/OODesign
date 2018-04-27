package edu.neu.ccs.cs5004.assignment9;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import edu.neu.ccs.cs5004.assignment9.Arguments.Arguments;
//import edu.neu.ccs.cs5004.assignment9.Arguments.EmailArguments;
import edu.neu.ccs.cs5004.assignment9.Arguments.Iarguments;
//import edu.neu.ccs.cs5004.assignment9.Arguments.LetterArguments;
import edu.neu.ccs.cs5004.assignment9.IO_Processor.FileWriter;

/**
 * Represents a text generator class.
 */
public class txtGenerator {

  private Iarguments arguments;

  /**
   * Constructs a txtGenerator.
   *
   * @param arguments arguments
   */
  public txtGenerator(Iarguments arguments) throws Exception {
    this.arguments = arguments;
    startTextGeneration();
  }


  private void startTextGeneration() throws Exception {
    ITemplate template = new Template(arguments.getTemplate());
    Idata clientsInfo = new DataInfo(arguments.getCsvFile());

    Processor processor = new InfoProcessor();

    List<String> headers = clientsInfo.getHeaders();

    List<Idocument> documents = new ArrayList<>();

    while (clientsInfo.hasNext()) {
      processor.updateProcessor(headers,clientsInfo.nextLine());
      documents.add(template.toDocument(processor));
    }

    saveFilesGenerated(documents);

  }

  // saves files to the desired output directory.
  private void saveFilesGenerated(List<Idocument> documents) throws IOException {
    File outputDir = new File(arguments.getOutputDir());
    if (!outputDir.mkdir()) {
      throw new IllegalArgumentException(outputDir + " already exists!");
    }
    for (int i = 0; i < documents.size(); i++) {
      File file = new File(outputDir, "text" + (i + 1) + ".txt");
      FileWriter.writeStringToFile(file, documents.get(i).toString());
    }
  }



  /**
   * Reads in the command-line arguments from user. Creates a arguments to check the
   * format of arguments. Prints to console the error message if the arguments are not
   * in legal format. Otherwise created a TxtGenerator with the arguments object.
   *
   * @param args the command-line arguments
   */
  public static void main(String[] args) throws Exception {

//   List argsList = Arrays.asList(args); //TODO REVIEW
//    Iarguments arguments;
//
//   if(argsList.contains("--email")){
//     arguments = new EmailArguments(args);
//
//   }else if (argsList.contains("--letter")){
//
//     arguments = new LetterArguments(args);
//   }else{
//     throw new IllegalArgumentException("Arguments given are neither email nor letter.");
//   } //TODO NEED REVIEW: feel it can be better wrote

     Iarguments arguments = new Arguments(args);



    if (!arguments.isLegalFormat()) {
      System.out.println(arguments.getErrorMessage());
      throw new IllegalArgumentException("Arguments are in wrong format.");
    }
    new txtGenerator(arguments);
  }


}
