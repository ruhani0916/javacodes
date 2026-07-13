import java.util.*;

public class postorder {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();

        TreeNode curr = root;
        TreeNode lastVisited = null;

        while (curr != null || !st.isEmpty()) {

            if (curr != null) {
                st.push(curr);
                curr = curr.left;
            } else {
                TreeNode peek = st.peek();

                if (peek.right != null && lastVisited != peek.right) {
                    curr = peek.right;
                } else {
                    ans.add(peek.val);
                    lastVisited = st.pop();
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        List<Integer> result = postorderTraversal(root);

        System.out.println(result);
    }
}