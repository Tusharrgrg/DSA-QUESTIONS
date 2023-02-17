package Tree;

import java.util.ArrayList;

//Minimum Distance Between BST Nodes
public class MinDisNodes {
    
    public static int minDiffInBST(Node root) {
        inorder(root);
        int min = Integer.MAX_VALUE;
        for(int i = 1; i<list.size(); i++){
            if(list.get(i)-list.get(i-1) <min){
                min = list.get(i)-list.get(i-1);
            }
        }
        return min;
    }

    static ArrayList<Integer> list = new ArrayList<>();
    public static void inorder(Node root){
        if(root == null){
            return;
        }
        inorder(root.left);
        list.add(root.val);
        inorder(root.right);
    }

}
