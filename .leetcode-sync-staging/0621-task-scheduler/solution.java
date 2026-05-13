class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        int maxFreq = 0, countMax = 0;
        for(char task : tasks) {
            int idx = task - 'A';
            freq[idx]++;
            maxFreq = Math.max(maxFreq, freq[idx]);
        }
        for(int f : freq)
            if(f == maxFreq)
                countMax++;
        return Math.max(tasks.length, (maxFreq - 1) * (n + 1) + countMax);
    }
}
