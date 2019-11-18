class Solution {
    public static int maxProfit(int[] prices) {
        if(prices.length<2)return 0;
        int fstBuy = prices[0], fstSell = 0;
        int secBuy = Integer.MIN_VALUE, secSell = 0;
        //必须选择先sell，因为可以选择先sell然后buy
        for(int index=1;index<prices.length;index++){
            fstBuy = Math.min(fstBuy,prices[index]);
            fstSell = Math.max(fstSell,prices[index] - fstBuy);
            secBuy = Math.max(secBuy,fstSell - prices[index]);
            secSell = Math.max(secSell,secBuy + prices[index]);
            
        }
        return secSell;
    }
    public static void main(String[] args) {
        int[] test = new int[]{7,1,5,3,6,4};
        System.out.println(Solution.maxProfit(test));
    }
}