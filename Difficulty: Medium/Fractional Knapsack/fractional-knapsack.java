class Solution {
    static class Item{
        int value;
        int weight;
        Item(int value,int weight){
            this.value = value;
            this.weight = weight;
        }
    }
    public double fractionalKnapsack(int[] val, int[] wt, int capacity) {
        // code here
        int n = val.length;
        Item[] items = new Item[n];
        for(int i = 0;i<n;i++){
            items[i] = new Item(val[i],wt[i]);
        }
        Arrays.sort(items, (a,b) -> Double.compare((double)b.value/(double)b.weight,
        (double)a.value/(double)a.weight));
        double ans = 0.0;
        for(Item item:items){
            if(capacity >= item.weight){
                ans += item.value;
                capacity -= item.weight;
            } else {
                ans += ((double)item.value/item.weight)*capacity;
                break;
            }
        }
        return ans;
    }
}