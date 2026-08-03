package 图论;
import java.util.*;
public class 岛屿数量_200 {
    static class Solution{
        static int CountIslands(char[][] grid){
            int res=0;
            for(int i=0;i<grid.length;i++){
                for(int j=0;j<grid[0].length;j++){
                    if(grid[i][j]=='1'){
                        res+=1;
                        traverse(grid,i,j);
                    }
                }
            }return res;
        }
        static void traverse(char[][] grid,int row,int col){
            if(row<0||row>=grid.length||col<0||col>=grid[0].length||grid[row][col]!='1') return;
            grid[row][col]='2';
            traverse(grid,row-1,col);
            traverse(grid,row+1,col);
            traverse(grid,row,col-1);
            traverse(grid,row,col+1);
        }
        public static void main(String[] args){
            char[][] test1=new char[][]{
                    new char[]{'1','1','1','1','0'},
                    new char[]{'1','1','0','1','0'},
                    new char[]{'1','1','0','0','0'},
                    new char[]{'0','0','0','0','0'}
            };
            System.out.println(CountIslands(test1));
        }
    }
}
