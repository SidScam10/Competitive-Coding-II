import java.util.*;
class Fibo_dp {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int[n+1];
        arr[0]=0; arr[1]=1;
        for(int i=2;i<=n;i++){
            arr[i]=arr[i-1]+arr[i-2];
        }
        for(int i=0;i<=n;i++){
            System.out.print(arr[i]+" ");
        }
    }
}
