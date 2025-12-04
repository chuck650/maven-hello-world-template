package edu.pstcc.citc;

public class TaskNotFoundException extends Exception {
  
  /**
     * Constructor that accepts an error message.
     * @param message A description of the error.
     */
  public TaskNotFoundException(String message) {
    super(message);
  }

}
