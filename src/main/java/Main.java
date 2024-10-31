import java.util.Scanner;

public class Main {
    private static User[] users = new User[10];
    private static int userCount = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nTo-Do List Manager");
            System.out.println("1. Create User");
            System.out.println("2. Add Task to User");
            System.out.println("3. Mark Task as Completed");
            System.out.println("4. View User Tasks");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter user name: ");
                    String userName = scanner.nextLine();
                    users[userCount++] = new User(userName);
                    System.out.println("User " + userName + " created.");
                    break;
                case 2:
                    System.out.print("Enter user name: ");
                    userName = scanner.nextLine();
                    User user = findUserByName(userName);
                    if (user != null) {
                        System.out.print("Enter task description: ");
                        String taskDescription = scanner.nextLine();
                        user.addTask(new Task(taskDescription));
                        System.out.println("Task added.");
                    } else {
                        System.out.println("User not found.");
                    }
                    break;
                case 3:
                    System.out.print("Enter user name: ");
                    userName = scanner.nextLine();
                    user = findUserByName(userName);
                    if (user != null) {
                        System.out.print("Enter task description to mark as completed: ");
                        String completedTaskDescription = scanner.nextLine();
                        user.markTaskAsCompleted(completedTaskDescription);
                        System.out.println("Task marked as completed.");
                    } else {
                        System.out.println("User not found.");
                    }
                    break;
                case 4:
                    System.out.print("Enter user name: ");
                    userName = scanner.nextLine();
                    user = findUserByName(userName);
                    if (user != null) {
                        user.printTasks();
                    } else {
                        System.out.println("User not found.");
                    }
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        } while (choice != 5);

        scanner.close();
    }

    private static User findUserByName(String name) {
        for (int i = 0; i < userCount; i++) {
            if (users[i].getName().equals(name)) {
                return users[i];
            }
        }
        return null;
    }
}
