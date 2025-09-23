// User function Template for Java
class Solution {
    int minCost(int[] height) {
        // code here
        int n=height.length;
        int[] memo = new int[n];
        Arrays.fill(memo, -1);
        return jump(n - 1, height, memo);
    }

    private int jump(int i, int[] height, int[] memo) {
        if (i == 0) return 0; // base case: first stair, cost 0
        if (memo[i] != -1) return memo[i];

        // Jump from i-1
        int cost1 = jump(i - 1, height, memo) + Math.abs(height[i] - height[i - 1]);

        // Jump from i-2 (if valid)
        int cost2 = Integer.MAX_VALUE;
        if (i > 1) {
            cost2 = jump(i - 2, height, memo) + Math.abs(height[i] - height[i - 2]);
        }

        memo[i] = Math.min(cost1, cost2);
        return memo[i];
    }
}