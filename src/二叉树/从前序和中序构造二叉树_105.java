package 二叉树;
import java.util.*;
// TODO 易错题
public class 从前序和中序构造二叉树_105 {
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
            deque.offerLast(root);
            int index=1;
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
            }
            return root;
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
            while(last>=0&&res.get(last).equals("null")) last--;
            for(int i=0;i<=last;i++){
                if(i==last) System.out.println(res.get(last));
                else System.out.print(res.get(i)+',');
            }
        }

        static TreeNode build(int[] preOrder,int[] inOrder){
                    Map<Integer,Integer> map=new HashMap<>();
                    for(int i=0;i<inOrder.length;i++){
                        map.put(inOrder[i],i);
                    }
                    return buildTree(preOrder,0,preOrder.length-1,0,inOrder.length-1,map);
        }

        static TreeNode buildTree(int[] preOrder,int preLeft,int preRight,int inLeft,int inRight,Map<Integer,Integer> map){
                    if(preLeft>preRight) return null;
                    TreeNode root=new TreeNode(preOrder[preLeft]);
                    int inRoot=map.get(root.val);
                    int left=inRoot-inLeft;
                    root.left=buildTree(preOrder,preLeft+1,preLeft+left,inLeft,inRoot-1,map);
                    root.right=buildTree(preOrder,preLeft+left+1,preRight,inRoot+1,inRight,map);
                    return root;
        }



        public static void main(String[] args){
                    int[] pre=new int[]{3,9,20,15,7};
                    int[] in=new int[]{9,3,15,20,7};
                    printTree(build(pre,in));
        }

    }
}
