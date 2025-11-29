class Solution {
    public void reverseArray(int arr[]) {
        // code here
        int n = arr.length;
        
        // Iterate over the first half 
        // and for every index i, swap
        // arr[i] with arr[n - i - 1]
        for (int i = 0; i < n / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[n - i - 1];
            arr[n - i - 1] = temp;
        }
    }
}