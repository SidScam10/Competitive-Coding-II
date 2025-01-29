import java.util.*;
class odd_even_scuffed {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int[n];
        int odd[]=new int[n];
        int even[]=new int[n];
        int odd_count=0,even_count=0;
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
            if(arr[i]%2==0) even[even_count++]=arr[i];
            else odd[odd_count++]=arr[i];
        }
        for(int i=n-1;i>=0;i--) System.out.print(arr[i]+" ");
        System.out.println();
        for(int i=even_count-1;i>=0;i--) System.out.print(even[i]+" ");
        for(int i=odd_count-1;i>=0;i--) System.out.print(odd[i]+" ");
    }
}
