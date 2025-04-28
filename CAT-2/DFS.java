import java.util.*;
class DFS{
    int V;
    int adj[][];
    DFS(int n){
        this.V=n;
        adj=new int[V][V];
    }
    void add_edge(int src, int dest){
        adj[src][dest]=1;
        adj[dest][src]=1;
    }
    void dfs(int start){
        boolean visited[]=new boolean[V];
        Stack<Integer> stack=new Stack<>();
        stack.push(start);
        while(!stack.isEmpty()){
            int vertex=stack.pop();
            if(!visited[vertex]){
                visited[vertex]=true;
                System.out.print(vertex+" ");
                for(int i=V-1;i>=0;i--){
                    if(adj[vertex][i]==1 && !visited[i]) stack.push(i);
                }
            }
        }
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        DFS graph=new DFS(n);
        while(true){
            int src=sc.nextInt();
            int dest=sc.nextInt();
            if(src==-1 || dest==-1) break;
            graph.add_edge(src,dest);
        }
        int start=sc.nextInt();
        graph.dfs(start);
    }
}