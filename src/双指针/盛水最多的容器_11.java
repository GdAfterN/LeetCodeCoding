package 双指针;
import java.util.*;
public class 盛水最多的容器_11 {
    static class Solution{
       static int maxArea(int[] height){
           int left=0,right=height.length-1;
           int res=0;
           while(left<right){
               res=Math.max(res,Math.min(height[left],height[right])*(right-left));
               if(height[left]<=height[right]) left++;
               else right--;
           }return res;
       }

       public static void main(String[] args){
           int[] test=new int[]{1,8,6,2,5,4,8,3,7};
           System.out.println(maxArea(test));
       }
    }
}
