
class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int x) {
        val = x;
        left = right = null;
    }
}

class Solution {

    private boolean isValidBSTHelper(TreeNode root, long minVal, long maxVal) {
    
        if (root == null) return true;

        if (root.val <= minVal || root.val >= maxVal) {
            return false;
        }

        return isValidBSTHelper(root.left, minVal, root.val) &&
               isValidBSTHelper(root.right, root.val, maxVal);
    }

    public boolean isValidBST(TreeNode root) {
        return isValidBSTHelper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public static void main(String[] args) {
        Solution obj = new Solution();

        // Example 1: root = [2,1,3]
        TreeNode root1 = new TreeNode(2);
        root1.left = new TreeNode(1);
        root1.right = new TreeNode(3);
        System.out.println(obj.isValidBST(root1)); 

        // Example 2: root = [5,1,4,null,null,3,6]
        TreeNode root2 = new TreeNode(5);
        root2.left = new TreeNode(1);
        root2.right = new TreeNode(4);
        root2.right.left = new TreeNode(3);
        root2.right.right = new TreeNode(6);
        System.out.println(obj.isValidBST(root2)); 

        // Example 3: root = [10,5,15,null,null,6,20]
        TreeNode root3 = new TreeNode(10);
        root3.left = new TreeNode(5);
        root3.right = new TreeNode(15);
        root3.right.left = new TreeNode(6);
        root3.right.right = new TreeNode(20);
        System.out.println(obj.isValidBST(root3)); 
    }
}
