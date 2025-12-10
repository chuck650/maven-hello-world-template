package edu.pstcc.citc;

/**
 * A Testing Application for Task Manager and associated classes
 */
public class App {

    /**
     * The default constructor for the Application
     */
    public App() {}
    
    /**
     * Main method that prints Hello World.
     *
     * @param args Command-line arguments
     */
    public static void main(String[] args) {

        // Create the one and only task manager
        TaskManager tm = new TaskManager();

        // 1. CREATE Task objects in TaskManager

        System.out.println("---\n📋 Creating tasks...");

        // Add new Task objects to the TaskManager with error handling:

        // Add a new Task that should work
        try {
            Task t = tm.addTask(new Task("Sample Task1", "This is task1."));
            System.out.println("  ✓ Task " + t.getId() + " added: " + t.getTitle());
        } catch (IllegalArgumentException e) {
            System.err.println("  ✗ Error adding task: " + e.getMessage());
        } catch (DuplicateTaskException e) {
            System.err.println("  ✗ Error adding task: " + e.getMessage());
        }

        // Add a second new Task object that should work
        try {
            Task t = tm.addTask(new Task("Sample Task Dupe", "This is a duplicate task."));
            System.out.println("  ✓ Task " + t.getId() + " added: " + t.getTitle());
        } catch (IllegalArgumentException e) {
            System.err.println("  ✗ Error adding task: " + e.getMessage());
        } catch (DuplicateTaskException e) {
            System.err.println("  ✗ Error adding task: " + e.getMessage());
        }

        // Add a third new Task object that should fail with a DuplicateTaskException
        try {
            Task t = tm.addTask(new Task("Sample Task Dupe", "This is a duplicate task."));
            System.out.println("  ✓ Task " + t.getId() + " added: " + t.getTitle());
        } catch (IllegalArgumentException e) {
            System.err.println("  ✗ Error adding task: " + e.getMessage());
        } catch (DuplicateTaskException e) {
            System.err.println("  ✗ Error adding task: " + e.getMessage());
        }

        // Add a fourth null Task object that should fail with an
        // IllegalArgumentException
        try {
            Task t = tm.addTask(null);
            System.out.println("  ✓ Task " + t.getId() + " added: " + t.getTitle());
        } catch (IllegalArgumentException e) {
            System.err.println("  ✗ Error adding task: " + e.getMessage());
        } catch (DuplicateTaskException e) {
            System.err.println("  ✗ Error adding task: " + e.getMessage());
        }

        // 2. RETRIEVE Task objects from TaskManager

        System.out.println("---\n📋 Retrieving tasks...");

        // Loop over all Task objects in the task manager and print the Title and
        // Description
        System.out.println("  Looping through all Tasks:");
        for (Task t : tm.getTasks().values()) {
            System.out.println("    Task:");
            System.out.println("      ✓ Title: " + t.getTitle());
            System.out.println("      ✓ Description: " + t.getDescription());
            System.out.println();
        }

        // Find a Task by ID and print its title
        System.out.println("  Finding a Task by ID:");
        try {
            for (Long id : tm.getTasks().keySet()) {
                System.err.println("    ✓ Task " + id + ": " + tm.getTask(id).getTitle());
            }
        } catch (TaskNotFoundException e) {
            System.err.println("    ✗ Error retrieving task: " + e.getMessage());
        }

        // 3. UPDATE a Task in the TaskManager

        System.out.println("---\n📋 Updating tasks...");

        // Update duplicate task that was successfully added to the task manager
        for (Task t : tm.getTasks().values()) {
            if ("Sample Task Dupe".equals(t.getTitle())) {
                t.setTitle("Sample Task " + t.getId());
                t.setDescription("This is the UPDATED duplicate task.");
                try {
                    tm.updateTask(t);
                    System.out.println("  ✓ Task updated: " + t.getTitle());
                } catch (TaskNotFoundException e) {
                    System.err.println("  ✗ Error updating task: " + e.getMessage());
                }
                break;
            }
        }

        // 4. DELETE a Task in the TaskManager

        System.out.println("---\n📋 Deleting tasks...");

        // Delete task with id: 2
        try {
            Long idToDelete = 2L;
            tm.deleteTask(idToDelete);
            System.out.println("  ✓ Task " + idToDelete + " has been deleted successfully.");
        } catch (TaskNotFoundException e) {
            System.err.println("  ✗ Error deleting task: " + e.getMessage());
        }
    }
}
