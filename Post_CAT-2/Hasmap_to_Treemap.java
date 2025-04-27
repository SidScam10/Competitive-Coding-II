import java.util.*;
class HashMap_to_TreeMap {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        Map<String,String> map=new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(sc.next(),sc.next());
        }
        Map<String,String> tm=new TreeMap<>();
        System.out.println(map);
        tm.putAll(map);
        System.out.println(tm);
    }
}