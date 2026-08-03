package 动态规划;
import java.util.*;
public class 最长递增子序列_300 {
    static class Solution{
        static int lengthOfLIS(int[] nums){
            if(nums.length==0) return 0;
            //dp数组只能保存某个位置上的最长递增子序列长度，返回值需要在dp数组中找最大值
            int res=1;
            int[] dp=new int[nums.length+1];
            Arrays.fill(dp,1);
            dp[0]=0;
            for(int i=1;i<=nums.length;i++){
                for(int j=1;j<i;j++){
                    if(nums[i-1]>nums[j-1]) dp[i]=Math.max(dp[i],dp[j]+1);
                }
                res=Math.max(dp[i],res);
            }return res;
        }

        public static void main(String[] args){
            int[] vals=new int[]{10,9,2,5,3,7,101,18};
            System.out.println(lengthOfLIS(vals));
        }
    }
}
