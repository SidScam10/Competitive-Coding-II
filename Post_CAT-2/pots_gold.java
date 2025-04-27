import java.util.*;
class Pots_Gold{
    public static int findMax(int[] coin, int i, int j){
        if (i == j)
            return coin[i];
        if (i + 1 == j)
            return Integer.max(coin[i], coin[j]);
        int start = coin[i] + Integer.min(findMax(coin,i+2,j),findMax(coin,i+1,j-1));
        int end = coin[j] + Integer.min(findMax(coin,i+1,j-1),findMax(coin,i,j-2));
        return Integer.max(start, end);
    }
    public static void main(String[] args){
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        int[] coin=new int[n];
        for(int i=0; i<n; i++)
            coin[i]=s.nextInt();
        System.out.print(findMax(coin,0,n-1));
    }
}
