package 回溯;
import java.util.*;
public class 组合总和_39 {
    static class Solution{
        static List<List<Integer>> res=new ArrayList<>();
        static List<List<Integer>> combinationSum(int[] candidates, int target){
            List<Integer> route=new ArrayList<>();
            reverse(candidates,target,0,route,0);
            return res;
        }
        static void reverse(int[] candidates,int target,int index,List<Integer> route,int sum){
            if(sum==target){
                res.add(new ArrayList<>(route));
                return;
            }
            if(sum>target) return;
            for(int i=index;i<candidates.length;i++){
                route.add(candidates[i]);
                sum+=candidates[i];
                reverse(candidates,target,i,route,sum);
                route.removeLast();
                sum-=candidates[i];
            }
        }

        public static void main(String[] args){
            int[] candidates1=new int[]{2,3,6,7};
            System.out.println(combinationSum(candidates1,7));

            int[] candidates2=new int[]{2,3,5};
            System.out.println(combinationSum(candidates2,8));
        }

    }
}
