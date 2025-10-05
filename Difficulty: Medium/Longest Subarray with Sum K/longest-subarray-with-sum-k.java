// User function Template for Java

class Solution {
    public int longestSubarray(int[] arr, int k) {
        // code here
        Map<Integer,Integer> map=new HashMap<>();
        int res=0;
        int presum=0;
        int n=arr.length;
        for(int i=0;i<n;i++){
            presum+=arr[i];
            if(presum == k){
                res=i+1;
            }
            else if(map.containsKey(presum-k)){
                res = Math.max(res,i-map.get(presum-k));
            }
            if(!map.containsKey(presum)){
                map.put(presum,i);
            }
        }
        return res;
    }
}
