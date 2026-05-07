class Solution {
    public int totalFruit(int[] fruits) {
        int len = fruits.length, i = 0, j = 0, count = 0, currCount = 0;
        HashMap<Integer, Integer> map = new HashMap();
        while(j < len) {
            map.put(fruits[j], map.getOrDefault(fruits[j], 0) + 1);
            while(map.size() > 2) {
                map.put(fruits[i], map.get(fruits[i]) - 1);
                if(map.get(fruits[i]) == 0)
                    map.remove(fruits[i]);
                currCount--;
                i++;
            }
            currCount++;
            count = Math.max(count, currCount);
            j++;
        }
        return count;
    }
}
