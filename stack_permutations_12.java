import java.util.*;
public class stack_permutations_12 {
    public static boolean isStackPermutation(int[] original, int[] target) {
        Stack<Integer> stack=new Stack<>();
        int index = 0;
        for (int num : original) {
            stack.push(num);
            while (!stack.isEmpty() && stack.peek() == target[index]) {
                stack.pop();
                index++;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String[] org_str=sc.nextLine().split(" ");
        String[] tar_str=sc.nextLine().split(" ");
        int[] original=new int[org_str.length];
        int[] target=new int[tar_str.length];
        for(int i=0;i<org_str.length;i++){
            original[i]=Integer.parseInt(org_str[i]);
            target[i]=Integer.parseInt(tar_str[i]);
        }
        boolean result = isStackPermutation(original, target);
        System.out.println("Is it a stack permutation? " + result);
    }
}