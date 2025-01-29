import java.util.*;

public class stock_span_8 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        int S[] = new int[n];
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            while (!stack.isEmpty() && arr[stack.peek()] <= arr[i]) stack.pop();
            S[i] = stack.isEmpty() ? i+1 : i-stack.peek();
            stack.push(i);
        }
        System.out.print(Arrays.toString(S));
    }
}