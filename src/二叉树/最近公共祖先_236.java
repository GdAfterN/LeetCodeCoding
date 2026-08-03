package 二叉树;
import java.util.*;
public class 最近公共祖先_236 {
    static class Solution{
        static class TreeNode{
            int val;
            TreeNode left,right;
            public TreeNode(){};
            public TreeNode(int val) {
                this.val = val;
            }
        }

        static void printTree(TreeNode root){
            if(root==null){
                System.out.println("null");
                return;
            }
            List<String> res=new ArrayList<>();
            Deque<TreeNode> deque=new LinkedList<>();
            deque.offerLast(root);
            while(!deque.isEmpty()){
                TreeNode node=deque.pollFirst();
                if(node==null) res.add("null");
                else{
                    res.add(String.valueOf(node.val));
                    deque.offerLast(node.left);
                    deque.offerLast(node.right);
                }
            }
            int last=res.size()-1;
            while(last>=0&&res.get(last).equals("null")){
                last--;
            }
            for(int i=0;i<=last;i++){
                if(i==last) System.out.println(res.get(last));
                else System.out.print(res.get(i)+",");
            }
        }

        static TreeNode createTree(Integer[] vals){
            if(vals.length==0) return null;
            Deque<TreeNode> deque=new ArrayDeque<>();
            TreeNode root=new TreeNode(vals[0]);
            int i=1;
            deque.offerLast(root);
            while(!deque.isEmpty()&&i<vals.length){
                TreeNode node=deque.pollFirst();
                if(vals[i]!=null){
                    node.left=new TreeNode(vals[i]);
                    deque.offerLast(node.left);
                }
                i++;
                if(i<vals.length&&vals[i]!=null){
                    node.right=new TreeNode(vals[i]);
                    deque.offerLast(node.right);
                }
                i++;
            }
            return root;
        }

        static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
            if(root==null||root==p||root==q) return root;
            TreeNode left=lowestCommonAncestor(root.left,p,q);
            TreeNode right=lowestCommonAncestor(root.right,p,q);
            if(left==null) return right;
            if(right==null) return left;
            return root;
        }

        public static void main(String[] args){

        }
    }
}
