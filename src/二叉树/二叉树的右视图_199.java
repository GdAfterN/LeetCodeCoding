package 二叉树;
import java.util.*;
//给定一个二叉树的根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，
//返回从右侧所能看到的节点值。
public class 二叉树的右视图_199 {
    static class Solution{
        static class TreeNode{
            int val;
            TreeNode left,right;
            public TreeNode(){}
            public TreeNode(int val){
                this.val=val;
            }
        }

        //按照力扣层序数组创建二叉树
        static TreeNode createTree(Integer[] vals){
            if(vals.length==0||vals[0]==null) return null;

            Deque<TreeNode> deque=new ArrayDeque<>();
            // 第一个节点不可能为null，后面的节点需要考虑是否为null
            TreeNode root=new TreeNode(vals[0]);
            deque.offerLast(root);
            int i=1;	// 需要一个i来操作vals数组

            while(!deque.isEmpty()&&i<vals.length){
                TreeNode node=deque.pollFirst();

                // 构建左儿子，需要验证非空
                if(vals[i]!=null){
                    node.left=new TreeNode(vals[i]);
                    deque.offerLast(node.left);
                }
                i++;

                // 构建右儿子，需要验证i和非空
                if(i<vals.length&&vals[i]!=null){
                    node.right=new TreeNode(vals[i]);
                    deque.offerLast(node.right);
                }
                i++;
            }

            return root;
        }

        //按照力扣层序格式打印二叉树，并删除末尾多余的 null
        static void printTree(TreeNode root){
            if(root==null){
                System.out.println("null");
                return;
            }

            List<String> res=new ArrayList<>();
            //打印时需要把 null 子节点放入队列，所以使用允许 null 的 LinkedList
            Deque<TreeNode> deque=new LinkedList<>();
            deque.offerLast(root);

            while(!deque.isEmpty()){
                TreeNode node=deque.pollFirst();

                if(node!=null){
                    res.add(String.valueOf(node.val));
                    deque.offerLast(node.left);
                    deque.offerLast(node.right);
                }else{
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

        static List<Integer> rightPhe(TreeNode root){
            List<Integer> res=new ArrayList<>();
            Deque<TreeNode> deque=new ArrayDeque<>();
            deque.offerLast(root);
            while(!deque.isEmpty()){
                int size=deque.size();
                for(int i=0;i<size;i++){
                    TreeNode node=deque.pollFirst();
                    if(node.left!=null) deque.offerLast(node.left);
                    if(node.right!=null) deque.offerLast(node.right);
                    if(i==size-1) res.add(node.val);
                }
            }
            return res;
        }

        public static void main(String[] args){
            Integer[] vals=new Integer[]{1,2,3,null,5,null,4};
            TreeNode root=createTree(vals);
            System.out.println(rightPhe(root));
        }

    }
}
