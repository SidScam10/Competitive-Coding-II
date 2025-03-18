import java.util.*;
class Node {
    int val,hd;
    Node left, right;
    Node(int val) { 
        this.val=val; 
        this.left=this.right=null;
        this.hd=Integer.MAX_VALUE;
    }
}

class Views {
    static Node root;
    static void rightview(Node node){
        if(root==null) return;
        Queue<Node> q=new LinkedList<>();
        q.add(node);
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
    static void leftview(Node node){
        if(root==null) return;
        Queue<Node> q=new LinkedList<>();
        q.add(node);
        while(!q.isEmpty()){
            int n=q.size();
            for(int i=0;i<n;i++){
                Node curr=q.poll();
                if(i==0) System.out.print(curr.val+" ");
                if(curr.left!=null) q.add(curr.left);
                if(curr.right!=null) q.add(curr.right);
            }
        }
    }
    static void topview(Node root) {
        if (root == null) return;
        Queue<QueueObj> q = new LinkedList<>();
        Map<Integer, Integer> map = new TreeMap<>();
        q.add(new QueueObj(root, 0));
        while (!q.isEmpty()) {
            QueueObj temp = q.poll();
            if (!map.containsKey(temp.hd)) {
                map.put(temp.hd, temp.node.val);
            }
            if (temp.node.left != null) q.add(new QueueObj(temp.node.left, temp.hd - 1));
            if (temp.node.right != null) q.add(new QueueObj(temp.node.right, temp.hd + 1));
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.print(entry.getValue() + " ");
        }
    }
    static void bottomview(Node node){
        if(root==null) return;
        Queue<Node> q=new LinkedList<>();
        Map<Integer,Integer> map=new TreeMap<>();
        root.hd=0;
        q.add(root);
        while(!q.isEmpty()){
            Node temp=q.poll();
            map.put(temp.hd, temp.val);
            if(temp.left!=null){
                temp.left.hd=temp.hd-1;
                q.add(temp.left);
            }
            if(temp.right!=null){
                temp.right.hd=temp.hd+1;
                q.add(temp.right);
            }
        }
        for(Map.Entry<Integer,Integer> entry: map.entrySet()){
            System.out.print(entry.getValue()+" ");
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
    static class QueueObj {
        Node node;
        int hd;
        QueueObj(Node node, int hd) {
            this.node = node;
            this.hd = hd;
        }
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
        rightview(root);
        System.out.println();
        leftview(root);
        System.out.println();
        topview(root);
        System.out.println();
        bottomview(root);
        System.out.println();
    }
}

    