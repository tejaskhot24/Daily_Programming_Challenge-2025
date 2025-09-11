
class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int x) {
        val = x;
    }
}

public class SymmetricTree {

    public boolean isSymmetric(TreeNode root) {
   
        if (root == null) return true;

        return isMirror(root.left, root.right);
    }

    private boolean isMirror(TreeNode t1, TreeNode t2) {

        if (t1 == null && t2 == null) return true;

        if (t1 == null || t2 == null) return false;

        return (t1.val == t2.val)
                && isMirror(t1.left, t2.right)
                && isMirror(t1.right, t2.left);
    }

 
    public static void main(String[] args) {
        SymmetricTree st = new SymmetricTree();

        // Example 1: [1,2,2,3,4,4,3] → true
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(2);
        root1.left.left = new TreeNode(3);
        root1.left.right = new TreeNode(4);
        root1.right.left = new TreeNode(4);
        root1.right.right = new TreeNode(3);
        System.out.println(st.isSymmetric(root1)); 

        // Example 2: [1,2,2,null,3,null,3] → false
        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(2);
        root2.left.right = new TreeNode(3);
        root2.right.right = new TreeNode(3);
        System.out.println(st.isSymmetric(root2)); 

        // Example 3: [1] → true
        TreeNode root3 = new TreeNode(1);
        System.out.println(st.isSymmetric(root3)); 

        // Example 4: [] → true
        System.out.println(st.isSymmetric(null)); 
    }
}
