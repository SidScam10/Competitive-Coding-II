import java.util.*;
class Subset_Sum {
    static boolean subset_sum(int sum, int val[], int n){
        if (sum==0) return true;
        if (n==0) return false;
        if(val[n-1]>sum) subset_sum(sum,val,n-1);
        return subset_sum(sum,val,n-1) || subset_sum(sum-val[n-1],val,n-1);
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int sum=sc.nextInt();
        int val[]=new int[n];
        for(int i=0;i<n;i++){
            val[i]=sc.nextInt();
        }
        System.out.println(subset_sum(sum,val,n));
    }
}