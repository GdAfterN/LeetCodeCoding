package 二叉树;
import java.util.*;
//给你一棵二叉树的根节点 root，返回该树的直径。
//二叉树的直径是树中任意两个节点之间最长路径的长度，这条路径可能经过也可能不经过根节点。
//两节点之间路径的长度由它们之间边的数目表示。
public class 二叉树的直径_543 {
    static class Solution{
        static class TreeNode{
            int val;
            TreeNode left,right;

            TreeNode(){}

            TreeNode(int val){
                this.val=val;
            }

            TreeNode(int val,TreeNode left,TreeNode right){
                this.val=val;
                this.left=left;
                this.right=right;
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
        static int res;
        static int maxLength(TreeNode root){
            res=0;
            maxDepth(root);
            return res;
        }

        static int maxDepth(TreeNode root){
            if(root==null) return 0;
            int left=maxDepth(root.left);
            int right=maxDepth(root.right);
            res=Math.max(left+right,res);
            return Math.max(left,right)+1;
        }
    }
}
