class Solution {
    // Function to remove duplicates from the given array.
    ArrayList<Integer> removeDuplicates(int[] arr) {
        // code here
        ArrayList<Integer> result = new ArrayList<>();
        int n = arr.length;
        if (n == 0) return result;
        
        result.add(arr[0]); // always include the first element

        for (int i = 1; i < n; i++) {
            if (arr[i] != arr[i - 1]) {
                result.add(arr[i]); // add only if it's not duplicate
            }
        }

        return result;
    }
}
