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

//        static TreeNode createTree(Integer[] vals){
//            if(vals.length==0) return null;
//            Deque<TreeNode> deque=new ArrayDeque<>();
//            TreeNode root=new TreeNode(vals[0]);
//            deque.addFirst(root);
//            int i=1;
//            while(!deque.isEmpty()&&i<vals.length){
//                TreeNode node=deque.pollFirst();
//                if(vals[i]!=null){
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

        static TreeNode buildTree(int[] inOrder,int[] preOrder){
            Map<Integer,Integer> map=new HashMap<>();
            for(int i=0;i<inOrder.length;i++){
                map.put(inOrder[i],i);
            }
            TreeNode root=build(preOrder,0,preOrder.length-1,0,inOrder.length-1,map);
            return root;

        }

        static TreeNode build(int[] preOrder,int preLeft,int preRight,int inLeft,int inRight,Map<Integer,Integer> map){
                    if(preLeft>preRight) return null;
                    int rootVal=preOrder[preLeft];
                    TreeNode root=new TreeNode(rootVal);
                    int inRoot=map.get(rootVal);
                    int leftLen=inRoot-inLeft;
                    root.left=build(preOrder,preLeft+1,preLeft+leftLen,inLeft,inRoot-1,map);
                    root.right=build(preOrder,preLeft+leftLen+1,preRight,inRoot+1,inRight,map);
                    return root;
        }

        public static void main(String[] args){
                    int[] pre=new int[]{3,9,20,15,7};
                    int[] in=new int[]{9,3,15,20,7};
                    printTree(buildTree(in,pre));
        }

    }
}
