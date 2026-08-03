package 动态规划;
import java.util.*;
public class 不同路径_62 {

    static class Solution{
        static int uniquePaths(int m,int n){
            int[] dp=new int[n+1];
            Arrays.fill(dp,1);
            dp[0]=0;
            for(int i=1;i<m;i++){
                for(int j=1;j<=n;j++){
                    dp[j]=dp[j]+dp[j-1];
                }
            }return dp[n];
        }

        public static void main(String[] args){
            System.out.println(uniquePaths(3,7));
        }
    }
}
