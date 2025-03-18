import java.util.*;
class Node {
    int val;
    Node left, right;
    Node(int val) { this.val=val; }
    Node(int val, Node left, Node right) {
        this.val=val;
        this.left=left;
        this.right=right;
    }
}
class test {
    static Node root;
    static void right_view(Node node){
        if(root==null) return;
        Queue<Node> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int n=q.size();
            for(int i=0;i<n;i++){
                Node curr=q.poll();
                if(i==n-1) System.out.print(curr.val+" ");
                if(curr.left!=null) q.add(curr.left);
                if(curr.right!=null) q.add(curr.right);
            }
        }
    }
    static Node build(String s[]){
        if(s[0].equals("N") || s.length==0) return null;
        Node root=new Node(Integer.parseInt(s[0]));
        Queue<Node> q=new LinkedList<>();
        q.add(root);
        int i=1;
        while(!q.isEmpty() && i<s.length){
            Node curr=q.poll();
            if(!s[i].equals("N")){
                curr.left=new Node(Integer.parseInt(s[i]));
                q.add(curr.left);
            }
            i++;
            if(i>=s.length) break;
            if(!s[i].equals("N")){
                curr.right=new Node(Integer.parseInt(s[i]));
                q.add(curr.right);
            }
            i++;
        }
        return root;
    }
    static void inorder(Node node){
        if(node==null) return;
        inorder(node.left);
        System.out.print(node.val+" ");
        inorder(node.right);
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        String s[]=sc.nextLine().split(" ");
        root=build(s);
        right_view(root);
    }
}