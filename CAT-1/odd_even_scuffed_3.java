import java.util.*;
class odd_even_scuffed_3{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        List<Integer> list=new LinkedList<>();
        List<Integer> odd=new LinkedList<>();
        List<Integer> even=new LinkedList<>();
        for(int i=0;i<n;i++){
            list.add(sc.nextInt());
            if(list.get(i)%2==0) even.add(list.get(i));
            else odd.add(list.get(i));
        }
        System.out.println(list);
        even.addAll(odd);
        System.out.println(even);
    }
}