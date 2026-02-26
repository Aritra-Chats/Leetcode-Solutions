class Solution {
    public int sumSubarrayMins(int[] arr) {
        long sum = 0;
        long MOD = 1_000_000_007L;
        int[][] se = new int[arr.length][2];
        Stack<Integer> s = new Stack<>();
        for(int i = 0; i < arr.length; i++) {
            se[i][1] = arr.length - i;
            while(!s.isEmpty() && arr[s.peek()] > arr[i]) 
                se[s.peek()][1] = i-s.pop();
            if(s.isEmpty()) se[i][0] = i + 1;
            else se[i][0] = i - s.peek();
            s.push(i);
        }
        for(int i = 0; i < arr.length; i++)
            sum = (sum + (long)arr[i] * se[i][0] * se[i][1]) % MOD;
        return (int)sum;
    }
}
