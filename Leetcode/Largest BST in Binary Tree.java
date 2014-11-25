public class LargestBst
{ 
    public static class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;        
    }
    
    public static class TreeNodeHelper {
        TreeNode node;
        int nodes;
        Integer maxValue;
        Integer minValue;
        boolean isBST;
 
        public TreeNodeHelper() {}
 
        public TreeNodeHelper(TreeNode node, int nodes, Integer maxValue, Integer minValue, boolean isBST) {
            this.node = node;
            this.nodes = nodes;
            this.maxValue = maxValue;
            this.minValue = minValue;
            this.isBST = isBST;
        }      
    }
 
    public static TreeNodeHelper getLargestBST(TreeNode tree) {
        if (tree == null) {
            return new TreeNodeHelper(null, 0, null, null, false);
        }
        if (tree.left == null && tree.right == null) {
            TreeNodeHelper helper = new TreeNodeHelper(tree, 1, tree.value, tree.value, true);
            return helper;
        } else {
            TreeNodeHelper leftBst = getLargestBST(tree.left);
            TreeNodeHelper rightBst = getLargestBST(tree.right);            
 
            if (!(rightBst.isBST && rightBst.minValue > tree.value)) {
                rightBst.isBST = false;
            }
 
            if (!(leftBst.isBST && leftBst.maxValue < tree.value)) {
                leftBst.isBST = false;
            }
 
            if (leftBst.isBST && rightBst.isBST) { 
                return new TreeNodeHelper(tree, rightBst.nodes + leftBst.nodes + 1, rightBst.maxValue, leftBst.minValue, true);
            } else if (tree.left == null && rightBst.isBST) {
                return new TreeNodeHelper(tree, ++rightBst.nodes, rightBst.maxValue, tree.value, true);
            } else if (tree.right == null && leftBst.isBST) {
                return new TreeNodeHelper(tree, ++leftBst.nodes, tree.value, leftBst.minValue, true);
            } else { 
                return leftBst.nodes >= rightBst.nodes ? leftBst : rightBst;
            }
        }
    }
}
