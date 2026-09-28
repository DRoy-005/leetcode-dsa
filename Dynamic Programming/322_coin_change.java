class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        int impossible = amount + 1;

        for(int i = 1; i<= amount; i++){
            dp[i] = impossible;
            for(int coin : coins){
                if(coin <= i){
                    dp[i] = Math.min(dp[i], dp[i - coin]+1);
                }
            }
        }
        return dp[amount] == impossible ? -1 : dp[amount];
    }
}