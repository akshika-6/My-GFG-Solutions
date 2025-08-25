// User function Template for Java

class Solution {
    public static int kthSmallest(int[] arr, int k) {
        // Your code here
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> a-b);
        for(int i=0;i<arr.length;i++){
            pq.add(arr[i]*-1);
            if(pq.size() > k){
                pq.poll();
            }
        }
        return pq.poll()*-1;
    }
}
