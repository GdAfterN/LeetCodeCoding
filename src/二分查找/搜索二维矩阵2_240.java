package 二分查找;

public class 搜索二维矩阵2_240 {
    static class Solution{
        static boolean searchMatrix(int[][] matrix, int target){
            int m=matrix.length,n=matrix[0].length;
            int row=0,col=n-1;
            while(row<m&&col>=0){
                if(matrix[row][col]<target) row++;
                else if(matrix[row][col]>target) col--;
                else return true;
            }
            return false;
        }
    }
}
