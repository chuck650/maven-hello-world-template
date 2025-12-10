package edu.pstcc.citc;

/**
 * A custom Exception thrown when a task being added ia already found in the collection.
 */
public class DuplicateTaskException extends Exception {

  private static final long serialVersionUID = 100L;

  /**
   * Constructor that accepts an error message.
   * 
   * @param message The custom error message
   */
  public DuplicateTaskException(String message) {
    super(message);
  }
}
