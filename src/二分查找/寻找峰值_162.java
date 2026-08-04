package 二分查找;

//峰值元素是指其值严格大于左右相邻值的元素。
//
//给你一个整数数组 nums，找到峰值元素并返回其索引。数组可能包含多个峰值，在这种情况下，返回 任何一个峰值 所在位置即可。
//
//你可以假设 nums[-1] = nums[n] = -∞ 。
//
//你必须实现时间复杂度为 O(log n) 的算法来解决此问题。
public class 寻找峰值_162 {
    static class Solution{
        static int findPeakElement(int[] nums){
            // TODO核心思想：当nuns[mid]>nums[mid+1]时，[left,mid]之间必然有峰值。
            //若nums[mid-1]<nums[mid]，则mid为峰值
            //若nums[mid-1]>nums[mid]，从索引0开始必然有峰值
            int left=0,right=nums.length-1;
            // 题目要求至少有一个峰值，故必然会收敛到left=right
            while(left<right){
                int mid=(left+right)/2;
                if(nums[mid]>nums[mid+1]) right=mid;
                else left=mid+1;
            }
            return left;
        }

        public static void main(String[] args){
            int[] nums=new int[]{1,2,5,3,1};
            System.out.println(findPeakElement(nums));
        }
    }
}
