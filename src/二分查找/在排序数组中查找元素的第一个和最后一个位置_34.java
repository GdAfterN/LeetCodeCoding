package 二分查找;
import java.util.*;
//给你一个按照非递减顺序排列的整数数组 nums 和一个目标值 target。
//请找出 target 在数组中的开始位置和结束位置；如果数组中不存在 target，返回 [-1,-1]。
//TODO 必须设计并实现时间复杂度为 O(log n) 的算法。

public class 在排序数组中查找元素的第一个和最后一个位置_34 {
    static class Solution{
        static int[] search(int[] nums,int target){
//            if(nums.length==0) return new int[]{-1,-1};
//            int left=0,right=nums.length-1;
//            while(left<=right){
//                int mid=(left+right)/2;
//                if(nums[mid]<target) left=mid+1;
//                else if(nums[mid]>target) right=mid-1;
//                else{
//                    int resLeft=mid,resRight=mid;
//                    while(resLeft>0&&nums[resLeft-1]==nums[resLeft]) resLeft--;
//                    while(resRight<nums.length-1&&nums[resRight+1]==nums[resRight]) resRight++;
//                    return new int[]{resLeft,resRight};
//                }
//            }
//            return new int[]{-1,-1};
            // 不符合O(lgn)复杂度要求

        return new int[]{searchLeft(nums,target),searchRight(nums,target)};

        }
        static int searchRight(int[] nums,int target){
            int left=0,right=nums.length-1;
            int res=-1;
            while(left<=right){
                int mid=(left+right)/2;
                if(nums[mid]>=target){
                    right=mid-1;
                    if(nums[mid]==target) res=mid;  // 将这一步也优化成了二分查找
                }else left=mid+1;
            }return res;
        }

        static int searchLeft(int[] nums,int target){
            int left=0,right=nums.length-1;
            int res=-1;
            while(left<=right){
                int mid=left+(right-left)/2;
                if(nums[mid]<=target){
                    left=mid+1;                     //
                    if(nums[mid]==target) res=mid;  // 命中就记录
                }else{
                    right=mid-1;
                }
            }
            return res;

        }


        public static void main(String[] args){
            int[] test=new int[]{0,1,1,3,6,7};
            System.out.println(Arrays.toString(search(test,1)));
        }
    }
}
