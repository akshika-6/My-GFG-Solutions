class Solution {
    // Function to sort an array using Heap Sort.
    public void heapSort(int arr[]) {
        // code here
        int n=arr.length;
        for(int i=n/2-1;i>=0;i--){
            heapify(arr,n,i);
        }
        for(int i=n-1;i>=0;i--){
            int temp=arr[0];
            arr[0]=arr[i];
            arr[i]=temp;
            heapify(arr,i,0);
        }
    }
    public static void heapify(int[] arr,int n,int i){
        int lar=i;
        int left=2*i+1;
        int right = 2*i+2;
        if(left < n && arr[left] > arr[lar]){
            lar=left;
        }
        if(right < n && arr[right] > arr[lar]){
            lar=right;
        }
        if(lar != i){
            int swap=arr[lar];
            arr[lar]=arr[i];
            arr[i]=swap;
            heapify(arr,n,lar);
        }
    }
}