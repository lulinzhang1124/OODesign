package edu.neu.ccs.cs5004.assignment9;

public class Document implements Idocument {
  private final String content;


  public Document(String content) {
    this.content = content;
  }

  @Override
  public String toString() {
    return content;
  }
}
