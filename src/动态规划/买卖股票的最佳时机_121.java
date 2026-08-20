package 动态规划;

public class 买卖股票的最佳时机_121 {
    static class Solution{
        static int maxProfit(int[] prices){
           int res=0;
           int minNow=prices[0];
           for(int price:prices){
               res=Math.max(res,price-minNow);
               minNow=Math.min(price,minNow);
           }return res;
        }

        public static void main(String[] args){
            int[] vals=new int[]{7,1,5,3,6,4};
            System.out.println(maxProfit(vals));
        }
    }
}
