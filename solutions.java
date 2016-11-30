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


public class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
    /** inorder successor in a binary search tree
     */
        if (p == null || root == null) {
            return null;
        }
        
        TreeNode suc = null;
        if (p.right != null) {
            suc = p.right;
            while (suc.left != null) {
                suc = suc.left;
            }
            return suc;
        } 
        
        //p.right == null, need to search from the root, mimic the search by hand path
        
        while (root != null) {
            if(root.val > p.val){
                suc = root;
                root = root.left;
            } else if(root.val < p.val){
                root = root.right;
            } else {
                break;
            }
            
        }    
        return suc;
    }
}