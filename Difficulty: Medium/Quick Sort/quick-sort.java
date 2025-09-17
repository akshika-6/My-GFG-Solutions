class Solution {
    public void quickSort(int[] arr, int l, int r) {
        // code here
        if(l < r){
            int pi=partition(arr,l,r);
            quickSort(arr,l,pi-1);
            quickSort(arr,pi+1,r);
        }
    }

    private int partition(int[] arr, int l, int r) {
        
        // code here
        int pivot=arr[r];
        int i=l-1;
        for(int j=l;j<r;j++){
            if(arr[j] <= pivot){
                i++;
                int temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
            }
        }
        int temp = arr[r];
        arr[r] = arr[i+1];
        arr[i+1]=temp;
        return i+1;
    }
}