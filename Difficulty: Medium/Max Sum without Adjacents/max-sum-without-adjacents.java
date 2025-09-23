// User function Template for Java

class Solution {
    int findMaxSum(int arr[]) {
        // code here
        int n=arr.length;
        int[] m=new int[n];
        Arrays.fill(m,-1);
        int c = helper(0,n,m,arr);
        return c;
    }
    public static int helper(int i,int n,int[] m,int[] arr){
        if(i == n){
            return m[n-1];
        }
        if(i == 0){
            m[0] = arr[i];
            return helper(i+1,n,m,arr);
        }
        if(i == 1){
            m[1] = Math.max(arr[0],arr[1]);
            return helper(i+1,n,m,arr);
        }
        m[i]=Math.max(m[i-2]+arr[i],m[i-1]);
        return helper(i+1,n,m,arr);
    }
}