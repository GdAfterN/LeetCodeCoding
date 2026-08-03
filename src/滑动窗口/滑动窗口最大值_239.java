package 滑动窗口;

import java.util.*;

//给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。
//你只可以看到滑动窗口中的 k 个数字。滑动窗口每次只向右移动一位。
//返回 滑动窗口中的最大值。
public class 滑动窗口最大值_239 {
    static class Solution{
        static int[] maxSlidingWindow(int[] nums,int k){
            // 使用双端队列，可以操控队头和队尾
            int[] res=new int[nums.length-k+1];
            Deque<Integer> deque=new ArrayDeque<>();
            for(int i=0;i<nums.length;i++){
                while(!deque.isEmpty()&&deque.peekFirst()<i-k+1) deque.pollFirst();
                while(!deque.isEmpty()&&nums[deque.peekLast()]<nums[i]) deque.pollLast();
                deque.offerLast(i);
                if(i-k+1>=0) res[i-k+1]=nums[deque.peekFirst()]; //别忘了是数值！
            }
            return res;
        }

        public static void main(String[] args){
            int[] nums=new int[]{1,3,-1,-3,5,3,6,7};
            System.out.println(Arrays.toString(maxSlidingWindow(nums,3)));
        }
    }
}
