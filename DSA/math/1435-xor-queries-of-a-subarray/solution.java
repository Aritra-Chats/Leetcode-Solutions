class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int[] prefix = new int[arr.length], res = new int[queries.length];
        for(int i = 0; i < arr.length; i++) {
            if(i == 0) {
                prefix[i] = arr[0];
                continue;
            } 
            prefix[i] = prefix[i - 1] ^ arr[i];
        }
        int len = queries.length;
        for(int i = 0; i < len; i++) {
            if(queries[i][0] == 0)
                res[i] = prefix[queries[i][1]];
            else
                res[i] = prefix[queries[i][1]] ^ prefix[queries[i][0] - 1];
        }
        return res;
    }
}
