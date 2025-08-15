class Solution {
    static int sort(int arr[], int l, int m, int r) {
        int l1 = m-l+1, l2 = r-m, count = 0;
        int[] arr1 = new int[l1], arr2 = new int[l2];
        for(int i = 0; i < l1; i++) arr1[i] = arr[l+i];
        for(int i = 0; i < l2; i++) arr2[i] = arr[m+1+i];
        int x = 0, y = 0;
        while(x < l1 && y < l2) {
            if((long)arr1[x] > 2L * arr2[y]) {
                count += l1-x;
                y++;
            } else {
                x++;
            }
        }
        int i = 0, j = 0, currIndex = l;
        while(i < l1 && j < l2) {
            if(arr1[i] > arr2[j]) {
                arr[currIndex++] = arr2[j++];
            } else {
                arr[currIndex++] = arr1[i++];
            }
        }
        while(i < l1) arr[currIndex++] = arr1[i++];
        while(j < l2) arr[currIndex++] = arr2[j++];
        return count;
    }
    
    static int merge(int arr[], int l, int r) {
        int m = l + (r-l)/2, count  = 0;
        if(l < r) {
            count = merge(arr, l, m) + merge(arr, m+1, r) + sort(arr, l, m, r);
        }
        return count;
    }

    public int reversePairs(int[] nums) {
        return merge(nums, 0, nums.length-1);
    }
}
