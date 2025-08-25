class Solution {
    public ArrayList<Integer> kLargest(int[] arr, int k) {
        // Your code here
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> a-b);
        for(int i=0;i<arr.length;i++){
            pq.add(arr[i]);
            if(pq.size() > k){
                pq.poll();
            }
        }
        ArrayList<Integer> res = new ArrayList<>();
        while(pq.size() > 0){
            res.add(pq.poll());
        }
        Collections.reverse(res);
        return res;
    }
}
