//        static class TreeNode{
//            int val;
//            TreeNode left,right;
//            public TreeNode(){};
//            public TreeNode(int val){this.val=val;};
//            public TreeNode(int val,TreeNode left,TreeNode right){
//                this.val=val;
//                this.left=left;
//                this.right=right;
//            }
//        }
//
//        static TreeNode createTree(Integer[] vals){
//            if(vals.length==0) return null;
//            Deque<TreeNode> deque=new ArrayDeque<>();
//            TreeNode root=new TreeNode(vals[0]);
//            deque.addFirst(root);
//            int i=1;
//            while(!deque.isEmpty()&&i<vals.length){
//                TreeNode node=deque.pollFirst();
//                if(i<vals.length&&vals[i]!=null){
//                    node.left=new TreeNode(vals[i]);
//                    deque.offerLast(node.left);
//                }
//                i++;
//                if(i<vals.length&&vals[i]!=null){
//                    node.right=new TreeNode(vals[i]);
//                    deque.offerLast(node.right);
//                }
//                i++;
//            }
//            return root;
//        }
//
//        static void printTree(TreeNode root){
//            if(root==null) {
//                System.out.println("null");
//                return;
//            }
//            List<String> res=new ArrayList<>();
//            Deque<TreeNode> deque=new LinkedList<>();
//            deque.offerLast(root);
//            while(!deque.isEmpty()){
//                TreeNode node=deque.pollFirst();
//                if(node!=null){
//                    res.add(String.valueOf(node.val));
//                    deque.offerLast(node.left);
//                    deque.offerLast(node.right);
//                }
//                else{
//                    res.add("null");
//                }
//            }
//            int last=res.size()-1;
//            while(last>=0&&res.get(last).equals("null")){
//                last--;
//            }
//            for(int i=0;i<=last;i++){
//                if(i==last) System.out.println(res.get(i));
//                else System.out.print(res.get(i)+",");
//            }
//        }
package 二叉树;
import java.util.*;
public class 前序遍历_144 {
    static class Solution{
        static class TreeNode{
            int val;
            TreeNode left,right;
            public TreeNode(){};
            public TreeNode(int val){this.val=val;};
            public TreeNode(int val,TreeNode left,TreeNode right){
                this.val=val;
                this.left=left;
                this.right=right;
            }
        }

        static TreeNode createTree(Integer[] vals){
            if(vals.length==0) return null;
            Deque<TreeNode> deque=new ArrayDeque<>();
            TreeNode root=new TreeNode(vals[0]);
            deque.addFirst(root);
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
            }
            return root;
        }

        static void printTree(TreeNode root){
            if(root==null) {
                System.out.println("null");
                return;
            }
            List<String> res=new ArrayList<>();
            Deque<TreeNode> deque=new LinkedList<>();
            deque.offerLast(root);
            while(!deque.isEmpty()){
                TreeNode node=deque.pollFirst();
                if(node!=null){
                    res.add(String.valueOf(node.val));
                    deque.offerLast(node.left);
                    deque.offerLast(node.right);
                }
                else{
                    res.add("null");
                }
            }
            int last=res.size()-1;
            while(last>=0&&res.get(last).equals("null")){
                last--;
            }
            for(int i=0;i<=last;i++){
                if(i==last) System.out.println(res.get(i));
                else System.out.print(res.get(i)+",");
            }
        }
        static List<Integer> res=new ArrayList<>();
        static List<Integer> preorderTraversal(TreeNode root){
            traverse(root);
            return res;
        }
        static void traverse(TreeNode root){
            if(root==null) return;
            res.add(root.val);
            traverse(root.left);
            traverse(root.right);
        }

        public static void main(String[] args){
            Integer[] vals=new Integer[]{1,2,3,4,5,6};
            TreeNode root=createTree(vals);
            System.out.println(preorderTraversal(root));
        }
    }
}
