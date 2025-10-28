// User function Template for Java

class Solution {
    static int knapSack(int val[], int wt[], int capacity) {
        // code here
        int[] dp = new int[capacity + 1];

        for (int i = 0; i < val.length; i++) {
            for (int j = wt[i]; j <= capacity; j++) {
                dp[j] = Math.max(dp[j], val[i] + dp[j - wt[i]]);
            }
        }

        return dp[capacity];
    }
}