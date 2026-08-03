package 双指针;

import java.util.Arrays;

public class 移动零_283 {
    static class Solution{
        static void removeZero(int[] nums){
            int slow=0,fast=0;
            while(fast<nums.length){
                // 仅在nums[fast]不为0时，slow前进，交换位置。
                if(nums[fast]!=0){
                    int temp=nums[slow];
                    nums[slow]=nums[fast];
                    nums[fast]=temp;
                    slow++;
                }fast++;
            }
        }

        public static void main(String[] args){
            int[] test=new int[]{0,1,0,3,12};
            removeZero(test);
            System.out.println(Arrays.toString(test));
        }
    }
}
