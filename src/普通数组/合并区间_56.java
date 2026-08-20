package 普通数组;
import java.util.*;
public class 合并区间_56 {
    public static class Solution{
        static int[][] merge(int[][] intervals){
            List<int[]> res=new ArrayList<>();
            Arrays.sort(intervals,(a,b)->a[0]-b[0]);
            int left=intervals[0][0],right=intervals[0][1];
            for(int i=1;i<intervals.length;i++){
                if(right>=intervals[i][0]) right=Math.max(intervals[i][1],right);
                else{
                    res.add(new int[]{left,right});
                    left=intervals[i][0];
                    right=intervals[i][1];
                }
            }
            res.add(new int[]{left,right});
            return res.toArray(new int[0][]);

        }
        public static void main(String[] args){
            int[][] test = {
                    new int[]{1, 3},
                    new int[]{2, 6},
                    new int[]{8, 10},
                    new int[]{15, 18}
            };
            System.out.println(Arrays.deepToString(merge(test)));
        }
    }
}
