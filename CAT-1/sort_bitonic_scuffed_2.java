import java.util.*;
public class sort_bitonic_scuffed_2 {
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int bit_arr[]=new int[n];
        for(int i=0;i<n;i++) bit_arr[i]=sc.nextInt();
        Arrays.sort(bit_arr);
        for(int i=0;i<n;i++) System.out.print(bit_arr[i]+" ");
    }
}
