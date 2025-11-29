class Solution {
    static ArrayList<Integer> leaders(int arr[]) {
        // code here
        ArrayList<Integer> res=new ArrayList<>();
        int n=arr.length;
        int max=arr[n-1];
        res.add(max);
        for(int i = n-2;i>=0;i--){
            if(arr[i] >= max){
                max=arr[i];
                res.add(max);
            }
        }
        Collections.reverse(res);
        return res;
    }
}
