import java.util.*;
class longest_bitonic_seq {
    public static void main(String arg[]){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int[n],inc[]=new int[n],dec[]=new int[n];
        for(int i=0;i<n;i++) {
            arr[i]=sc.nextInt();
            inc[i]=dec[i]=1;
        }
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(arr[i]>arr[j]) inc[i]=inc[j]+1;
            }
        }
        for(int i=n-2;i>=0;i--){
            for(int j=n-1;j>i;j--){
                if(arr[i]>arr[j]) dec[i]=dec[j]+1;
            }
        }
        int max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            max=Math.max(max,inc[i]+dec[i]-1);
        }
        System.out.println(max);
    }
}