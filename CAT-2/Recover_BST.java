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
    public static void main(String[] args) {
        // Creating a BST with two nodes swapped
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.left.right = new TreeNode(2); // Swapped node

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