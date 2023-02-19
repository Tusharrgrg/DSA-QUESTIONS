//Binary Tree Zigzag Level Order Traversal
//Given the root of a binary tree, 
//return the zigzag level order traversal of its nodes' values. 
//(i.e., from left to right, then right to left for the next level and alternate between).
// leetcode 103

import java.util.*;

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

public class ZigZagTree {
     public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> queue  = new LinkedList<>();
        queue.offer(root);
        boolean flag = true;

        if(root == null) return null;

        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> r = new ArrayList<>();

            for(int i = 0; i<size; i++){
                TreeNode node = queue.poll();

                if(root.left!=null){
                    queue.offer(root.left);
                }
                if(root.right!= null){
                    queue.offer(root.right);
                }

                r.add(node.val);
            }

            if(flag == true){
                ans.add(r);
                flag =false;
            }else{
                Collections.reverse(r);
                ans.add(r);
                flag = true;
            }
        }
        return ans;
     }

}