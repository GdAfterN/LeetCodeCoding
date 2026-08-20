package 二分查找;

public class 寻找旋转排序数组中的最小值_153 {
    static class Solution{
        static int findMin(int[] nums){
           int left=0,right=nums.length-1;
           while(left<right){
               int mid=(left+right)/2;
               if(nums[mid]>nums[right]) left=mid+1;
               else right=mid;
           }return left;
        }
        public static void main(String[] args){
            int[] nums=new int[]{3,4,5,1,2};
            System.out.println(findMin(nums));
        }
    }
}
