class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int low = 0, high = arr.length;
        while(high - low > 1) {
            int mid = low + (high-low) / 2;
            if(arr[mid] < arr[mid+1])
                low = mid;
            else
                high = mid;
        }
        return high;
    }
}
