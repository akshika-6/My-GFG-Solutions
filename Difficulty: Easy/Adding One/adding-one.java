// User function Template for Java

class Solution {
    // Function for adding one to the number represented by the array
    Vector<Integer> addOne(int[] arr) {
        // code here
        Vector<Integer> result = new Vector<>();
        int n = arr.length;
        
        int carry = 1; // since we have to add 1
        
        // Traverse from the end
        for (int i = n - 1; i >= 0; i--) {
            int sum = arr[i] + carry;
            result.add(sum % 10); // store the last digit
            carry = sum / 10;     // carry will be 1 if sum = 10
        }
        
        // If carry is left (like in case of 999 → 1000)
        if (carry > 0) {
            result.add(carry);
        }
        
        // Now result is reversed (because we added from the end)
        Collections.reverse(result);
        
        return result;
    }
}