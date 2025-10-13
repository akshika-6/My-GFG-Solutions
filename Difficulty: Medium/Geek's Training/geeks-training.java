// User function Template for Java

class Solution {
    public int maximumPoints(int arr[][]) {
        // code here
        int m=arr.length;
        int n=arr[0].length;
        int[][] d=new int[m][n];
        for(int j=0;j<n;j++){
            d[0][j]=arr[0][j];
        }
        for(int i=1;i<m;i++){
            for(int j=0;j<n;j++){
                int max=0;
                for(int k=0;k<=2;k++){
                    if(j != k){
                        max=Math.max(max,d[i-1][k]);
                    }
                }
                d[i][j]=max+arr[i][j];
            }
        }
        int max=0;
        for(int j=0;j<n;j++){
            max=Math.max(max,d[m-1][j]);
        }
        return max;
    }
}