import java.util.*;

public class Priority_Queue_9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PriorityQueue<Task> tasks = new PriorityQueue<>((a, b) -> Integer.compare(a.priority, b.priority));
        int n = sc.nextInt(); //Enter number of records
        sc.nextLine(); //Consume extra newline
        for (int i = 0; i < n; i++) {
            String[] name_priority = sc.nextLine().split(" ");
            tasks.add(new Task(name_priority[0], Integer.parseInt(name_priority[1])));
        }
        while (!tasks.isEmpty()) System.out.println(tasks.poll().name);
    }
}

class Task {
    String name;
    int priority;

    Task(String name, int priority) {
        this.name = name;
        this.priority = priority;
    }
}