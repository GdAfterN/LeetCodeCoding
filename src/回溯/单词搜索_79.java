package 回溯;
//给定一个 m x n 二维字符网格 board 和一个字符串单词 word。
//如果 word 存在于网格中，返回 true；否则，返回 false。
//单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。
//同一个单元格内的字母不允许被重复使用。
public class 单词搜索_79 {
    static class Solution{
        static boolean search(char[][] board,String word){
            int m=board.length,n=board[0].length;
            boolean[][] used=new boolean[m][n];
            for(int i=0;i<m;i++){
                for(int j=0;j<n;j++){
                    if(traverse(board,word,used,0,i,j)) return true;
                }
            }
            return false;
        }

        static boolean traverse(char[][] board,String word,boolean[][] used,int index,
                                int row,int col){
            if(index==word.length()) return true;
            if(row<0||row>=board.length||col<0||col>=board[0].length||used[row][col]||
            word.charAt(index)!=board[row][col]) return false;
            used[row][col]=true;
            boolean flag=traverse(board,word,used,index+1,row+1,col)||traverse(board,word,used,index+1,row-1,col)||
                    traverse(board,word,used,index+1,row,col+1)||traverse(board,word,used,index+1,row,col-1);
            used[row][col]=false;   //重要！不要忘记回溯
            return flag;
        }

        public static void main(String[] args){
            char[][] board=new char[][]{
                    {'A','B','C','E'},
                    {'S','F','C','S'},
                    {'A','D','E','E'}
            };
            System.out.println(search(board,"ABCCED"));
            System.out.println(search(board,"SEE"));
            System.out.println(search(board,"ABCB"));
        }
    }
}
