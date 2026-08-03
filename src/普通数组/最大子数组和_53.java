package 普通数组;
import java.util.*;
public class 最大子数组和_53 {
    static class Solution{
        static int maxSubArray(int[] nums){
            int res=Integer.MIN_VALUE;
            int sum=0;
            for(int num:nums){
                if(sum<=0) sum=num;
                else sum+=num;
                res=Math.max(res,sum);
            }
            return res;
        }
        public static void main(String[] args){
            int[] test1=new int[]{-2,1,-3,4,-1,2,1,-5,4};
            System.out.println(maxSubArray(test1));
        }
    }
}
