package 贪心算法;

public class 买卖股票的最佳时期_121 {
    public static class Solution{
        public static int maxProfit(int[] prices){
            if(prices.length==0) return 0;
            int minNow=prices[0];
            int res=0;
            for(int price:prices){
                res=Math.max(price-minNow,res);
                minNow=Math.min(minNow,price);
            }return res;
        }
        public static void main(String[] args){
            int[] test1=new int[]{7,6,4,3,1};
            System.out.println(maxProfit(test1));
        }
    }
}
