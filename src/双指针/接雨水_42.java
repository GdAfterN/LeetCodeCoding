package 双指针;

public class 接雨水_42 {
    public static class Solution{
        static int trap(int[] height){
            int res=0;
            int[] preMax=new int[height.length];
            int[] nextMax=new int[height.length];
            for(int i=1;i<height.length;i++){
                preMax[i]=Math.max(preMax[i-1],height[i-1]);
            }
            for(int i=height.length-2;i>=0;i--){
                nextMax[i]=Math.max(nextMax[i+1],height[i+1]);
            }
            for(int i=0;i<height.length;i++){
                if(Math.min(preMax[i],nextMax[i])-height[i]>0) res+=Math.min(preMax[i],nextMax[i])-height[i];
            }return res;
        }
        public static void main(String[] args){
            int[] height=new int[]{4,2,0,3,2,5};
            System.out.println(trap(height));
        }
    }
}
