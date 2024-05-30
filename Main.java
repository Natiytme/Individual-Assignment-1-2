 import java.util.Scanner;

class Task {
    private String title;
    private String description;
    private boolean completed;

    public Task(String title, String description) {
        this.title = title;
        this.description = description;
        this.completed = false;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void markCompleted() {
        this.completed = true;
    }
}

class Node {
    public Task task;
    public Node next;

    public Node(Task task) {
        this.task = task;
        this.next = null;
    }
}

class ToDoList {
    private Node head;

    public ToDoList() {
        this.head = null;
    }

    public void addTask(Task task) {
        Node newNode = new Node(task);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public void markTaskAsCompleted(String title) {
        Node current = head;
        while (current != null) {
            if (current.task.getTitle().equals(title)) {
                current.task.markCompleted();
                break;
            }
            current = current.next;
        }
    }

    public void viewTasks() {
        Node current = head;
        while (current != null) {
            System.out.println("Title: " + current.task.getTitle());
            System.out.println("Description: " + current.task.getDescription());
            System.out.println("Completed: " + current.task.isCompleted());
            System.out.println("-----------------------");
            current = current.next;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        ToDoList todoList = new ToDoList();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter task title or 'q' to quit, 'v' to view to-do list: ");
            String title = scanner.nextLine();
            if (title.equals("q")) {
                break;
            } else if (title.equals("v")) {
                todoList.viewTasks();
                System.out.print("Enter task title to mark as completed or 'q' to quit: ");
                String completion = scanner.nextLine();
                if (completion.equals("q")) {
                    break;
                }
                todoList.markTaskAsCompleted(completion);
            } else {
                System.out.print("Enter task description: ");
                String description = scanner.nextLine();
                Task task = new Task(title, description);
                todoList.addTask(task);
            }
        }

        todoList.viewTasks();
        scanner.close();
    }
} 
