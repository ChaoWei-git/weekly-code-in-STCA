// 根据一棵树的前序遍历与中序遍历构造二叉树。

// 注意:
// 你可以假设树中没有重复的元素。

// 例如，给出

// 前序遍历 preorder = [3,9,20,15,7]
// 中序遍历 inorder = [9,3,15,20,7]
// 返回如下的二叉树：

//     3
//    / \
//   9  20
//     /  \
//    15   7

public class Solution {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        //*********查找中序遍历中的index
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; ++i) {
            map.put(inorder[i], i);
        }
        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, map);
    }

    private TreeNode buildTree(int[] preorder, int preBegin, int preEnd, int[] inorder, int inBegin, int inEnd, Map<Integer, Integer> map) {
        if (preBegin > preEnd || inBegin > inEnd) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preBegin]);
        int i = map.get(root.val);
        int leftEnd = preBegin + i - inBegin;
        root.left = buildTree(preorder, preBegin + 1, leftEnd, inorder, inBegin, i - 1, map);
        root.right = buildTree(preorder, leftEnd + 1, preEnd, inorder, i + 1, inEnd, map);
        return root;
    }
}
