package 回溯;
import java.util.*;
public class 全排列_46 {
    public static class Solution{
        static List<List<Integer>> res=new ArrayList<>();
        static List<List<Integer>> permute(int[] nums){
            if(nums.length==0) return res;
            boolean[] used=new boolean[nums.length];
            traverse(nums,used,new ArrayList<>());
            return res;
        }
        static void traverse(int[] nums,boolean[] used,List<Integer> route){
            if(route.size()==nums.length){
                res.add(new ArrayList<>(route));
                return;
            }
            for(int i=0;i<nums.length;i++){
                if(used[i]) continue;
                route.add(nums[i]);
                used[i]=true;
                traverse(nums,used,route);
                route.removeLast();
                used[i]=false;
            }
        }
        public static void main(String[] args){
            int[] test=new int[]{0,1};
            System.out.println(permute(test));
        }
    }
}
