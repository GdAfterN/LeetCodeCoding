package 二分查找;

public class 搜索插入位置_35 {
    static class Solution{
        static int searchInsert(int[] nums,int target){
            int left=0;
            int right=nums.length-1;
            while(left<=right){
                int mid=(left+right)/2;
                if(nums[mid]<target) left=mid+1;
                else if(nums[mid]>target) right=mid-1;
                else return mid;
            }
            return left;
        }
        public static void main(String[] args){
            int[] nums=new int[]{1,3,5,6};
            System.out.println(searchInsert(nums,2));
        }
    }
}
