package 二分查找;

public class 搜索二维矩阵_74 {
    static class Solution{
        // 思路：创建一维数组投影，但不能真的创建，否则会超过时间复杂度限制
        // 在while中将一维坐标转换为二维
        static boolean searchMatrix(int[][] matrix, int target){
            int m=matrix.length;
            int n=matrix[0].length;
            int left=0;
            int right=m*n-1;
            while(left<=right){
                int mid=(left+right)/2;
                // 核心：投影mid
                int row=mid/n;
                int col=mid%n;
                int val=matrix[row][col];
                if(target>val) left=mid+1;
                else if(target<val) right=mid-1;
                else return true;
            }
            return false;
        }

        public static void main(String[] args){
            int[][] nums=new int[][]{
                    new int[]{1,3,5,7},
                    new int[]{10,11,16,20},
                    new int[]{23,30,34,60}
            };
            System.out.println(searchMatrix(nums,3));
        }
    }
}
