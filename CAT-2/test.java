import java.util.*;
class test {
    static void bellmanford(int V, int E, int edges[][], int src){
        int dist[]=new int[V];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[src]=0;
        for(int i=0;i<V-1;i++){
            for(int edge[]:edges){
                int u=edge[0],v=edge[1],w=edge[2];
                if(dist[u]!=Integer.MAX_VALUE && dist[u]+w<dist[v]){
                    dist[v]=dist[u]+w;
                }
            }
        }
        for(int edge[]:edges){
            int u=edge[0],v=edge[1],w=edge[2];
            if(dist[u]!=Integer.MAX_VALUE && dist[u]+w<dist[v]){
                System.out.println("Negative cycles");
                System.exit(0);
            }
        }
        for(int i=0;i<V;i++){
            System.out.println(i+"->"+dist[i]);
        }
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int V=sc.nextInt();
        int E=sc.nextInt();
        int edges[][]=new int[E][3];
        for(int i=0;i<E;i++){
            edges[i]=new int[]{sc.nextInt(),sc.nextInt(),sc.nextInt()};
        }
        int src=sc.nextInt();
        bellmanford(V,E,edges,src);
    }
}