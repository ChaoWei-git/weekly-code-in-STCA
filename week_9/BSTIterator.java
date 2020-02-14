/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

 //inorder
class BSTIterator {

    private List<Integer> result = new ArrayList<>();
    private int current_node = 0;
    private int size = 0;
    public BSTIterator(TreeNode root) {

        this.bst_inorder(root,result); 
        this.size = result.size();      
    }

    private void bst_inorder(TreeNode node,List<Integer> result){
        if(node==null) return;
        this.bst_inorder(node.left,result);
        result.add(node.val);
        this.bst_inorder(node.right,result);
    }
    
    /** @return the next smallest number */
    public int next() {
        return result.get(current_node++);
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return current_node<size;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */



 //stack
class BSTIterator {

    private Stack<TreeNode> stack = new Stack<>();
    public BSTIterator(TreeNode root) {
        this.pushAllLeftNode(root);
    }
    private void pushAllLeftNode(TreeNode node){
        while(node!=null){
            this.stack.push(node);
            node = node.left;
        }
    } 

    
    /** @return the next smallest number */
    public int next() {
        TreeNode node = stack.pop();
        if(node.right!=null) this.pushAllLeftNode(node.right);
        return node.val;
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return stack.isEmpty()==false;
    }
}