class Solution {
    public int getMinDiff(int[] arr, int k) {
        // code here
        int n=arr.length;
        Arrays.sort(arr);
        int res=arr[n-1]-arr[0];
        for(int i=1;i<arr.length;i++){
            if(arr[i]-k < 0){
                continue;
            }
            int min = Math.min(arr[0]+k,arr[i]-k);
            int max = Math.max(arr[i-1]+k,arr[n-1]-k);
            res = Math.min(res,max-min);
        }
        return res;
    }
}
