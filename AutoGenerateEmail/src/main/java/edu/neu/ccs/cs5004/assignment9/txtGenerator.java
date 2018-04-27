package edu.neu.ccs.cs5004.assignment9;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import edu.neu.ccs.cs5004.assignment9.Arguments.Arguments;
import edu.neu.ccs.cs5004.assignment9.Arguments.Iarguments;
import edu.neu.ccs.cs5004.assignment9.IO_Processor.FileWriter;

public class txtGenerator {

  private Iarguments arguments;

  /**
   * Constructs a new EmailAutomationTool object with a arguments. Starts the
   * email generations.
   *
   * @param arguments a arguments
   */
  public txtGenerator(Iarguments arguments) throws Exception {
    this.arguments = arguments;
    startEmailGeneration();
  }

  // initializes the evaluator container by pushing all sources of evaluators.
  // For each passenger, generates a new email and stores email in a email list.
  // After all emails have been generated, either saves to a folder or sends to
  // passengers, depending on the mode that user selected.
  private void startEmailGeneration() throws Exception {
    ITemplate template = new Template(arguments.getTemplate());
    Idata clientsInfo = new DataInfo(arguments.getCsvFile());

    Processor processor = new InfoProcessor();

    List<String> headers = clientsInfo.getHeaders();

    List<Idocument> documents = new ArrayList<>();

    while (clientsInfo.hasNext()) {
      processor.updateProcessor(headers,clientsInfo.nextLine());
      documents.add(template.toDocument(processor));
    }

    saveEmails(documents);

  }

  // saves emails to the desired output directory,
  private void saveEmails(List<Idocument> documents) throws IOException {
    File outputDir = new File(arguments.getOutputDir());
    if (!outputDir.mkdir()) {
      throw new IllegalArgumentException(outputDir + " already exists!");
    }
    for (int i = 0; i < documents.size(); i++) {
      File file = new File(outputDir, "email" + (i + 1) + ".txt");
      FileWriter.writeStringToFile(file, documents.get(i).toString());
    }
  }



  /**
   * Reads in the command-line arguments from user. Creates a arguments to check the
   * format of arguments. Prints to console the error message if the arguments are not
   * in legal format. Otherwise created a EmailAutomationTool with the arguments object.
   *
   * @param args the command-line arguments
   */
  public static void main(String[] args) throws Exception {
    Iarguments arguments = new Arguments(args);
    if (!arguments.isLegalFormat()) {
      System.out.println(arguments.getErrorMessage());
      throw new IllegalArgumentException("Arguments are in wrong format.");
    }
    new txtGenerator(arguments);
  }


}
