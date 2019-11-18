class Solution {
    public static int maxProfit(int[] prices) {
        if(prices.length<2)return 0;
        int buy = -prices[0],sell = 0;
        //必须选择先sell，因为可以选择先sell然后buy
        for(int index=1;index<prices.length;index++){
            sell = Math.max(sell,prices[index]+buy);
            buy = Math.max(buy, sell-prices[index]);
            
        }
        return sell;
    }
    public static void main(String[] args) {
        int[] test = new int[]{7,1,5,3,6,4};
        System.out.println(Solution.maxProfit(test));
    }
}