import java.util.*;
class Pots_Gold{
    static int findmax(int i, int j, int coin[]){
        if(i==j) return coin[i];
        if(i+1==j) return Math.max(coin[i],coin[j]);
        int start=coin[i]+Math.min(findmax(i+2,j,coin),findmax(i+1,j-1,coin));
        int end=coin[j]+Math.min(findmax(i,j-2,coin),findmax(i+1,j-1,coin));
        return Math.max(start,end);
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int coin[]=new int[n];
        for(int i=0;i<n;i++){
            coin[i]=sc.nextInt();
        }
        System.out.println(findmax(0,n-1,coin));
        
    }
}