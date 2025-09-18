class Solution {
    public ArrayList<Integer> nextLargerElement(int[] arr) {
        // code here
        int n=arr.length;
        ArrayList<Integer> res=new ArrayList<>();
        ArrayDeque<Integer> st=new ArrayDeque<>();
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && st.peek() <= arr[i]){
                st.pop();
            }
            int x = st.isEmpty() ? -1 : st.peek();
            res.add(x);
            st.push(arr[i]);
        }
        Collections.reverse(res);
        return res;
    }
}