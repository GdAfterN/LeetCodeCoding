package 动态规划;
import java.util.*;
public class 不同路径_62 {

    static class Solution{
        static int uniquePaths(int m,int n){
            int[] dp=new int[n];
            Arrays.fill(dp,1);
            for(int i=1;i<m;i++){
                dp[0]=1;
                for(int j=1;j<n;j++){
                    dp[j]=dp[j]+dp[j-1];
                }
            }return dp[n-1];
        }

        public static void main(String[] args){
            System.out.println(uniquePaths(3,7));
        }
    }
}
