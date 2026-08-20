package 二分查找;
// TODO 重要
public class 搜索旋转排序数组_33 {
    static class Solution{
        static int search(int[] nums,int target){
            int left=0,right=nums.length-1;
            while(left<=right){
                int mid=(left+right)/2;
                // 先确认是否相等
                // 一定要使用>=比较，避免陷入死循环
                if(nums[mid]>=nums[left]){
                    if(nums[left]<=target&&nums[mid]>target) right=mid-1;
                    else left=mid+1;
                }
                else {
                    if (nums[right] >= target && nums[mid] < target) left = mid + 1;
                    else right=mid-1;
                }
            }
            return -1;
        }

        public static void main(String[] args){
            int[] nums=new int[]{4,5,6,7,0,1,2};
            System.out.println(search(nums,2));
        }

    }
}
