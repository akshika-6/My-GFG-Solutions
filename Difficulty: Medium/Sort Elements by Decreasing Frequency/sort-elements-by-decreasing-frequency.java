// User function Template for Java

class Solution {
    // Function to sort the array according to frequency of elements.
    public ArrayList<Integer> sortByFreq(int arr[]) {
        // add your code here
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : arr) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        
        // Step 2: Put unique elements into a list
        List<Integer> unique = new ArrayList<>(freq.keySet());
        
        // Step 3: Sort unique elements by frequency desc, value asc
        Collections.sort(unique, (a, b) -> {
            int fa = freq.get(a), fb = freq.get(b);
            if (fa != fb) return fb - fa;  // higher freq first
            return a - b;                  // smaller number first
        });
        
        // Step 4: Build result
        ArrayList<Integer> result = new ArrayList<>();
        for (int num : unique) {
            int count = freq.get(num);
            for (int i = 0; i < count; i++) {
                result.add(num);
            }
        }
        
        return result;
    }
}