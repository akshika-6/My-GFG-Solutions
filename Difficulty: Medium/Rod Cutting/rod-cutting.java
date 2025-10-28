class Solution {
    public int cutRod(int[] price) {
        // code here
        int n = price.length;
        int[] dp = new int[n + 1]; // dp[i] = max profit for rod length i

        for (int i = 0; i < n; i++) { // each piece (like item)
            for (int j = i + 1; j <= n; j++) { // capacity from piece length to n
                dp[j] = Math.max(dp[j], price[i] + dp[j - (i + 1)]);
            }
        }

        return dp[n];
    }
}