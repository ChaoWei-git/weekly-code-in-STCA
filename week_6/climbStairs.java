class Solution {
    public int climbStairs(int n) {
        int [] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 2;
        for(int i=2;i<=n;i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n-1];
    }
    
}
// class Solution {
//     public int climbStairs(int n) {
//         if (n == 1) {
//             return 1;
//         }
//         int a = 1;
//         int b = 2;
//         int temp = 0;
//         for(int i=2;i<n;i++){
//             temp = b + a;
//             a = b;
//             b = temp;
//         }
//         return b;
//     }
// }