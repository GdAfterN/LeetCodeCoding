package 动态规划;

public class 打家劫舍_198 {
    static class Solution{
        static int rob(int[] nums){
            int[] dp=new int[nums.length+1];
            dp[1]=nums[0];
            for(int i=2;i<=nums.length;i++){
                dp[i]=Math.max(dp[i-1],dp[i-2]+nums[i-1]);
            }
            return dp[nums.length];
        }
        public static void main(String[] args){
            int[] test1=new int[]{1,2,3,1};
            System.out.println(rob(test1));
        }
    }
}
