package 动态规划;
import java.util.*;
//给你一个字符串 s 和一个字符串列表 wordDict 作为字典。如果可以利用字典中出现的一个或多个单词拼接出 s 则返回 true。
//
//注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。
public class 单词拆分_139 {
    static class Solution{
        static boolean wordBreak(String s, List<String> wordDict){
            Set<String> set=new HashSet<>(wordDict);
            boolean[] dp=new boolean[s.length()+1];
            dp[0]=true;
            for(int i=1;i<=s.length();i++){
                for(int j=0;j<i;j++){
                    dp[i]=dp[j]&&set.contains(s.substring(j,i));
                    if(dp[i]) break;
                }
            }
            return dp[s.length()];
        }

        public static void main(String[] args){
            String s="leetcode";
            List<String> wordDict=List.of("leet","code");
            System.out.println(wordBreak(s,wordDict));
        }
    }
}
