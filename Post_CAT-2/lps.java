import java.util.*;
class LPS {
    static int lps_calc(int start,int end,String str,Integer dp[][]){
        if(start>end) return 0;
        if(start==end) return 1;
        if(dp[start][end]!=null) return dp[start][end];
        if(str.charAt(start)==str.charAt(end)) return dp[start][end]=2+lps_calc(start+1,end-1,str,dp);
        return dp[start][end]=Math.max(lps_calc(start+1,end,str,dp),lps_calc(start,end-1,str,dp));
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        String str=sc.next();
        Integer dp[][]=new Integer[str.length()][str.length()];
        System.out.println(lps_calc(0,str.length()-1,str,dp));
    }
}