// User function Template for Java

class Solution {
    // Function for adding one to the number represented by the array
    Vector<Integer> addOne(int[] arr) {
        // code here
        Vector<Integer> res=new Vector<>();
        int n=arr.length;
        int carry = 1;
        for(int i=n-1;i>=0;i--){
            int sum = arr[i] + carry;
            res.add(sum%10);
            carry=sum/10;
        }
        if(carry > 0){
            res.add(carry);
        }
        Collections.reverse(res);
        return res;
    }
}