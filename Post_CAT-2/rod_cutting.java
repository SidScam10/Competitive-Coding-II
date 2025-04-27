import java.util.*;
class Rod_Cut {
    static int rod_calc(int rod[],int n){
        int dp[][]=new int[n+1][n+1];
        for(int i=0;i<=n;i++){
            for(int j=0;j<=n;j++){
                if(i==0 || j==0) dp[i][j]=0;
                else{
                    if(i==1) dp[i][j]=j*rod[i-1];
                    else{
                        if(i>j) dp[i][j]=dp[i-1][j];
                        else{
                            dp[i][j]=Math.max(rod[i-1]+dp[i][j-i],dp[i-1][j]);
                        }
                    }
                }
            }
        }
        return dp[n][n];
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int rod[]=new int[n];
        for(int i=0;i<n;i++){
            rod[i]=sc.nextInt();
        }
        System.out.println(rod_calc(rod,n));
    }
}