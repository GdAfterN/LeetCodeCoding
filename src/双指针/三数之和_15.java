package 双指针;
import java.util.*;
public class 三数之和_15 {
    static class Solution{
        static List<List<Integer>> ThreeSum(int[] nums){
            List<List<Integer>> res=new ArrayList<>();
            if(nums.length<3) return res;
            Arrays.sort(nums); //注意要排序！
            for(int i=0;i<nums.length-2;i++){
                if(nums[i]>0) break;
                if(i>0&&nums[i-1]==nums[i]) continue;
                int j=i+1,k=nums.length-1;
                while(j<k){
                    int sum=nums[j]+nums[k];
                    if(sum<-nums[i]) j++;
                    else if(sum>-nums[i]) k--;
                    else{
                        res.add(new ArrayList(Arrays.asList(nums[i],nums[j],nums[k]))); //重点
                        j++;k--;
                        while(j<k&&nums[j-1]==nums[j]) j++;
                        while(j<k&&nums[k+1]==nums[k]) k--;
                    }
                }
            }return res;
        }
        public static void main(String[] args){
            int[] test=new int[]{0,1,1};
            System.out.println(ThreeSum(test));
        }
    }
}
