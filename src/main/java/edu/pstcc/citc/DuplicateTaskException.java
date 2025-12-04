package edu.pstcc.citc;

public class DuplicateTaskException extends Exception {

  /**
   * Constructor that accepts an error message.
   * @param message
   */
  public DuplicateTaskException(String message) {
    super(message);
  }
}
