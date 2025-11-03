// User function Template for Java

class Solution {
    public int longestCommonSubstr(String text1, String text2) {
        // code here
        // int m = s1.length();
        // int n = s2.length();

        
        // int[] prev = new int[n + 1];
        
        // int res = 0;
        // for (int i = 1; i <= m; i++) {
          
            
        //     int[] curr = new int[n + 1];
        //     for (int j = 1; j <= n; j++) {
        //         if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
        //             curr[j] = prev[j - 1] + 1;
        //             res = Math.max(res, curr[j]);
        //         } else {
        //             curr[j] = 0;
        //         }
        //     }
          
            
        //     prev = curr;
        // }
        // return res;
        
        
        int m=text1.length();
        int n=text2.length();
        int[][] dp=new int[m+1][n+1];
        int max=0;
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(text1.charAt(i-1)==text2.charAt(j-1)){
                    dp[i][j]=1 + dp[i-1][j-1];
                    max=Math.max(max,dp[i][j]);
                }
                else{
                    dp[i][j]=0;
                }
            }
        }
        return max;
    }
}