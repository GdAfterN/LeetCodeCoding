package 二分查找;

public class 搜索二维矩阵2_240 {
    static class Solution{
        static boolean searchMatrix(int[][] matrix, int target){
            int row=0,col=matrix[0].length-1;
            while(row<matrix.length&&col>=0){
                if(matrix[row][col]>target) col--;
                else if(matrix[row][col]<target) row++;
                else return true;
            }
            return false;
        }
    }
}
