class Solution {
    int minCost(int[] height) {
        // code here
        int n=height.length;
        int prev=0;
        int prev2=0;
        for(int i=1;i<n;i++){
            int jump2=Integer.MAX_VALUE;
            int jump1=prev+Math.abs(height[i]-height[i-1]);
            if(i>1){
                jump2=prev2+Math.abs(height[i]-height[i-2]);
            }
            int curr=Math.min(jump1,jump2);
            prev2=prev;
            prev=curr;
        }
        return prev;
    }
}