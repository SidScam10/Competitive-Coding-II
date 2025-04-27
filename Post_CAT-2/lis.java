import java.util.*;
class lis {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        int list[]=new int[n];
        list[0]=1;
        for(int i=1;i<n;i++){
            list[i]=1;
            for(int j=0;j<i;j++){
                if(arr[i]>arr[j] && list[i]<list[j]+1){
                    list[i]=list[j]+1;
                }
            }
        }
        int m=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            m=Math.max(m,list[i]);
        }
        System.out.println(m);
    }
}
