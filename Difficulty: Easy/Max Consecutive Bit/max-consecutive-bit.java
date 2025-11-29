class Solution {
    public int maxConsecBits(int[] arr) {
        // code here
        if(arr.length == 0) return 0;
        
        int maxc=0,c=0,prev=-1;
        for(int num:arr){
            if((prev^num) == 0){
                c++;
            } else{
                maxc=Math.max(maxc,c);
                c=1;
            }
            prev = num;
        }
        return Math.max(maxc,c);
    }
}
