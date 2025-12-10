package edu.pstcc.citc;

import java.time.LocalDateTime;

/**
 * Represents a task with various private attributes, public getter/setter methods,
 * and behaviors. Used to manage tasks in a system.  Can be used standalone or stored 
 * with other tasks in a collection within a TaskManager.
 * 
 * @author Chuck Nelson
 * @since 1.0
 */
public class Task {
    // Fields based on the UML diagram
    private Long id;
    private String title;
    private String description;
    private TaskStatus status;
    private Priority priority;
    private LocalDateTime createdDate;
    private LocalDateTime dueDate;
    private LocalDateTime completedDate;

    // Constructors

    /**
     * Default constructor
     */
    public Task() {
        //  Default constructor
    }

    /**
     * Parameterized constructor
     * 
     * @param title This is the title of the task.
     * @param description This is the description of the task.
     */
    public Task(String title, String description) {
        this.title = title;
        this.description = description;
        this.createdDate = LocalDateTime.now();
        this.status = TaskStatus.TODO; // Default status
    }

    // Method stubs for getters and setters
    
    /**
     * Sets the ID of the task.
     * 
     * @param id The unique ID of the task.
     */
    public void setId(Long id) {
        if (id.longValue() <= 0) {
            throw new IllegalArgumentException("ID must be positive.");
        }
        this.id = id;
    };

    /**
     * Gets the ID of the task.
     * 
     * @return Long
     */
    public Long getId() {
        return this.id;
    }

    /**
     * Gets the title of the task.
     * 
     * @return String
     */
    public String getTitle() {
        return this.title;
    }

    /**
     * Sets the title of the task.
     * 
     * @param title The unique Title of the task.  Must not be null nor duplicate any other task Title or an IllegalArgumentException will be thrown.
     */
    public void setTitle(String title) {
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("Title cannot be null or empty.");
        }
        this.title = title;
    }

    /**
     * Gets the description of the task.
     * 
     * @return String
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * Sets the description of the task.
     * 
     * @param description The short description of the task.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets the status of the task.
     * @return An enum value of type TaskStatus
     */
    public TaskStatus getStatus() {
        return this.status;
    }

    /**
     * Sets the status of the task.
     * @param status One of the allowable task Status codes from TaskStatus
     */
    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    /**
     * Gets the priority of the task.
     * @return An enum value of type Priority
     */
    public Priority getPriority() {
        return this.priority;
    }

    /**
     * Sets the priority of the task.
     * @param priority One of the allowable priority codes from Priority
     */
    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    /**
     * Gets the created date of the task.
     * @return The created date as a LocalDateTime object.
     */
    public LocalDateTime getCreatedDate() {
        return this.createdDate;
    }

    /**
     * Sets the created date of the task.
     * @param date Any valid date earlier than now as a LocalDateTime
     */
    public void setCreatedDate(LocalDateTime date) {
        // Don't allow null nor future created dates
        if (date == null || date.isAfter(LocalDateTime.now())){
            throw new IllegalArgumentException("Invalid Task CreatedDate:" + date);
        }
        this.createdDate = date;
    }

    /**
     * Gets the due date of the task.
     * @return The due date as a LocalDateTime object.
     */
    public LocalDateTime getDueDate() {
        return this.dueDate;
    }

    /**
     * Sets the due date of the task.
     * @param date Any valid date or null to clear
     */
    public void setDueDate(LocalDateTime date) {
        this.dueDate = date;
    }

    /**
     * Gets the completed date of the task.
     * @return The completed date as a LocalDateTime object, or null if the task is not completed.
     */
    public LocalDateTime getCompletedDate() {
        return this.completedDate;
    }

    /**
     * Sets the completed date of the task.
     * @param date Any valid date earlier than now as a LocalDateTime
     */
    public void setCompletedDate(LocalDateTime date) {
        // Don't allow completion dates in the future, but do allow nullifying the completion date
        if (date != null && date.isAfter(LocalDateTime.now())){
            throw new IllegalArgumentException("Invalid Task CreatedDate:" + date);
        }
        this.completedDate = date;
    }

    // Method stubs for other business logic

    /**
     * Checks if the task is overdue.
     * @return The result of the check as a boolean
     */
    public boolean isOverdue() {
        // If there is no due date, then it can't be overdue
        if (this.dueDate == null){
            return false;
        }
        // If there is a completion date, then it can't be overdue
        if (this.completedDate != null){
            return false;
        }
        // else, check if today is past the due date
        return this.dueDate.isBefore(LocalDateTime.now());
    }

    /**
     * Marks the task as completed.
     */
    public void complete() {
        this.status = TaskStatus.COMPLETED;
        this.completedDate = LocalDateTime.now();
    }
}