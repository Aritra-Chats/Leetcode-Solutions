class Solution {
    public int sumSubarrayMins(int[] arr) {
        long sum = 0;
        long MOD = 1_000_000_007L;
        Stack<Integer> s = new Stack<>();
        for(int i = 0; i <= arr.length; i++) {
            while(!s.isEmpty() && ((i == arr.length) || (arr[s.peek()] > arr[i]))) {
                int mid = s.pop(), left = s.isEmpty() ? -1 : s.peek(), right = i;
                sum = (sum + (long)arr[mid] * (mid - left) * (right - mid)) % MOD;
            }
            s.push(i);
        }
        return (int)sum;
    }
}
