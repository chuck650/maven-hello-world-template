package edu.pstcc.citc;

import java.time.LocalDateTime;

/**
 * Represents a task with various attributes and behaviors.
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
    public Task() {
        // Default constructor
    }

    /**
     * Parameterized constructor
     * 
     * @param title
     * @param description
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
     * @param id
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
     * @return
     */
    public String getTitle() {
        return this.title;
    }

    /**
     * Sets the title of the task.
     * 
     * @param title
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
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets the status of the task.
     * @return TaskStatus
     */
    public TaskStatus getStatus() {
        return this.status;
    }

    /**
     * Sets the status of the task.
     * @param status
     */
    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    /**
     * Gets the priority of the task.
     * @return Priority
     */
    public Priority getPriority() {
        return this.priority;
    }

    /**
     * Sets the priority of the task.
     * @param priority
     */
    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    /**
     * Gets the created date of the task.
     * @return LocalDateTime
     */
    public LocalDateTime getCreatedDate() {
        return this.createdDate;
    }

    /**
     * Sets the created date of the task.
     * @param date
     */
    public void setCreatedDate(LocalDateTime date) {
        this.createdDate = date;
    }

    /**
     * Gets the due date of the task.
     * @return LocalDateTime
     */
    public LocalDateTime getDueDate() {
        return this.dueDate;
    }

    /**
     * Sets the due date of the task.
     * @param date
     */
    public void setDueDate(LocalDateTime date) {
        this.dueDate = date;
    }

    /**
     * Gets the completed date of the task.
     * @return LocalDateTime
     */
    public LocalDateTime getCompletedDate() {
        return this.completedDate;
    }

    /**
     * Sets the completed date of the task.
     * @param date
     */
    public void setCompletedDate(LocalDateTime date) {
        this.completedDate = date;
    }

    // Method stubs for other business logic

    /**
     * Checks if the task is overdue.
     * @return boolean
     */
    public boolean isOverdue() {
        return this.dueDate.isBefore(LocalDateTime.now()) && !this.completedDate.equals(this.dueDate);
    }

    /**
     * Marks the task as completed.
     */
    public void complete() {
        this.status = TaskStatus.COMPLETED;
        this.completedDate = LocalDateTime.now();
    }
}