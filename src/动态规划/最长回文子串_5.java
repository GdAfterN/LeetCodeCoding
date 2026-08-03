package 动态规划;

public class 最长回文子串_5 {
    static class Solution{
       static String longestPalindrome(String s){
           int countMax=0;
           String res="";
            if(s.length()==0) return s;
            for(int i=0;i<s.length();i++){
                int biggerCount=Math.max(countLen(s,i,i),i<s.length()-1?countLen(s,i,i+1):0);
                if(biggerCount>countMax){
                    countMax=biggerCount;
                    int start=i-(countMax-1)/2; //重点公式，奇偶通用！
                    res=s.substring(start,start+countMax);
                }
            }
            return res;
       }
       static int countLen(String s,int left,int right){
           int res=0;
           if(left==right){
               res+=1;
               left--;
               right++;
           }
           while(left>=0&&right<s.length()){
               if(s.charAt(left)==s.charAt(right)){
                   left--;
                   right++;
                   res+=2;
               }else return res;
           }return res;
       }

       public static void main(String[] args){
           String s1="babad";
           System.out.println(longestPalindrome(s1));
       }
    }
}
