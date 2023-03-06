import java.util.*;

class TreeNode {
    TreeNode left;
    TreeNode right;
    int val;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class maxLevelSum {

    // using DFS
    public static HashMap<Integer, Integer> map;

    public static int maxLevelSum1(TreeNode root) {
        map = new HashMap<>();
        dfs(root, 1);
        int max = Integer.MIN_VALUE, level = 0;
        for (int i : map.keySet()) {
            if (max < map.get(i)) {
                max = map.get(i);
                level = i;
            }
        }
        return level;
    }

    public static void dfs(TreeNode root, int level) {
        if (root == null)
            return;
        dfs(root.left, level + 1);
        dfs(root.right, level + 1);
        map.put(level, map.getOrDefault(level, 0) + root.val);
    }

    // using BFS

    public int maxLevelSum2(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        // if(root == null)return 0;
        q.add(root);
        int level = 0;
        int ans = 0;
        int max = Integer.MIN_VALUE;

        while (!q.isEmpty()) {
            int n = q.size();
            int sum = 0;
            while (n > 0) {
                // TreeNode p = q.peek();
                if (q.peek().left != null)
                    q.add(q.peek().left);
                if (q.peek().right != null)
                    q.add(q.peek().right);
                sum += q.peek().val;
                q.remove();
                n--;
            }
            level++;
            if (sum > max) {
                max = sum;
                ans = level;
            }
        }
        return ans;
    }
}
