import java.util.*;
class test {
    public static void solve(int n, char source, char dest, char aux) {
        if (n==1){
            System.out.println("Move disk 1 from rod " +source+" to rod "+dest);
            return;
        }
        solve(n-1, source, aux, dest);
        System.out.println("Move disk "+n+" from rod "+ source +" to rod "+dest);
        solve(n-1, aux, dest, source);
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        char source='S',aux='A',dest='D';
        solve(n,source,dest,aux);
    }
}