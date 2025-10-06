// User function Template for Java

class Solution {
    void rearrange(ArrayList<Integer> arr) {
        // code here
        ArrayList<Integer> pos = new ArrayList<>();
    ArrayList<Integer> neg = new ArrayList<>();

    // ✅ Step 1: Separate positive (including 0) and negative numbers
    for (int i = 0; i < arr.size(); i++) {
        if (arr.get(i) >= 0)
            pos.add(arr.get(i));
        else
            neg.add(arr.get(i));
    }

    // ✅ Step 2: Clear the original array to rebuild in correct order
    arr.clear();

    // ✅ Step 3: Alternate insertion of positive and negative
    int i = 0, j = 0;
    while (i < pos.size() && j < neg.size()) {
        arr.add(pos.get(i++));  // Add positive
        arr.add(neg.get(j++));  // Add negative
    }

    // ✅ Step 4: Add remaining positives or negatives
    while (i < pos.size())
        arr.add(pos.get(i++));
    while (j < neg.size())
        arr.add(neg.get(j++));
    }
}