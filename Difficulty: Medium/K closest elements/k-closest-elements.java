class Solution {
    int[] printKClosest(int[] arr, int k, int x) {
        // code here
        PriorityQueue<int[]> pq = new PriorityQueue<>
        ((a, b) -> b[0] == a[0] ? a[1] - b[1] : b[0] - a[0]);
        for(int i=0; i<arr.length; i++) {
            if(arr[i]!=x) {
            int dis = Math.abs(arr[i] - x);
            pq.add(new int[]{dis, arr[i]});
            if(pq.size()>k)
                pq.poll();
            }
        }
        
        int res[] = new int[k];
        int ind = 0;
        while(pq.size()>0) {
            res[ind++] = pq.poll()[1];
        }
        
        for(int i = 0, j = res.length - 1; i < j; i++, j--) {
            int temp = res[i];
            res[i] = res[j];
            res[j] = temp;
        }
        
        return res;
    }
}
   