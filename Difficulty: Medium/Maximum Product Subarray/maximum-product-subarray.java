class Solution {
    int maxProduct(int[] arr) {
        // code here
        int n=arr.length;
        int maxp=Integer.MIN_VALUE;
        int lefttoright = 1;
        int righttoleft = 1;
        for(int i=0;i<n;i++){
            if(lefttoright == 0){
                lefttoright = 1;
            }
            if(righttoleft == 0){
                righttoleft = 1;
            }
            lefttoright *= arr[i];
            int j = n-i-1;
            righttoleft *= arr[j];
            maxp = Math.max(lefttoright,Math.max(maxp,righttoleft));
        }
        return maxp;
    }
}