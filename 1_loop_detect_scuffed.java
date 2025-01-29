import java.util.*;

public class loop_detect_scuffed {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + "->");
        }
        System.out.println("NULL");
        int a = sc.nextInt(); //Position to take input to connect loop
        if (a < 1 || a > n) System.out.println("Cycle not detected");
        else System.out.println("Cycle detected");
        sc.close();
    }
}