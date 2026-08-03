package 滑动窗口;

import java.util.*;

public class 无重复字符的最长子串_3 {
    static class Solution{
        static int lengthOfLongestSubstring(String s){
            int res=0;
            Set<Character> set=new HashSet<>();
            int slow=0,fast=0;
            while(fast<s.length()){
                if(!set.contains(s.charAt(fast))){
                    set.add(s.charAt(fast));
                    res=Math.max(res,fast-slow+1);
                    fast++;
                }else{
                    set.remove(s.charAt(slow));
                    slow++;
                }
            }return res;
        }
        public static void main(String[] args){
            String s1="abcabcbb";
            System.out.println(lengthOfLongestSubstring(s1));
        }
    }
}
