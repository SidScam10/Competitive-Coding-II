import java.util.*;
class test {
    public static boolean is_Stack(int org[], int tar[]){
        Stack<Integer> stack=new Stack<>();
        int ind=0;
        for(int num:org){
            stack.push(num);
            while(!stack.isEmpty() && stack.peek()==tar[ind]){
                stack.pop();
                ind++;
            }
        }
        return stack.isEmpty();
    }
    public static void main(String args[]) {
        Scanner sc=new Scanner(System.in);
        String org_str[]=sc.nextLine().split(" ");
        String tar_str[]=sc.nextLine().split(" ");
        int org[]=new int[org_str.length];
        int tar[]=new int[org_str.length];
        for(int i=0;i<tar_str.length;i++){
            org[i]=Integer.parseInt(org_str[i]);
            tar[i]=Integer.parseInt(tar_str[i]);
        }
        System.out.println(is_Stack(org,tar));
    }
}
