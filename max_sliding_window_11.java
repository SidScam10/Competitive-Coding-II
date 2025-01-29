import java.util.*;
public class max_sliding_window_11 {
    public static void main(String[] args) {
        Deque<Integer> Q = new LinkedList<>();
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        int k=sc.nextInt(), i;

        for (i = 0; i < k; i++) {
            while (!Q.isEmpty() && arr[i] > arr[Q.peekLast()]) {
                Q.removeLast();
            }
            Q.addLast(i);
        }

        while (i < arr.length) {
            System.out.print(arr[Q.peek()] + " ");
            while (!Q.isEmpty() && arr[i] > arr[Q.peekLast()]) {
                Q.removeLast();
            }
            while (!Q.isEmpty() && Q.peek() <= i - k) {
                Q.removeFirst();
            }
            Q.addLast(i);
            i++;
        }
        System.out.print(arr[Q.peek()]);
    }
}