class Solution {
    public ArrayList<Integer> topKFrequent(int[] arr, int k) {
        // Your code here
        Map<Integer,Integer> freq=new HashMap<>();
        for(int ele: arr){
            freq.put(ele,freq.getOrDefault(ele,0)+1);
        }
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b) -> a[1]==b[1]? a[0] - b[0] : a[1] - b[1]);
        for(Map.Entry<Integer,Integer> entry: freq.entrySet()){
            int ele = entry.getKey();
            int count = entry.getValue();
        
        pq.add(new int[]{ele,count});
        if(pq.size() > k){
            pq.poll();
        }
        }
        ArrayList<Integer> res=new ArrayList<>();
        while(pq.size() > 0){
            int[] pair = pq.poll(); // pair[0] = element, pair[1] = frequency
            res.add(pair[0]);
        }
        Collections.reverse(res);
        return res;
    }
    
    
    
    
    
    
    
}
