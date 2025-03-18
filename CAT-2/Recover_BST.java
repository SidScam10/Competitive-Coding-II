import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public void recoverTree(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root, lastProcessed = null;
        TreeNode first = null, second = null;

        while (!stack.isEmpty() || current != null) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            if (lastProcessed != null && lastProcessed.val > current.val) {
                if (first == null) {
                    first = lastProcessed;
                }
                second = current; // Always update second to get the last incorrect node
            }
            lastProcessed = current;
            current = current.right;
        }

        if (first != null && second != null) {
            // Swap values to fix the BST
            int temp = first.val;
            first.val = second.val;
            second.val = temp;
        }
    }

    static void printInorder(TreeNode node) {
        if (node == null) return;
        printInorder(node.left);
        System.out.print(" " + node.val);
        printInorder(node.right);
    }
}

public class Recover_BST {
    static TreeNode root;
    static TreeNode build(String[] s) {
        if (s[0].equals("N") || s.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(s[0]));
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int i = 1;
        while (!q.isEmpty() && i < s.length) {
            TreeNode curr = q.poll();
            // Left child
            if (!s[i].equals("N")) {
                curr.left = new TreeNode(Integer.parseInt(s[i]));
                q.add(curr.left);
            }
            i++;
            if (i >= s.length) break;
            // Right child
            if (!s[i].equals("N")) {
                curr.right = new TreeNode(Integer.parseInt(s[i]));
                q.add(curr.right);
            }
            i++;
        }
        return root;
    }
    public static void main(String[] args) {
        // Creating a BST with two nodes swapped
        Scanner sc=new Scanner(System.in);
        String s[]=sc.nextLine().split(" ");
        root=build(s);

        System.out.println("Inorder before recovery:");
        Solution.printInorder(root);
        System.out.println();

        // Recover the BST
        Solution solution = new Solution();
        solution.recoverTree(root);

        System.out.println("Inorder after recovery:");
        Solution.printInorder(root);
        System.out.println();
    }

}
