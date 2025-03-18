import java.util.*;
class celebrity_6 {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int mat[][]=new int[n][n];
        int srow[]=new int[n];
        int scol[]=new int[n];

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++) mat[i][j]=sc.nextInt();
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                srow[i]+=mat[i][j];
                scol[j]+=mat[i][j];
            }
        }
        int found=-1;
        for(int i=0;i<n;i++){
            if(srow[i]==0 || scol[i]==n-1){
                found=i;
                break;
            }
        }
        if(found!=-1) System.out.println("celeb "+found);
        else System.out.println("there is no celeb");
    }
}