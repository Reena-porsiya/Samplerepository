class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class SymmetricTree {
    public static boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }

        return isMirror(root.left, root.right);
    }

    private static boolean isMirror(TreeNode leftSubtree, TreeNode rightSubtree) {
        if (leftSubtree == null && rightSubtree == null) {
            return true;
        }

        if (leftSubtree == null || rightSubtree == null) {
            return false;
        }

        return (leftSubtree.val == rightSubtree.val)
                && isMirror(leftSubtree.left, rightSubtree.right)
                && isMirror(leftSubtree.right, rightSubtree.left);
    }

    public static void main(String[] args) {
       
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(2);
        root1.left.left = new TreeNode(3);
        root1.left.right = new TreeNode(4);
        root1.right.left = new TreeNode(4);
        root1.right.right = new TreeNode(3);

        System.out.println("Is the tree symmetric? " + isSymmetric(root1)); // Output: true

        // Input: [1,2,2,null,3,null,3]
        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(2);
        root2.left.left = null;
        root2.left.right = new TreeNode(3);
        root2.right.left = null;
        root2.right.right = new TreeNode(3);

        System.out.println("Is the tree symmetric? " + isSymmetric(root2)); // Output: false
    }
}
