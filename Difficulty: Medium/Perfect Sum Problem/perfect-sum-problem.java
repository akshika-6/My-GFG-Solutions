class Solution {
    // Function to calculate the number of subsets with a given sum
    public int perfectSum(int[] nums, int target) {
        // code here
        int[] dp=new int[target+1];
        dp[0]=1;
        //dp[arr[0]]=1;
        for(int i=0;i<nums.length;i++){
            for(int j=target;j>=nums[i];j--){
                dp[j] = dp[j] + dp[j-nums[i]];
            }
        }
        return dp[target];
    }
}