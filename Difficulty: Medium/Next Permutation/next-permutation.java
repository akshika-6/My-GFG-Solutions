class Solution {
    void nextPermutation(int[] arr) {
        // code here
        int n=arr.length;
        int p=-1;
        for(int i=n-1;i>0;i--){
            if(arr[i-1] < arr[i]){
                p=i-1;
                break;
            }
        }
        if (p == -1) {
            reverse(arr, 0, n - 1);
            return;
        }
        int pivot = arr[p];
        for(int i=n-1;i>p;i--){
            if(arr[i] > pivot){
                swap(arr,i,p);
                break;
            }
        }
        reverse(arr,p+1,n-1);
    }
    void reverse(int[] arr,int left,int right){
        while(left < right){
            int temp = arr[left];
            arr[left]=arr[right];
            arr[right]=temp;
            left++;
            right--;
        }
    }
    void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}