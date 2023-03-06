import java.util.*;

class TreeNode {
         TreeNode left;
         TreeNode right;
         int val;
         TreeNode() {}
         TreeNode(int val) { this.val = val; }
         TreeNode(int val, TreeNode left, TreeNode right) {
             this.val = val;
             this.left = left;
             this.right = right;
         }
     }

public class InvertBinaryTree{
   
    //recursive solution 
    public TreeNode invertTree(TreeNode root){
        if(root == null){
            return null;
        }

        TreeNode temp = root.right;
        root.right = invertTree(root.left);
        root.left = invertTree(temp);

        return root;

    }

    //iterative solution

    public static TreeNode invertTree1(TreeNode root){
        if(root == null){
            return null;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            TreeNode left = node.left;
            node.left = node.right;
            node.right = left;

            if(node.left!= null){
                queue.offer(node.left);
            }
            if(node.right!= null){
                queue.offer(node.right);
            }
        }
        return root;
    }
}