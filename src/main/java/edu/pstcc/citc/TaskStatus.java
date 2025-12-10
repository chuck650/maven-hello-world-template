package edu.pstcc.citc;

/**
 * The allowable status codes for a Task.
 */
public enum TaskStatus {
  /**
   * On the list, but not yet started.
   */
  TODO,
  /**
   * Work has begun on the task.
   */
  IN_PROGRESS,
  /**
   * Work on the task has been finished.
   */
  COMPLETED,
  /**
   * The task was cancelled and no further work will be done on it.
   */
  CANCELLED
}
