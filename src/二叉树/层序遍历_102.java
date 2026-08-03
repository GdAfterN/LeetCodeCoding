package 二叉树;
import java.util.*;
public class 层序遍历_102 {
    static class Solution{
        static class TreeNode{
            int val;
            TreeNode left,right;
            public TreeNode(){};
            public TreeNode(int val) {
                this.val = val;
            }
        }
        static List<List<Integer>> levelOrder(TreeNode root){
            List<List<Integer>> res=new ArrayList<>();
            if(root==null) return res;
            Deque<TreeNode> deque=new ArrayDeque<>();
            deque.offerFirst(root);
            while(!deque.isEmpty()){
                List<Integer> route=new ArrayList<>();
                int size=deque.size();
                for(int i=0;i<size;i++){
                    TreeNode node=deque.pollFirst();
                    route.add(node.val);
                    if(node.left!=null) deque.offerLast(node.left);
                    if(node.right!=null) deque.offerLast(node.right);
                }
                res.add(route);
            }return res;
        }

        static void printTree(TreeNode root){
            if(root==null) {System.out.println("null");
                return;}
            List<String> res=new ArrayList<>();
            Deque<TreeNode> deque=new LinkedList<>();
            deque.offerFirst(root);
            while(!deque.isEmpty()){
                TreeNode node=deque.pollFirst();
                if(node==null){
                    res.add("null");
                }else{
                    res.add(String.valueOf(node.val));
                    deque.add(node.left);
                    deque.add(node.right);
                }
            }
            int last=res.size()-1;
            while(last>=0&&res.get(last).equals("null")) last--;
            for(int i=0;i<=last;i++){
                if(i<last) System.out.print(res.get(i)+",");
                else System.out.println(res.get(i));
            }
        }

        static TreeNode createTree(Integer[] vals){
            if(vals.length==0) return null;
            Deque<TreeNode> deque=new ArrayDeque<>();
            TreeNode root=new TreeNode(vals[0]);
            deque.offerFirst(root);
            int i=1;
            while(!deque.isEmpty()&&i<vals.length){
                TreeNode node=deque.pollFirst();
                if(i<vals.length&&vals[i]!=null){
                    node.left=new TreeNode(vals[i]);
                    deque.offerLast(node.left);
                }
                i++;
                if(i<vals.length&&vals[i]!=null){
                    node.right=new TreeNode(vals[i]);
                    deque.offerLast(node.right);
                }
                i++;
            }return root;
        }
        public static void main(String[] args){
            TreeNode testNode=createTree(new Integer[]{3,9,20,null,null,15,7});
            printTree(testNode);
        }
    }
}
