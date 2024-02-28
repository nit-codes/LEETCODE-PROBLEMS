class Solution {
    private int maxDepth;
    private int bottomLeft;
    
    public int findBottomLeftValue(TreeNode root) {
        maxDepth = -1;
        
        solve(root, 0);
        return bottomLeft;
    }
    
    private void solve(TreeNode root, int currDepth) {
        if (root == null) {
            return;
        }
        
        if (currDepth > maxDepth) {
            maxDepth = currDepth;
            bottomLeft = root.val;
        }
        
        solve(root.left, currDepth + 1);
        solve(root.right, currDepth + 1);
    }
}
