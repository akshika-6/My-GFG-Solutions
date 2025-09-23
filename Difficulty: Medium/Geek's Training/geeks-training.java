// User function Template for Java

class Solution {
    public int maximumPoints(int arr[][]) {
        // code here
        int n=arr.length;
        int[][] memo = new int[n][4];
        for (int[] row : memo) Arrays.fill(row, -1);
        return solve(n - 1, 3, arr, memo);
    }

    private int solve(int day, int last, int[][] arr, int[][] memo) {
        // Base case: first day
        if (day == 0) {
            int best = 0;
            for (int task = 0; task < 3; task++) {
                if (task != last) {
                    best = Math.max(best, arr[0][task]);
                }
            }
            return best;
        }

        // Already computed?
        if (memo[day][last] != -1) return memo[day][last];

        int best = 0;
        // Try all activities except the one done yesterday
        for (int task = 0; task < 3; task++) {
            if (task != last) {
                int points = arr[day][task] + solve(day - 1, task, arr, memo);
                best = Math.max(best, points);
            }
        }

        return memo[day][last] = best;
    }
}