package edu.pstcc.citc;

/**
 * A custom Exception thrown when a task is not found in the collection.
 */
public class TaskNotFoundException extends Exception {

  private static final long serialVersionUID = 100L;

  /**
   * Constructor that accepts an error message.
   * 
   * @param message The custom error message
   */
  public TaskNotFoundException(String message) {
    super(message);
  }

}
