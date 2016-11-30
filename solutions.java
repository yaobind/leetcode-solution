public class Solution {
    /** Validate Binary Search Tree
     * @param root: The root of binary tree.
     * @return: True if the binary tree is BST, or false
     */
    public boolean isValidBST(TreeNode root) {
        return helper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    private boolean helper(TreeNode root, int min, int max) {
        if(root == null) {
            return true;
        }
        
        if ( root.val <= max && root.val >= min ) {
            return helper(root.left, min, root.val-1) && helper(root.right, root.val+1, max);
        } 
        
        return false;
    }
}