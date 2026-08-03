package 动态规划;

public class 编辑距离_72 {
    //    给你两个单词 word1 和 word2， 请返回将 word1 转换成 word2 所使用的最少操作数  。
//
//    你可以对一个单词进行如下三种操作：
//    1.插入一个字符
//    2.删除一个字符
//    3.替换一个字符
    static class Solution {
        static int minDistance(String s1, String s2) {
            int m=s1.length(),n=s2.length();
            int[][] dp=new int[m+1][n+1];

            //初始化的是第0列和第0行，实际执行从第1列和第1行开始
            for(int i=1;i<=m;i++) dp[i][0]=i;
            for(int i=1;i<=n;i++) dp[0][i]=i;
            for(int i=1;i<=m;i++){
                for(int j=1;j<=n;j++){
                    if(s1.charAt(i-1)==s2.charAt(j-1)) dp[i][j]=dp[i-1][j-1];
                    else dp[i][j]=1+Math.min(
                            dp[i][j-1],Math.min(dp[i-1][j],dp[i-1][j-1]) //使用min而非max
                    );
                }
            }return dp[m][n];
        }

        public static void main(String[] args){
            String word1 = "horse", word2 = "ros";
            System.out.println(minDistance(word1,word2));
        }
    }
}