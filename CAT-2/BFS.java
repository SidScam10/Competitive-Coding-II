import java.util.*;
class BFS{
    int V;
    int adj[][];
    BFS(int vertices){
        this.V=vertices;
        adj=new int[V][V];
    }
    void add_edge(int src, int dest){
        adj[src][dest]=1;
        adj[dest][src]=1;
    }
    void bfs(int start){
        boolean visited[]=new boolean[V];
        Queue<Integer> q=new LinkedList<>();
        visited[start]=true;
        q.add(start);
        while(!q.isEmpty()){
            int vertex=q.poll();
            System.out.print(vertex+" ");
            for(int i=0;i<V;i++){
                if(adj[vertex][i]==1 && !visited[i]) {
                    q.add(i);
                    visited[i]=true;
                }
            }
        }
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        BFS graph=new BFS(n);
        while(true){
            int src=sc.nextInt();
            int dest=sc.nextInt();
            if(src==-1 && dest==-1) break;
            graph.add_edge(src,dest);
        }
        int start=sc.nextInt();
        graph.bfs(start);
    }
}