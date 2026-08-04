package 回溯;
import java.util.*;
public class 子集_78 {
    static class Solution{
        static List<List<Integer>> subsets(int[] nums){
            List<List<Integer>> res=new ArrayList<>();
            List<Integer> route=new ArrayList<>();
            traverse(nums,0,res,route);
            return res;
        }
        static void traverse(int[] nums,int index,List<List<Integer>> res,List<Integer> route){
            res.add(new ArrayList<>(route));
            for(int i=index;i<nums.length;i++){
                route.add(nums[i]);
                traverse(nums,i+1,res,route);
                route.removeLast();
            }
        }

        public static void main(String[] args){
            int[] nums=new int[]{1,2,3,4,5};
            System.out.println(subsets(nums));
        }
    }
}
