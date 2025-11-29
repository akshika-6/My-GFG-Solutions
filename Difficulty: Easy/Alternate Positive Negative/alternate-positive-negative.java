// User function Template for Java

class Solution {
    void rearrange(ArrayList<Integer> arr) {
        // code here
        ArrayList<Integer> pos=new ArrayList<>();
        ArrayList<Integer> neg=new ArrayList<>();
        int n1=arr.size();
        for(int i=0;i<n1;i++){
            if(arr.get(i) >= 0){
                pos.add(arr.get(i));
            } else {
                neg.add(arr.get(i));
            }
        }
        int p=0,n=0,i=0;
        while(p < pos.size() && n < neg.size()){
            if(i%2 == 0){
                arr.set(i++,pos.get(p++));
            } else {
                arr.set(i++,neg.get(n++));
            }
        }
        while(p < pos.size()){
            arr.set(i++,pos.get(p++));
        }
        while(n < neg.size()){
            arr.set(i++,neg.get(n++));
        }
    }
}