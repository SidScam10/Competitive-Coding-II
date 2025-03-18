import java.util.*;
public class merge_sort_DLL_scuffed_4 {
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int merge_arr[]=new int[n];
        for(int i=0;i<n;i++) merge_arr[i]=sc.nextInt();
        Arrays.sort(merge_arr);
        for(int i=0;i<n;i++) System.out.print(merge_arr[i]+" ");
    }
}
