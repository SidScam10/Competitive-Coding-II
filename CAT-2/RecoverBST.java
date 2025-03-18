import java.util.*;
class Node {
    int val;
    Node left,right;
    Node(int val){ this.val=val; }
    Node(int val, Node left, Node right) {
        this.val=val;
        this.left=left;
        this.right=right;
    }
}

class Sol{
    public void recover_bst(Node root){
        Stack<Node> stack=new Stack<>();
        Node curr=root, fir=null, sec=null, last_pro=null;
        while(!stack.isEmpty() || curr!=null){
            while(curr!=null){
                stack.push(curr);
                curr=curr.left;
            }
            curr=stack.pop();
            if(last_pro!=null && last_pro.val>curr.val){
                if(fir==null){
                    fir=last_pro;
                }
                sec=curr;
            }
            last_pro=curr;
            curr=curr.right;
        }
        if(fir!=null && sec!=null) {
            int temp=fir.val;
            fir.val=sec.val;
            sec.val=temp;
        }
    }
}

public class RecoverBST {
    static Node root;
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
        inorder(root);
        Sol sol=new Sol();
        sol.recover_bst(root);
        inorder(root);
    }
}