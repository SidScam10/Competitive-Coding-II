import java.util.*;
class Wild_Match {
    static boolean wild(int i, int j, String p, String q, Boolean[][] dp){
        if(i==p.length()){
            for(int k=j;k<q.length();k++){
                if(q.charAt(k)!='*') return false;
            }
            return true;
        }
        if(j==q.length()) return false;
        if(dp[i][j]!=null) return dp[i][j];
        if(p.charAt(i)==q.charAt(j) || q.charAt(j)=='?') return dp[i][j]=wild(i+1,j+1,p,q,dp);
        else if(q.charAt(j)=='*') return dp[i][j]=wild(i+1,j,p,q,dp) || wild(i,j+1,p,q,dp);
        return dp[i][j]=false;
        
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        String p=sc.next();
        String q=sc.next();
        Boolean dp[][]=new Boolean[p.length()][q.length()];
        System.out.println(wild(0,0,p,q,dp));
    }
    
}