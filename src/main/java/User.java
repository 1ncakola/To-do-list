public class User {
    private String name;
    private TaskList taskList;

    public User(String name) {
        this.name = name;
        this.taskList = new TaskList();
    }

    public String getName() {
        return name;
    }

    public void addTask(Task task) {
        taskList.addTask(task);
    }

    public void markTaskAsCompleted(String description) {
        taskList.markTaskAsCompleted(description);
    }

    public void printTasks() {
        System.out.println("Tasks for " + name + ":");
        taskList.printTasks();
    }
}
