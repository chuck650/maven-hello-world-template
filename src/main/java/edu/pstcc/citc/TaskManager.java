package edu.pstcc.citc;

import java.util.HashMap;
import java.util.Map;

/**
 * Manages tasks in an in-memory store.
 */
public class TaskManager {
  private Map<Long, Task> taskMap = new HashMap<>();
  private Long nextTaskId = 1L;

  /**
   * Adds a new task to the task store.
   * 
   * @param task The task to be added.
   */
  public Task addTask(Task task) throws DuplicateTaskException {
    // Validate the input before processing it
    if (task == null || task.getTitle() == null || task.getTitle().trim().isEmpty()) {
      throw new IllegalArgumentException("Task and task title cannot be null or empty.");
    }

    // Check for duplicate titles
    for (Task t : taskMap.values()) {
      if (t.getTitle().equalsIgnoreCase(task.getTitle())) {
        throw new DuplicateTaskException("A task with the title '" + task.getTitle() + "' already exists.");
      }
    }

    // Assign a unique ID and add the task to our in-memory store
    task.setId(nextTaskId);

    // Add the task to the map
    taskMap.put(task.getId(), task);
    
    // Increment the ID for the next task
    nextTaskId++; 
    
    // Return the task with its assigned ID
    return task;
  }

  /**
   * Retrieves all tasks from the store.
   * 
   * @return A list of all tasks.
   */
  public Map<Long, Task> getTasks() {
    // Return a copy of the task map to prevent external modification
    return taskMap;
  }

  /**
   * Find the existing task in taskStore with the same ID as
   * updatedTask and replace it updatedTask.
   * 
   * @param updatedTask
   */
  public void updateTask(Task updatedTask) throws TaskNotFoundException {
    // Update the task in the store
    if (taskMap.containsKey(updatedTask.getId())) {
      taskMap.put(updatedTask.getId(), updatedTask);
      // System.out.println("Task in map updated: " + updatedTask.getTitle());
      return;
    }

    // If we reach here, the task was not found
    throw new TaskNotFoundException("Task with ID " + updatedTask.getId() + " not found");
  }

  /**
   * Deletes the task with the given ID from the store.
   * 
   * @param taskId
   */
  public void deleteTask(Long taskId) throws TaskNotFoundException {
    // If key not found, throw exception
    if (!taskMap.containsKey(taskId)) {
      throw new TaskNotFoundException("Task with ID " + taskId + " not found.");
    } 

    // Find the task by ID and remove it from the store
    for (Task t : taskMap.values()) {
      if (t.getId().equals(taskId)) {
        taskMap.remove(t.getId());
        System.out.println("Task deleted: " + t.getTitle());
        return;
      }
    }

    // Find the task in the map and remove it
    if (taskMap.containsKey(taskId)) {
      Task t = taskMap.get(taskId);
      taskMap.remove(taskId);
      System.out.println("Task deleted from map: " + t.getTitle());
      return;
    }
    System.out.println("Task with ID " + taskId + " not found.");
  }

  /**
   * Gets the task with the given ID.  
   * @param taskId
   * @return
   * @throws TaskNotFoundException
   */
  public Task getTask(Long taskId) throws TaskNotFoundException {
    // If key not found, throw exception
    if (!taskMap.containsKey(taskId)) {
      throw new TaskNotFoundException("Task with ID " + taskId + " not found.");
    } 
    return taskMap.get(taskId);
  }
}
