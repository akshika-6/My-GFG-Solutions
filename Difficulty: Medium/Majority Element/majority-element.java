class Solution {
    int majorityElement(int arr[]) {
        // code here
        int n=arr.length;
        int candidate=-1;
        int c=0;
        for(int num:arr){
            if(c == 0){
                candidate=num;
                c=1;
            }
            else if(num == candidate){
                c++;
            } else{
                c--;
            }
        }
        c=0;
        for(int num:arr){
            if(num == candidate){
                c++;
            }
        }
        if(c > n/2){
            return candidate;
        } else{
            return -1;
        }
    }
}