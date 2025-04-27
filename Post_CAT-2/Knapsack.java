import java.util.*;
class Knapsack {
    static int knapsack(int W, int wt[], int val[], int n){
        if (n==0 || W==0) return 0;
        if(wt[n-1]>W) return knapsack(W,wt,val,n-1);
        else return Math.max(val[n-1]+knapsack(W-wt[n-1],wt,val,n-1),knapsack(W,wt,val,n-1));
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int wt[]=new int[n];
        int val[]=new int[n];
        int W=sc.nextInt();
        for(int i=0;i<n;i++){
            wt[i]=sc.nextInt();
        }
        for(int i=0;i<n;i++){
            val[i]=sc.nextInt();
        }
        System.out.println(knapsack(W,wt,val,n));
    }
}