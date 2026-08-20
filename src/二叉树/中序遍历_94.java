package 二叉树;

import java.util.*;

//给定一个二叉树的根节点 root，返回它的中序遍历结果。
public class 中序遍历_94 {
    static class Solution{
        static class TreeNode{
            int val;
            TreeNode left,right;
            public TreeNode(){}
            public TreeNode( int val){this.val=val;}
        }

        static TreeNode createTree(Integer[] vals){
            Deque<TreeNode> deque=new ArrayDeque<>();
            TreeNode root=new TreeNode(vals[0]);
            int index=1;
            deque.offerLast(root);
            while(!deque.isEmpty()&&index<vals.length){
                TreeNode node=deque.pollFirst();
                if(vals[index]!=null){
                    node.left=new TreeNode(vals[index]);
                    deque.offerLast(node.left);
                }
                index++;
                if(index<vals.length&&vals[index]!=null){
                    node.right=new TreeNode(vals[index]);
                    deque.offerLast(node.right);
                }
                index++;
            }return root;
        }

        static void printTree(TreeNode root){
            Deque<TreeNode> deque=new LinkedList();
            List<String> res=new ArrayList<>();
            deque.offerLast(root);
            while(!deque.isEmpty()){
                TreeNode node=deque.pollFirst();
                if(node==null){
                    res.add("null");
                }
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
                if(i==last) System.out.println(res.get(i));
                else System.out.print(res.get(i)+',');
            }
        }
        static List<Integer> res=new ArrayList<>();
        static List<Integer> midTraverse(TreeNode root){
            res.clear();
            traverse(root);
            return res;
        }
        static void traverse(TreeNode root){
            if(root==null) return;
            traverse(root.left);
            res.add(root.val);
            traverse(root.right);
        }
    }
}
