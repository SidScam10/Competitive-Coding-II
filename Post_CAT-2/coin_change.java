import java.util.*;
class Coin_Change{
  public static void main(String args[]){
    Scanner sc=new Scanner(System.in);
    int n=sc.nextInt();
    int deno[] = new int[n];
    for(int i=0; i<n; i++)
        deno[i]=sc.nextInt();
    int amount = sc.nextInt();

    int count=0;
    for(int i=deno.length-1;i>=0;i--){
        while(amount>=deno[i]){
            count+=1;
            amount-=deno[i];
        }
    }
    if(amount==0) System.out.println(count);
    else System.out.println(-1);
  }
}
