package 动态规划;

public class 最长公共子序列_1143 {
    static class Solution{

        static int longestCommonSubsequence(String s1,String s2){
            if(s1.length()==0||s2.length()==0) return 0;
            int m=s1.length(),n=s2.length();
            int[][] dp=new int[m+1][n+1];
            for(int i=1;i<=m;i++){
                for(int j=1;j<=n;j++){
                    if(s1.charAt(i-1)==s2.charAt(j-1)) dp[i][j]=dp[i-1][j-1]+1;
                else dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]); //注意在i和j位置上字符不相等时的推导公式
                }
            }return dp[m][n];
        }

        public static void main(String[] args){
           String text1 = "abcde", text2 = "ace";
           System.out.println(longestCommonSubsequence(text1,text2));
        }
    }
}
