class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> s = new Stack<>();
        for(int n : asteroids) {
            boolean destroyed = false;
            while(!s.isEmpty() && s.peek() > 0 && n < 0) {
                if(s.peek() < -n) {
                    s.pop();
                    continue;
                }
                if(s.peek() == -n)
                    s.pop();
                destroyed = true;
                break;
            }
            if(!destroyed) s.push(n);
        }
        int n = s.size();
        int[] res = new int[n];
        for(int i = n-1; i >= 0; i--)
            res[i] = s.pop();
        return res;
    }
}
