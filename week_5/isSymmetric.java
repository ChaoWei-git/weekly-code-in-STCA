import java.util.LinkedList;
import java.util.Queue;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    // public boolean isSymmetric(TreeNode root) {
    //     if(root==null) return true;
    //     return helper(root.left, root.right);
    // }
    // private boolean helper(TreeNode left,TreeNode right){
    //     if(left==null&&right==null) return true;
    //     if(left==null||right==null) return false;
    //     return left.val==right.val&&helper(left.left, right.right)&&helper(left.right, right.left);
    // }
    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> treeQueue = new LinkedList<>();
        treeQueue.add(root.left);
        treeQueue.add(root.right);
        while(!treeQueue.isEmpty()){
            TreeNode current_1 = treeQueue.poll();
            TreeNode current_2 = treeQueue.poll();
            if (current_1 == null && current_2 == null) continue;
            if (current_1 == null || current_2 == null) return false;
            if(current_1.val!=current_2.val) return false;
            treeQueue.add(current_1.left);
            treeQueue.add(current_2.right);
            treeQueue.add(current_1.right);
            treeQueue.add(current_2.left);
        }
        return true;
    }
}