class Solution {
    public static int minCost(int[] arr) {
        // code here
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for(int i: arr){
            pq.add(i);
        }
        int res = 0;;
        while(pq.size() > 1){
            int a = pq.poll();
            int b = pq.poll();
            int c= a+b;
            res+= c;
            pq.add(c);
        }
        return res;
    }
}