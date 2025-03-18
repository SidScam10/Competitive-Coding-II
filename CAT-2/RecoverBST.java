import java.util.*;
class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int val){
        this.val=val;
    }
    TreeNode(int val, TreeNode left, TreeNode right){
        this.val=val;
        this.left=left;
        this.right=right;
    }
}

class Sol {
    public void recover_bst(TreeNode root){
        Stack<TreeNode> stack=new Stack<>();
        TreeNode curr=root, last_pro=null, first=null, sec=null;
        while(!stack.isEmpty() || curr!=null){
            while(curr!=null){
                stack.push(curr);
                curr=curr.left;
            }
            curr=stack.pop();
            if(last_pro!=null && last_pro.val>curr.val){
                if(first==null){
                    first=last_pro;
                }
                sec=curr;
            }
            last_pro=curr;
            curr=curr.right;
        }
        if(first!=null && sec!=null){
            int temp=first.val;
            first.val=sec.val;
            sec.val=temp;
        }
    }
}

public class RecoverBST {
    static TreeNode root;
    
    static TreeNode build(String s[])
    {
        if(s[0].equals("N") || s.length==0) {
            return null;
        }
        TreeNode root=new TreeNode(Integer.parseInt(s[0]));
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        int i=1;
        while(!q.isEmpty() && i<s.length){
            TreeNode curr=q.poll();
            if(!s[i].equals("N")){
                curr.left=new TreeNode(Integer.parseInt(s[i]));
                q.add(curr.left);
            }
            i++;
            if(i>=s.length) break;
            if(!s[i].equals("N")){
                curr.right=new TreeNode(Integer.parseInt(s[i]));
                q.add(curr.right);
            }
            i++;
        }
        return root;
    }
    static void inorder(TreeNode node){
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
