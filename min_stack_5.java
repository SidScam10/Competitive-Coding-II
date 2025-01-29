import java.util.*;

public class min_stack_5 {
    Stack<Integer> mainStack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();

    public void push(int x) {
        mainStack.push(x);
        minStack.push(minStack.isEmpty() || x <= minStack.peek() ? x : minStack.peek());
    }

    public void pop() {
        if (!mainStack.isEmpty()) {
            mainStack.pop();
            minStack.pop();
        }
    }

    public void peek() {
        if (!mainStack.isEmpty()) {
            System.out.println(minStack.peek());
        }
    }

    public static void main(String[] args) {
        min_stack_5 stack = new min_stack_5();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of operations:");
        int n = sc.nextInt();
        sc.nextLine(); // Consume newline

        for (int i = 0; i < n; i++) {
            System.out.println("Enter operation (push <value>, pop, top):");
            String operation = sc.nextLine();
            String[] parts = operation.split(" ");
            switch (parts[0]) {
                case "push":
                    int value = Integer.parseInt(parts[1]);
                    stack.push(value);
                    break;
                case "pop":
                    stack.pop();
                    break;
                case "top":
                    stack.peek();
                    break;
                default:
                    System.out.println("Invalid operation");
                    break;
            }
        }
    }
}