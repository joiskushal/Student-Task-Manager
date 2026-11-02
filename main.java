
import java.util.ArrayList;
import java.util.Scanner;

class Task {
    String name;
    boolean completed;

    Task(String name) {
        this.name = name;
        this.completed = false;
    }
}

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Task> tasks = new ArrayList<>();

        while (true) {

            System.out.println("\n===== STUDENT TASK MANAGER =====");
            System.out.println("1. Add Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Complete Task");
            System.out.println("4. Delete Task");
            System.out.println("5. Exit");

            System.out.print("Enter choice: ");
            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {

                case 1:
                    System.out.print("Enter task name: ");
                    String name = sc.nextLine();
                    tasks.add(new Task(name));
                    System.out.println("Task added successfully!");
                    break;

                case 2:
                    if (tasks.isEmpty()) {
                        System.out.println("No tasks available.");
                    } else {
                        for (int i = 0; i < tasks.size(); i++) {
                            Task t = tasks.get(i);
                            String status = t.completed ? "Completed" : "Pending";
                            System.out.println((i + 1) + ". " + t.name + " - " + status);
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter task number: ");
                    int complete = Integer.parseInt(sc.nextLine());

                    if (complete >= 1 && complete <= tasks.size()) {
                        tasks.get(complete - 1).completed = true;
                        System.out.println("Task completed!");
                    } else {
                        System.out.println("Invalid task number.");
                    }
                    break;

                case 4:
                    System.out.print("Enter task number: ");
                    int delete = Integer.parseInt(sc.nextLine());

                    if (delete >= 1 && delete <= tasks.size()) {
                        tasks.remove(delete - 1);
                        System.out.println("Task deleted!");
                    } else {
                        System.out.println("Invalid task number.");
                    }
                    break;

                case 5:
                    System.out.println("Thank you for using Student Task Manager!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
