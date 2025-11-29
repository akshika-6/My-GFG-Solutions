// User function Template for Java

class Solution {
    int maxProduct(int[] arr) {
        // code here
        int n = arr.length;
        if (n < 3) return 0;
        int min1=Integer.MAX_VALUE;
        int min2=Integer.MAX_VALUE;
        int max1=Integer.MIN_VALUE;
        int max2=Integer.MIN_VALUE;
        int max3=Integer.MIN_VALUE;
        for(int num:arr){
            if(num >= max1){
                max3=max2;
                max2=max1;
                max1=num;
            }
            else if(num >= max2){
                max3=max2;
                max2=num;
            }
            else if(num >= max3){
                max3=num;
            }
            if(num <= min1){
                min2=min1;
                min1=num;
            }
            else if(num <= min2){
                min2 = num;
            }
        }
        long p1 = 1L*min1*min2*max1;
        long p2 = 1L*max1*max2*max3;
        return (int)Math.max(p1,p2);
    }
}
