class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a, b) -> (a[0] == b[0]) ? (a[1] - b[1]) : (b[0] - a[0]));
        int len = people.length;
        for(int i = 0; i < len; i++) {
            if(i == people[i][1])
                continue;
            int[] temp = people[i];
            int pos = temp[1];
            for(int j = i; j > pos; j--) 
                people[j] = people[j-1];
            people[pos] = temp;
        }
        return people;
    }
}
