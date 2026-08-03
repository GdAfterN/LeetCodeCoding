package 动态规划;

public class 买卖股票的最佳时机_121 {
    static class Solution{
        static int maxProfit(int[] prices){
            int preMin=Integer.MAX_VALUE;
            int res=Integer.MIN_VALUE;
            for(int price:prices){
                preMin=Math.min(price,preMin);
                res=Math.max(res,price-preMin);
            }return res;
        }

        public static void main(String[] args){
            int[] vals=new int[]{7,1,5,3,6,4};
            System.out.println(maxProfit(vals));
        }
    }
}
