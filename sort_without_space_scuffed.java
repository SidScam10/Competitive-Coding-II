import java.util.*;
public class sort_without_space_scuffed {
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int ll_arr[]=new int[n];
        for(int i=0;i<n;i++) ll_arr[i]=sc.nextInt();
        Arrays.sort(ll_arr);
        for(int i=0;i<n;i++) System.out.print(ll_arr[i]+" ");
    }
}
